# Spark Essentials

## Introduction
Apache Spark is a unified analytics engine for large-scale data processing.  
It provides fast in-memory computation, high-level APIs, and libraries for SQL, machine learning, graph processing, and streaming.

Spark was designed to overcome the limitations of disk-based batch systems such as Hadoop MapReduce, enabling interactive analysis and iterative algorithms on large datasets.

---

## Spark Architecture Overview

A Spark application typically consists of:

- **Driver**: coordinates the execution, defines transformations and actions.
- **Executors**: run tasks on worker nodes and store data in memory or on disk.
- **Cluster manager**: allocates resources (YARN, Kubernetes, standalone, etc.).

Spark follows a **master–worker** architecture and expresses computations as a **DAG (Directed Acyclic Graph)** of stages and tasks.

---

## Core Abstractions

### RDD (Resilient Distributed Dataset)
- Low-level, distributed collection of objects.
- Immutable, partitioned, and fault-tolerant.
- Supports transformations (e.g., `map`, `filter`, `flatMap`) and actions (e.g., `count`, `collect`).

### DataFrames and Spark SQL
- Higher-level abstraction built on top of RDDs.
- Similar to tables in relational databases.
- Schema-aware and optimized by the **Catalyst** query optimizer.
- Exposed through SQL-like operations and DataFrame API.

### Datasets (mainly Scala/Java)
- Strongly typed collections combining RDD-like type safety with DataFrame optimizations.

---

## Laziness, Transformations, and Actions

Spark uses **lazy evaluation**:

- **Transformations** (e.g., `map`, `filter`, `select`) build a logical plan but do not execute immediately.
- **Actions** (e.g., `show`, `count`, `collect`, `save`) trigger execution of the DAG.

This allows Spark to optimize the workflow before running it.

---

## Getting Started with PySpark

### Creating a SparkSession (PySpark)

```python
from pyspark.sql import SparkSession

spark = SparkSession.builder \
    .appName("BigDataCourseExample") \
    .getOrCreate()
```

### Reading Data from HDFS (or Local)

```python
df = spark.read.csv("hdfs:///bigdata/input.csv", header=True, inferSchema=True)
df.printSchema()
df.show(5)
```

---

## Example 1 – WordCount with RDDs

This example mirrors the classic Hadoop MapReduce WordCount but using Spark RDDs.

```python
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("WordCountRDD").getOrCreate()
sc = spark.sparkContext

rdd = sc.textFile("hdfs:///bigdata/input.txt")

word_counts = (
    rdd.flatMap(lambda line: line.split())
       .map(lambda w: (w, 1))
       .reduceByKey(lambda a, b: a + b)
)

for word, count in word_counts.take(10):
    print(word, count)

spark.stop()
```

Key points:
- The code is shorter than the MapReduce version.
- No need to write explicit mapper and reducer scripts.
- The computation is expressed in a functional style.

---

## Example 2 – Aggregations with DataFrames

```python
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, avg

spark = SparkSession.builder.appName("DataFrameAggregations").getOrCreate()

df = spark.read.csv("hdfs:///bigdata/sensor_data.csv",
                    header=True, inferSchema=True)

summary = (
    df.groupBy("sensor_id")
      .agg(avg(col("value")).alias("avg_value"))
)

summary.show(10)

spark.stop()
```

This example shows:
- Loading structured data.
- Grouping and aggregating using the DataFrame API.
- Letting Spark optimize the query via Catalyst.

---

## Caching and Performance

Repeatedly using the same DataFrame or RDD can be expensive. Spark allows caching:

```python
df = spark.read.parquet("hdfs:///bigdata/large_dataset.parquet")

df.cache()
df.count()      # triggers computation and caching
df.filter(df.value > 0).show()
```

Caching is useful in:
- Iterative algorithms (e.g., machine learning)
- Interactive analysis (e.g., notebooks)

Performance tips:
- Prefer DataFrames over RDDs when possible.
- Use appropriate file formats (Parquet, ORC).
- Avoid unnecessary `collect()` on large datasets.

---

## Spark vs. Hadoop MapReduce

| Aspect | Hadoop MapReduce | Apache Spark |
|-------|------------------|--------------|
| Execution | Disk-based between stages | In-memory between stages |
| Speed | Generally slower | Often much faster |
| Programming Model | Map + Reduce | Rich APIs: RDD, DataFrames, SQL, ML, Streaming |
| Workloads | Batch | Batch, streaming, iterative algorithms |

In modern Big Data architectures:
- **HDFS (or another distributed store)** provides storage.
- **Spark** is the main processing engine.

---

## Simple Streaming Example (Structured Streaming – Conceptual)

A minimal example of processing a stream of data (e.g., logs or sensor values):

```python
from pyspark.sql import SparkSession
from pyspark.sql.functions import split, explode

spark = SparkSession.builder.appName("StructuredStreamingExample").getOrCreate()

lines = spark.readStream.format("socket") \
    .option("host", "localhost") \
    .option("port", 9999) \
    .load()

words = lines.select(
    explode(
        split(lines.value, " ")
    ).alias("word")
)

word_counts = words.groupBy("word").count()

query = word_counts.writeStream \
    .outputMode("complete") \
    .format("console") \
    .start()

query.awaitTermination()
```

This example illustrates:
- Reading from a streaming source.
- Applying the same DataFrame operations used in batch mode.
- Continuously updating results in the console.

---

## Summary

Spark is a powerful, general-purpose engine for Big Data processing that:

- Provides fast, in-memory analytics.
- Offers high-level APIs (DataFrames, SQL, MLlib, Structured Streaming).
- Integrates seamlessly with HDFS and other storage systems.

Understanding Spark is essential for modern data engineering and data science workflows.

