# Distributed Systems Fundamentals

## Introduction  
A distributed system is a collection of independent machines that appear to users as a single coherent system. Distributed systems enable scalability, availability, and fault tolerance for data and computation.

## Motivation for Distributed Systems  
- Overcoming single-machine storage and computation limits    
- Improving performance through parallelism    
- Enhancing availability and fault tolerance    
- Supporting large-scale data processing    

## Key Characteristics  
### Transparency  
Distributed systems aim to hide complexity:   
- **Location transparency**    
- **Replication transparency**   
- **Concurrency transparency**  

### Scalability  
Systems can grow horizontally by adding nodes. Key scalability challenges include metadata management and network bottlenecks.

### Fault Tolerance  
Nodes may fail independently. Replication and redundancy ensure system reliability.

## Consistency Models  
Distributed systems must deal with data consistency:  
- **Strong consistency**: All nodes see the same data instantly.    
- **Eventual consistency**: Updates propagate asynchronously.    
- **CAP theorem** trade-offs (Consistency, Availability, Partition tolerance).  

## Replication and Partitioning Fundamentals  
- Replicated data increases availability but adds coordination cost.    
- Partitioning distributes data across nodes to improve scalability.    

## Network Considerations  
Performance depends heavily on network latency and throughput:  
- Communication overhead    
- Data transfer bottlenecks    
- Impact on distributed computation tasks    

## Data Locality  
Moving computation to the data is generally more efficient than moving data over the network. This principle is essential in systems like Hadoop and Spark.  
