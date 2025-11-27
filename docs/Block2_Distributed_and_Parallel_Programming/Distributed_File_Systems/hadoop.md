# Hadoop Essentials

## Introduction
Hadoop is an open-source framework designed for distributed storage and batch processing of large datasets.  
It was created to address the limitations of single-machine computing and was inspired by technologies such as the Google File System (GFS) and the MapReduce programming model.

Hadoop became the foundation of the early Big Data ecosystem by enabling scalable, fault‑tolerant processing across clusters of commodity machines.

---

## Core Components

### **HDFS (Hadoop Distributed File System)**
A distributed, fault-tolerant file system designed to store very large files across multiple machines.

### **YARN (Yet Another Resource Negotiator)**
The cluster manager responsible for scheduling and allocating resources for distributed applications.

### **MapReduce**
A programming model for large-scale batch processing using:  
- **Map**: parallel processing of data blocks    
- **Shuffle**: grouping intermediate key-value pairs    
- **Reduce**: aggregating results    

---

## HDFS Basics

### **Architecture**
- **NameNode**: manages metadata (namespace, file locations)
- **DataNodes**: store actual data blocks
- **Secondary NameNode**: periodically merges metadata snapshots (not a backup NameNode)

### **Blocks and Replication**  
- Default block size: 128 MB or 256 MB    
- Default replication factor: 3    
- Replication ensures fault tolerance and availability  

### **Fault Tolerance**  
If a DataNode fails, HDFS reconstructs missing replicas automatically.

### **When to Use HDFS**  
- Large, sequential reads    
- Batch computations    
- Write-once, read-many workloads    

---

## MapReduce Overview

MapReduce structures processing into two main steps:

### **Map Phase**
Takes input data and transforms it into intermediate key-value pairs.

### **Shuffle Phase**
Redistributes intermediate data to group identical keys.

### **Reduce Phase**
Aggregates or processes all values associated with a key.

---

## Practical Examples

### **Example 1: Basic HDFS Commands**

Create a directory:
```
hdfs dfs -mkdir /bigdata
```

Upload data:
```
hdfs dfs -put localfile.txt /bigdata/
```

List files:
```
hdfs dfs -ls /bigdata
```

Read a file:
```
hdfs dfs -cat /bigdata/localfile.txt
```

### **Example 2: WordCount with Hadoop Streaming (Python)**

**mapper.py**
```python
import sys

for line in sys.stdin:
    for word in line.strip().split():
        print(f"{word}	1")
```

**reducer.py**
```python
import sys

current = None
count = 0

for line in sys.stdin:
    word, n = line.strip().split("\t")
    n = int(n)
    if word == current:
        count += n
    else:
        if current:
            print(f"{current}\t{count}")
        current = word
        count = n

if current:
    print(f"{current}\t{count}")
```

Run the job:
```
hadoop jar /usr/lib/hadoop-mapreduce/hadoop-streaming.jar   -input /bigdata/input.txt   -output /bigdata/output   -mapper mapper.py   -reducer reducer.py
```

### **Example 3: Scalability Experiment (Suggested)**

Students can:

- Process files of increasing sizes (e.g., 1 GB → 5 GB → 10 GB)    
- Measure execution time   
- Analyze:

  - Impact of block size
  - Network overhead during shuffle
  - Influence of slow nodes (stragglers)

---

## Hadoop vs. Spark (Context for Next Topic)
| Aspect | Hadoop MapReduce | Apache Spark |
|-------|------------------|--------------|
| Processing Model | Disk-based | In‑memory |
| Speed | Slower | Up to 100× faster |
| API | Low-level | High-level (RDD, DataFrames) |
| Use Cases | Large batch jobs | Batch + streaming + ML |

Modern architectures often use:
- **HDFS for storage**
- **Spark as the compute engine**

---

## Summary
Hadoop provides the foundation for scalable, fault-tolerant storage and processing.  
Its relevance today is strongest in:
- Distributed storage (HDFS)
- Legacy batch workloads
- Infrastructure for Spark clusters

Hadoop remains an essential conceptual framework for understanding Big Data systems.

