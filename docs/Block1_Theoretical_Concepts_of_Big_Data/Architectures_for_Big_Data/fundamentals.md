# Fundamentals for Big Data Architectures

## Motivation and Challenges in Big Data

### The Data Explosion

In recent years, there has been a dramatic increase in the amount of data generated from digital services, social media, Internet of Things (IoT) devices, enterprise applications, scientific computing, and automation systems. This phenomenon, often referred to as the **data deluge**, has surpassed the processing, storage, and analytical capabilities of traditional computing infrastructures.

This growth is **exponential**, influenced by:  
- Continuous digitalization of business processes.  
- Proliferation of connected devices and sensors.  
- Increased need for real-time monitoring and decision-making.  
- Generation of detailed logs for observability and auditing.  

### The “V” Characteristics of Big Data

Big Data is commonly described using five core properties:

| V | Description | Example |
|---|-------------|---------|
| **Volume** | Massive amount of data | Millions of transactions or user events |
| **Velocity** | Speed at which data is generated and processed | Real-time analytics or fraud detection |
| **Variety** | Different data formats and structures | Structured tables, JSON, images, logs |
| **Veracity** | Reliability and quality of data | Noisy or incomplete sensor readings |
| **Value** | Ability to extract useful knowledge | Predictive maintenance, business insights |

### Limitations of Traditional Systems

Traditional database and processing architectures rely on: 

- A single centralized server.  
- Local storage on disk.  
- Sequential or limited parallel processing.  

These systems face several issues when scaling: 

- **Performance bottlenecks** in CPU, memory, and I/O.  
- **Vertical scalability limits** (hardware upgrades are costly and reach physical limits).  
- **Single points of failure**, reducing reliability.  
- Inability to efficiently handle unstructured data or real-time workloads.  

### Need for New Architectural Approaches

To address these challenges, Big Data systems are designed to: 

- **Distribute data across many nodes**.  
- **Process tasks in parallel**.  
- **Scale horizontally** by adding more machines when demand increases.  

This shift requires both new **computational models** and new **storage strategies**, which are covered in the next sections.  

---

<details>
<summary>Architecture Common Blocks</summary>
<p><strong>Data ingestion:</strong>The process of collecting and importing data from various sources into a system where it can be stored, processed, and analyzed.</p>
<p><strong>Storage</strong> (data lakes, distributed systems)</p>
<p><strong>Processing</strong> (batch and/or streaming)</p>
<p><strong>Access, querying, and analytics</strong></p>
<p><strong>Governance and metadata:</strong>The set of processes and information that ensure data is properly managed, understood, secured, and used consistently across the organization.</p>
</details>

---

## Fundamentals of Distributed Computing

### What Is a Distributed Architecture?

A distributed computing architecture is a system where multiple networked machines (nodes) cooperate to perform computational tasks as if they were a single logical system. Each node typically contributes:  
- CPU resources  
- Memory  
- Storage  
- Network communication capabilities  

The goals are:

- **Scalability**  
- **Fault tolerance**  
- **High throughput**  

### Models of Parallel and Distributed Computation

| Model | Description | Suitability for Big Data |
|-------|-------------|-------------------------|
| **SMP (Symmetric Multiprocessing)** | Multiple processors share the same memory. | Limited scalability; vertical scaling only. |
| **MPP (Massively Parallel Processing)** | Each node has its own CPU and memory, and processes partitions in parallel. | Highly suitable for distributed analytics. |
| **COW (Cluster of Workstations)** | Independent machines connected by a network form a compute cluster. | Foundation of Hadoop and Spark clusters. |
| **DSM (Distributed Shared Memory)** | Distributed memory is abstracted as a single shared space. | Complex to implement at large scale. |

### Concurrency vs Parallelism

- **Concurrency** refers to multiple tasks being managed at the same time.
- **Parallelism** refers to tasks being processed simultaneously.

Big Data processing aims to **maximize parallelism** by distributing both data and computation across nodes.

### Latency and Throughput

| Metric | Goal | Typical Use Case |
|--------|------|------------------|
| **Latency** | Reduce response time | Real-time monitoring and alerts |
| **Throughput** | Maximize total processed data | Batch analytical jobs |

Batch systems focus on throughput; streaming systems focus on latency.

### Amdahl’s Law and Scalability Limits

**Amdahl’s Law** states that the maximum performance improvement of a system by parallelization is limited by the portion of the process that cannot be parallelized.  
This implies that:  
- Adding more nodes does **not always** yield proportional speedups.  
- Efficient Big Data systems require algorithms designed for distributed execution.  

### Virtualization and Containers

| Technology | Virtualizes | Advantages | Examples |
|-----------|------------|------------|----------|
| **Hypervisor-based virtualization** | Hardware | Strong isolation | VMware, KVM |
| **Containers** | Operating system | Fast startup, resource efficiency | Docker, Podman |

Containers enable reproducibility, portability, and lightweight deployment.

### Container Orchestration with Kubernetes

Key concepts:

- **Pod**: Minimum deployable execution unit.  
- **Node**: A machine (virtual or physical) in the cluster.  
- **Cluster**: Set of coordinated nodes.  
- **HPA (Horizontal Pod Autoscaler)**: Scales the number of Pod replicas.  
- **VPA (Vertical Pod Autoscaler)**: Adjusts CPU/memory per Pod.  

Kubernetes is widely used to deploy and scale distributed data platforms.

### Cloud Computing Models

| Model | Level of Abstraction | Examples |
|------|----------------------|----------|
| **IaaS (Infrastructure as a Service)** | Virtual machines and networks | AWS EC2, Google Compute Engine |
| **PaaS (Platform as a Service)** | Managed execution environments | AWS Lambda, Google App Engine |
| **SaaS (Software as a Service)** | Complete applications | Salesforce, Office 365 |

Cloud environments are now the standard for scaling Big Data workloads dynamically.

---

## Fundamentals of Scalable Storage and Databases

### Challenges of Traditional Storage

Single-server storage suffers from:  
- Limited capacity and performance  
- High expansion cost  
- Risk of catastrophic data loss  

### In-Memory Databases

In-memory databases store data in RAM to reduce latency and accelerate query processing.

**Advantages**
- Extremely fast read and write operations.

**Disadvantages**
- RAM is volatile → persistent logging to disk is required.

**Examples:** Redis, Hazelcast, SAP HANA.

### Row-Oriented vs Column-Oriented Storage

| Model | Best suited for | Workload type | Examples |
|-------|----------------|---------------|----------|
| **Row-store** | Transactional systems | OLTP | PostgreSQL, MySQL |
| **Column-store** | Analytical processing | OLAP | Parquet, ORC, Vertica |

### Persistence: Logging and Snapshots

- **Snapshots** periodically store a full copy of the in-memory state.
- **Write-ahead logs** capture operations sequentially for recovery.

### Distributed File Systems

| System | Architecture | Scalability | Suitable for Big Data |
|--------|--------------|------------|-----------------------|
| **NFS (Network File System)** | Centralized | Limited |  No |
| **HDFS (Hadoop Distributed File System)** | Replicated block storage | High |  Yes |
| **Object Storage (e.g., S3, GCS, Azure Blob)** | Flat namespace with HTTP API | Very high | Yes |

### Fault Tolerance and Replication

Distributed storage systems implement:  
- **Data replication** across multiple nodes.  
- **Automatic rebalancing** when nodes fail.  

These mechanisms are essential for reliability in Big Data environments.

---
