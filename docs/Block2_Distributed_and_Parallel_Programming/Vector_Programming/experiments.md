# Experiments  -  Vector Programming

## Introduction

![Robert Noyce](robertnoyce.png "Robert Noyce")

> *“Optimism is an essential ingredient for innovation” — Robert Noyce (1927–1990)*  

## Brief Biography  

Robert Noyce was an American engineer and inventor credited as the co-inventor of the integrated circuit, a breakthrough that launched the modern electronics era. In 1968 he co-founded Intel Corporation, where he helped pioneer the microprocessor revolution. Known as the “Mayor of Silicon Valley,” he played a key role in shaping the region’s culture of innovation and open collaboration. Noyce combined technical brilliance with visionary leadership, inspiring generations of engineers. His contributions transformed computing and laid the foundation for today’s digital world.

---

This section presents a series of experiments aimed at evaluating the performance of vector-based computations using GPUs. The goal is to measure the speedup obtained when performing matrix multiplication through different Java libraries capable of exploiting massive GPU parallelism.

---

## Hardware Environment

The experiments were executed using the following GPU:

### NVIDIA GeForce GTX 1650 (Laptop Version)
- CUDA-based architecture  
- Capable of executing thousands of threads in parallel  
- Supports both *scalar cores* and *tensor cores*, depending on the programming model

---

## Experimental Setup

Two different GPU programming approaches in Java were evaluated:

### ● APARAPI (Scalar Cores)
- Executes Java kernels directly on the GPU  
- Only uses the GPU's scalar cores

### ● JCublas (Tensor Cores)
- Java bindings for cuBLAS, NVIDIA’s high-performance linear algebra library  
- Enables the use of tensor cores, specialized in matrix multiplication

### Benchmark Problem
- Matrix multiplication of size **1024 × 1024**

---

## Execution Results

### APARAPI (Scalar Cores)
- **Execution time:** 202 ms  
- **Speedup over the sequential version:** ×37  

APARAPI leverages massive thread parallelism, achieving a notable improvement despite relying solely on scalar cores.

---

### JCublas (Tensor Cores)
- **Execution time:** 0.53 seconds  
- **Speedup over the sequential version:** ×143  

Thanks to the use of tensor cores—hardware specifically optimized for matrix operations—JCublas achieves significantly higher acceleration for this workload.

---

## Comparison and Analysis

- **Scalar cores vs. Tensor cores**  
  Tensor cores are designed to maximize throughput in matrix operations, which explains the superior speedup achieved with JCublas.

- **Performance and efficiency**  
  JCublas clearly outperforms APARAPI for highly vectorizable workloads such as matrix multiplication.  
  APARAPI is easier to program and more general-purpose, but cannot match the performance of specialized tensor hardware.

- **Programming cost**  
  While JCublas requires deeper integration with the CUDA ecosystem, the performance gains justify the effort for numerical workloads.

---

## Conclusions

- GPU execution yields substantial performance improvements over sequential computation.  
- Tensor cores provide exceptional acceleration for matrix-based operations.  
- APARAPI and JCublas represent complementary approaches to GPU programming in Java.  
- Final performance depends on the algorithm, the GPU architecture, and the degree of vectorization.

---
