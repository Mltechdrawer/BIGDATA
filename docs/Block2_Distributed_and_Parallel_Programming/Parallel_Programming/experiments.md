# Experiments - Parallel Programming

## Introduction

![Edger Dijstra](edgerdijstra.png "Edger Dijstra")

> *“Simplicity is a great virtue, but it requires hard work to achieve it and education to appreciate it. - Edger Dijkstra (1930-2002)*  

## Brief Biography  

Edsger Dijkstra was a Dutch computer scientist whose work fundamentally shaped modern programming and algorithm design. He contributed seminal ideas such as shortest-path algorithms, semaphore-based mutual exclusion, and structured programming principles, including his influential essay “Go To Statement Considered Harmful” (1968). A pioneer of formal methods, he advocated mathematical rigor in software development and education. His clarity of thought and emphasis on simplicity transformed computer science into a more disciplined field. Dijkstra’s legacy continues to guide algorithmic theory, operating systems, and programming methodology.

---

Experiments in parallel programming provide a practical way to observe how performance changes when a computational problem is executed using multiple cores or threads. They help identify performance gains, understand the limits of parallelization, and reveal typical errors such as race conditions and improper task decomposition.

This section explores:  
- Sequential vs parallel execution.  
- Issues that arise when parallelizing tasks.  
- How race conditions occur in shared-memory programs.  
- Performance improvements achieved through parallel execution.  

---

## Sequential vs Parallel Execution: Matrix Multiplication Example
Matrix multiplication is a classic benchmark for comparing sequential and parallel computation.

Using a **1024×1024 matrix multiplication**:

### Sequential Version
- Executes one instruction after another.
- Total running time: **7.66 seconds**.
- No concurrency: only one operation runs at any moment.

### Parallel Version (Java Parallel Streams or Threads)
- Distributes the computation across multiple cores.
- Running time: **~151 ms**.
- Approximately **50× faster** than the sequential version.
- Effectiveness depends on hardware capabilities (number of physical and virtual cores).

---

## Why Parallelization May Fail

Even when using built-in parallel APIs, parallel execution can fail or provide incorrect results due to:

### Data Dependencies
Many algorithms rely on previous partial results.  
If two threads attempt to update the same location concurrently, the outcome becomes unpredictable.

### Implicit Sequential Constraints
Some tasks appear parallelizable but internally require strict execution order:  
- Dependencies between iterations.  
- Shared accumulators or shared variables.  
- Operations that must serialize due to algorithmic constraints.  

As a result, a program may *look* parallel but still run sequentially or produce wrong results.

---

## Sequential Instruction Execution
The document illustrates the low-level execution of matrix multiplication using instruction-like steps:

- Load values from matrices `a` and `b`.
- Multiply them and compute a partial result.
- Load and update value in matrix `c`.
- Store the updated result.

In sequential execution, the order is guaranteed. In parallel execution, multiple threads may attempt to:  
- Load the same memory location.  
- Overwrite each other’s updates.  
- Use stale values when updating matrix `c`.  

This leads directly to race conditions.

---

## Race Conditions

A **race condition** occurs when two or more threads access shared data simultaneously, and the final outcome depends on the unpredictable order of execution.

Example from the document:  
- Bank account with 50€.  
- Two operations try to withdraw money at the same time.  
- If both threads read the balance before either writes it back, inconsistent results occur (e.g., withdrawal approved when it should be denied).  

Race conditions arise when:  
- Updating shared matrices.  
- Using shared counters or accumulators.  
- Threads modify shared state without synchronization mechanisms.  

---

## Performance Results

On an **Intel i9-9980HK @ 2.40GHz**, the experiments show:

| Approach                  | Running Time | Speedup |
|--------------------------|--------------|---------|
| Sequential               | 7.66 seconds | 1×      |
| Java Parallel Streams    | ~151 ms      | ~50×    |
| Java Threads             | ~150 ms      | ~50×    |

Key observations:  
- Parallel streams and threads deliver similar performance.  
- The CPU's multi-core architecture is essential for speedup.  
- Performance benefits only arise when tasks can be safely decomposed.  

---

## Lessons Learned

1. **Parallelization requires algorithmic independence.**  
   Not all tasks can be parallelized effectively.

2. **Shared memory without protection leads to race conditions.**  
   Synchronization is mandatory when updating shared state.

3. **Hardware matters.**  
   Speedup depends on number of physical/virtual cores and multithreading.

4. **Correctness comes before performance.**  
   A parallel program that produces incorrect results is useless.

5. **Understanding task decomposition is essential.**  
   Only the parallelizable fraction of the program determines the possible speedup.

---

