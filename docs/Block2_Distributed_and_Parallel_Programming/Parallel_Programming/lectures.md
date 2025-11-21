# Lectures - Parallel Programming  

## Introduction

![Gordon Moore](gordonmoore.png "Gordon Moore")

> *“Failures are not something to be avoided” — Gordon Moore (1929-)* 

## Brief Biography  

Gordon Moore was an American engineer and entrepreneur best known as the co-founder of Intel Corporation and the author of Moore’s Law, the prediction that the number of transistors on a chip would double approximately every two years. His insight became a guiding principle for the semiconductor industry and shaped the exponential growth of computing power for decades. Moore played a pivotal role in advancing integrated circuit technology and driving innovation in microprocessors. Beyond engineering, he was also a prominent philanthropist, supporting science, conservation, and education. His vision continues to influence modern hardware design and technological development.

---

Understanding parallel programming requires a clear distinction between foundational concepts such as concurrency, parallelism, communication costs, and the architecture of modern processors. This section introduces the theoretical principles that support the design and execution of parallel programs and provides the framework needed to understand performance, scalability, and potential bottlenecks.  

---

## Concurrency vs Parallelism  

### Concurrency  
Concurrency means that multiple tasks *can* be in progress at the same time, but not necessarily executed simultaneously.    
A concurrent application:  
- Handles many tasks that can overlap in time.  
- May run tasks on a single core by interleaving execution.  
- Improves responsiveness but not necessarily throughput.  

### Parallelism
Parallelism means that multiple tasks are executed at the *same instant* on different processors or cores.    
A parallel application:  
- Requires multiple physical or virtual cores.  
- Can achieve real speedup through simultaneous execution.  

**Key idea:**  
> All parallel programs are concurrent, but not all concurrent programs are parallel.  

---

## Communication: Latency and Throughput

Understanding communication performance is essential when designing distributed or multicore parallel programs.  

### Latency  
The time required to send a minimal message from point A to point B.    
It measures *delay*.  

### Throughput    
The amount of data that can be transmitted per unit of time.    
It measures *capacity*.  

These two metrics often trade off against each other.    
High throughput does not imply low latency, and vice versa.  

---

## Parallel Computers: Physical and Virtual Cores

Modern CPUs consist of:  
- **Physical cores**: actual processing units inside the CPU.  
- **Virtual cores / hardware threads**: created using multithreading or hyperthreading techniques.  

A single physical core can appear as two virtual cores by duplicating sets of processor registers.    
This allows:  
- Better resource utilization.  
- Increased parallelism when tasks involve I/O or wait states.  

However:  
- Virtual cores do not double performance.  
- They improve efficiency but depend heavily on task type.  

---

## Serial Execution

A serial program:  
- Runs on a single core.  
- Executes one instruction at a time.  
- Cannot take advantage of multicore architectures.  

Characteristics:  
- Simple program design.  
- Predictable flow.  
- Limited performance as data size increases.  

---

## Parallel Execution

To run a program in parallel:  
1. **Partitioning**: the problem must be decomposed into independent subproblems.    
2. **Execution**: each subproblem is assigned to a core or thread.    
3. **Synchronization** (if shared memory is used):    
   Necessary to ensure correct updates to shared data.  

Parallel execution improves performance only if:  
- Tasks are sufficiently independent.  
- Communication overhead remains low.  
- Work is evenly distributed among cores.  

---

## Designing Parallel Programs

### Embarrassingly Parallel Problems
These require little or no coordination between tasks.    
Common examples:  
- Monte Carlo simulations    
- Numerical integration    
- Mandelbrot set calculations    
- Genetic algorithms    
- Discrete Fourier Transform    

They scale extremely well across cores.  

---

### Scalability
Scalability describes how performance improves as more cores are added.  

Challenges:
- Many algorithms require coordination between tasks.  
- Communication overhead becomes dominant as the number of cores increases.  
- Memory contention and synchronization reduce effective parallelism.  

---

### Amdahl’s Law

Amdahl’s Law predicts the maximum speedup of a program given:  
- The fraction that can be parallelized (tₚ).  
- The number of processors (N).  

Speedup is limited by the serial portion of the program.  

If a program is:  
- 90% parallelizable    
- 10% serial    
Even with infinite processors, maximum speedup ≈ 10×.  

Thus:  
> Adding more cores is not always the answer.  

---

## Race Conditions  

A **race condition** occurs when multiple tasks access shared data without proper synchronization, causing unpredictable results.  

Example:  
- Two threads updating the same bank account balance.  
- Final outcome depends on which thread writes last.  
- Leads to inconsistent or incorrect values.  

Race conditions must be addressed through:  
- Mutual exclusion (locks, semaphores)  
- Atomic operations  
- Critical sections  

---

## Memory Models  

### Shared Memory Model  
- Processes share the same address space.  
- Communication happens through memory writes/reads.  
- Requires explicit synchronization to avoid race conditions.  

#### Synchronization mechanisms:  
- **Locks**: enforce mutual exclusion.  
- **Critical sections**: only one thread executes the protected block.  
- **Atomic operations**: guarantee indivisible updates on specific variables.  

### Distributed Memory Model  
- Each process has its own separate memory.  
- Communication occurs via **message passing**.  
- No shared variables.  

#### Message passing properties:  
- Sender chooses what, when, and where to send.  
- Receiver must actively read the data.  
- No timeouts: blocking calls may wait indefinitely.  
- Includes synchronous (blocking) and asynchronous (non-blocking) communication.  

---

## Deadlocks

A **deadlock** occurs when two or more processes wait indefinitely for resources held by each other.  

Typical pattern:  
- Process A holds resource X and waits for Y.  
- Process B holds resource Y and waits for X.  
- Neither process can proceed.  

Deadlocks must be prevented by:  
- Resource ordering.  
- Avoiding circular waits.  
- Using timeouts or deadlock detection mechanisms.  

---

### Shared vs Distributed Memory Overview

### Shared Memory  
- Efficient for tightly coupled parallel tasks.  
- Requires careful synchronization.  
- Suitable for multicore systems.  

### Distributed Memory  
- Scales to large clusters.  
- Avoids contention but introduces communication overhead.  
- Suitable for high-performance computing (HPC).  

---

## Foster’s Methodology (PCAM)  

A structured method for designing parallel programs:  

1. **Partitioning**:    
   Break the problem into small independent tasks.  

2. **Communication**:    
   Define communication patterns among tasks.  

3. **Agglomeration**:    
   Group tasks to reduce communication overhead and improve performance.  

4. **Mapping**:    
   Assign grouped tasks to physical cores or processors to maximize utilization.  

---

## Granularity  

Granularity refers to the size and number of tasks:  

### Fine-grained  
- Many small tasks.  
- High communication overhead.  
- Useful when tasks are truly independent.  

### Coarse-grained  
- Fewer, larger tasks.  
- Lower communication cost.  
- Typically more efficient for real systems.  

---

## Load Balancing  

Load balancing distributes work evenly across cores.  

### Static Load Balancing  
- Distribution determined before execution.  
- Works well when tasks are predictable.  

### Dynamic Load Balancing  
- Work is assigned during execution.  
- Adapts to unpredictable workloads.  
- More flexible but introduces runtime overhead.  

---

