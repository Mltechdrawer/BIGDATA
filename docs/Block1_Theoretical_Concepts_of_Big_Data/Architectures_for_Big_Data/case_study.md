# Case Studies for Big Data Architectures

Practical case studies to apply the architectural concepts learned in the course:  
- The first one focuses on **Apache Spark** in a Lakehouse context.  
- The second one focuses on **Apache Flink** and event stream processing following the Kappa Architecture model.  

---

## Case Study 1: Agricultural IoT Sensor Analytics with Apache Spark (Lakehouse Model)  

### Scenario  

A smart agriculture company monitors environmental variables (temperature, humidity, soil moisture, sunlight levels) using thousands of IoT sensors deployed across farmlands.    
Sensors send measurements every **10 seconds**, generating millions of data records per day.  

The company needs:  
- **Real-time alerts** for abnormal readings.  
- **Daily analytics** to detect patterns affecting crop yield.  
- A **single data storage layer** supporting BI dashboards and ML models.  

### Learning Objectives

After completing this case, students should be able to:  
- Design a **Lakehouse-based architecture** with unified storage.  
- Implement data ingestion from streaming and batch sources.  
- Use **Spark** for both batch and structured streaming operations.  
- Apply data refinement through Bronze → Silver → Gold layers.  

### Proposed Architecture  

![Lakehouse Architecture](lakehouse.png)  

| Layer | Storage / Tool | Purpose |
|------|----------------|---------|
| Bronze | S3 / HDFS raw zone | Store raw ingested sensor events |
| Silver | Delta Lake / Iceberg | Clean, normalize, deduplicate data |
| Gold | Delta Lake curated tables | Aggregated metrics for dashboards and ML |
| Processing | Apache Spark (batch + streaming) | ETL, feature engineering, anomaly detection |
| Serving | Power BI / Superset | Visualization and reporting |

### Student Tasks

1. **Data Ingestion**
   - Simulate streaming input using Kafka or a file source with incremental append.  
   - Write raw input to the **Bronze** table.  

2. **Data Cleaning and Normalization**  
   - Use Spark DataFrames to:  
     - Convert timestamps  
     - Remove duplicated records  
     - Standardize measurement units  
   - Store cleaned data in the **Silver** table.  

3. **Analytical Aggregation**  
   - Compute hourly averages and anomalies per sensor.  
   - Save aggregated results to the **Gold** table.  

4. **Visualization**  
   - Create a dashboard to monitor:  
     - Temperature trends over time  
     - Sensor malfunction detection  
     - Real-time anomaly alerts  

### Reflection Questions

- What benefits does the **Bronze → Silver → Gold** model bring to maintainability?  
- How does Delta Lake’s transaction log improve reliability?  
- Could this design be migrated to a cloud-native environment without architectural changes?  

---

## Case Study 2: Real-Time Traffic Monitoring with Apache Flink (Kappa Architecture)

### Scenario  

A transportation authority wants to analyze **live vehicle traffic** across a city to:  
- Detect traffic congestion in real time.  
- Trigger automatic notifications to road signage systems.  
- Identify long-term traffic flow patterns.  

Data is streamed continuously from thousands of road sensors detecting:  
- Vehicle count  
- Average speed  
- Road segment ID  
- Timestamp  

### Learning Objectives  

Students should be able to:  
- Apply **Kappa Architecture** principles.  
- Use **Apache Flink** for real-time stream processing.  
- Maintain stateful event processing pipelines.  
- Generate materialized views for real-time dashboards.  

### Proposed Architecture  

![Kappa Architecture](kappa.png)  

| Component | Tool | Purpose |
|----------|------|---------|
| Log Storage | Apache Kafka | Durable ordered event log (system of record) |
| Stream Processing Engine | Apache Flink | Real-time computation and state management |
| Serving Storage | Cassandra / Elasticsearch | Low-latency access to computed metrics |
| Visualization | Grafana | Real-time analytics dashboard |

### Student Tasks  

1. **Ingest Data Stream**  
   - Consume JSON events from Kafka.  
   - Define event schema in Flink.  

2. **Real-Time Aggregation**  
   - Compute:  
     - Vehicles per road segment (per minute)  
     - Average speed over sliding windows  

3. **Anomaly Detection**  
   - Identify abnormal congestion (speed < threshold && count > threshold).  
   - Trigger notification events for downstream systems.  

4. **Materialized View Output**  
   - Write aggregated results to Cassandra or Elasticsearch.  
   - Build a real-time dashboard using Grafana.  

### Reflection Questions

- How does Flink maintain reliable state over long-running streaming jobs?
- Why is the event log (Kafka) considered the **single source of truth** in Kappa Architecture?
- What challenges arise when reprocessing events by replaying logs?

---

## Final Comparison Between the Two Cases

| Case | Architecture Model | Processing Engine | Best for |
|------|------------------|------------------|---------|
| IoT Agriculture (Spark) | Lakehouse | Batch + Streaming (Spark) | Combined historical + real-time analytics |
| Traffic Monitoring (Flink) | Kappa | Streaming-only (Flink) | Low-latency continuous event processing |

---


