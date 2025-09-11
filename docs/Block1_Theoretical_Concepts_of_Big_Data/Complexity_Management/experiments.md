# Experiments – Complexity Management

---

## Introduction

![James Goslin](JamesGoslin.png "James Goslin")

> *“There are a lot of ways known to do it wrong and which one is right is not clear.”*  
— James Gosling (1955–)

Complexity in computation is not only about algorithms but also about **implementation choices**, **programming languages**, and **hardware utilization**.  
This experiment explores **matrix multiplication** as a case study to analyze performance differences across programming languages and approaches.

---

## Reminder: Matrix Multiplication

![Matrix Multiplication](matrixmult_1.png "Matrix Multiplication")


If **A** and **B** are `n × n` matrices, their product **C = AB** is also an `n × n` matrix. Each element of the resulting matrix is obtained by combining a row of **A** with a column of **B**.

Formally:

![Matrix Multiplication](matrixmult_2.png "Matrix Multiplication")

\[
C[i,j] = \sum_{k=1}^n A[i,k] \cdot B[k,j]
\]

This operation is fundamental in scientific computing, graphics, and machine learning, but it is also **computationally intensive**, requiring **O(n³)** operations in its naïve form.

---

## Algorithm (Naïve Approach)

![Matrix Multiplication](matrixmult_3.png "Matrix Multiplication")


Pseudocode of the classic algorithm:

![Pseudocode](pseudocode.png "Pseudocode")

### Python ###

![Python](Python.png "Python")

Running time 409.45 seconds with 1024 x 1024 matrices


### Rust ###

![Rust](Rust.png "Rust")

Running time 7.91 second with 1024 x 1024 matrices


### Java ###

![Java](Java.png "Java")

Running time 7.76 seconds with 1024 x 1024 matrices

<span class="text-red">52x faster than python</span>

### C ###

![C](C.png "C")

Running time 0.677867 seconds with 1024 x 1024 matrices

<span class="text-red">11x faster than java</span>

### TIOBE Programming Community Index ###

![Tiobe](Tiobe.png "Tiobe")

The image represents the TIOBE Programming Community Index, which measures the relative popularity of programming languages over time. It does not indicate the best language but rather the most used and most visible in the global developer community, based on search engines, courses, and vendors.

<details>
<summary>💡 Details</summary>
<p><strong>Java (green):</strong> Dominated the early 2000s with more than 25% share but has steadily declined, although it remains highly relevant.</p>
<p><strong>C (black):</strong> Extremely stable and consistently strong, often alternating with Java in the top positions.</p>
<p><strong>Python (light blue):</strong> Shows explosive growth after 2015, becoming the most popular language since 2020. This reflects the rise of data science, machine learning, and artificial intelligence.</p>
<p><strong>C++ (orange):</strong> Popular in the early 2000s, now stabilised at around 8–10%.</p>
<p><strong>C# (dark blue):</strong> Grew quickly with the .NET ecosystem in the 2000s and maintains a solid mid-level share.</p>
<p><strong>PHP (aqua):</strong> Very popular in web development between 2005–2010 but declined as JavaScript frameworks and other technologies took over.</p>
<p><strong>JavaScript (yellow):</strong> Maintains a stable share, though its dominance in web applications is not fully reflected in TIOBE’s methodology.</p>
<p><strong>Other languages (SQL, Assembly, Visual Basic, etc.):</strong> Remain present in niche applications.</p>
</details>

<details>
<summary>💡 Conclusions</summary>
<p><strong>C and Java</strong> were the long-time leaders of the programming world.</p>
<p><strong>Python’s meteoric rise</strong> illustrates how industry trends (AI, data analytics) can change the landscape of programming.</p>
<p>The index shows that <strong>language popularity evolves with technological needs</strong>, and students should be aware of both long-standing and emerging languages.</p>
</details>

---

## EXERCISE Complexity Experiment
Given the matrix multiplication algorithm, how would you optimize the storage and management of the input data to improve the efficiency of the computation? Consider both memory access patterns and the use of specialized data structures.