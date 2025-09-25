
# Exercises on Big-O Notation


## Variant 1 — *Mapping the Complexity Landscape*
**Goal.** Empirically identify the time complexity of several algorithms using synthetic datasets of increasing size, and contrast it with the theoretical complexity.

**Tasks.**
1. Choose three different complexity classes (O(1), O(log n), O(n), O(n log n), etc.).
2. Measure execution times for increasing input sizes using `System.nanoTime()`.
3. Plot results and normalize (`time/n`, `time/n log n`, etc.) to recognize the class.
4. Write a report for each algorithm with hypothesis, evidence, and discussion.

**Deliverables.**
- Report (4–6 pages) with plots and analysis.
- Code with measurement scripts.

---

## Variant 2 — *Scaling Limits in Practice*
**Goal.** Explore the practical limits of different algorithmic complexities by running experiments until execution times become impractical, and compare results to theoretical expectations.

**Tasks.**
1. Select three complexity classes (e.g., O(n), O(n log n), O(n²)).  
2. Define a “time budget” (e.g., 5 seconds per experiment).  
3. Increase input size `n` step by step until execution exceeds the budget.  
4. Record the maximum feasible `n` for each algorithm and compare with theoretical growth.  
5. Discuss discrepancies between theoretical predictions and practical limits (e.g., due to JVM, caching, or hardware).  

**Deliverables.**
- Report (3–5 pages) with tables of `n_max` values and discussion.  
- Code with input scaling scripts.  

---

## Variant 3 — *Comparing Growth Rates on the Same Plot*
**Goal.** Visually demonstrate differences in algorithmic growth rates by plotting multiple complexity classes together for the same input range.  

**Tasks.**
1. Select at least four algorithms with distinct complexities (e.g., O(1), O(log n), O(n), O(n²)).  
2. Measure execution times for the same sequence of input sizes.  
3. Plot all results on the same chart (possibly log-log scale for clarity).  
4. Highlight where one complexity “overtakes” another (e.g., O(n²) becomes much slower than O(n log n)).  
5. Provide an interpretation that connects plots to theoretical curves.  

**Deliverables.**
- Report (4–6 pages) with combined plots and written interpretation.  
- Annotated code to reproduce graphs.  


## Common Notes
- Use definitions of Big O notation, best/worst/average cases.
- Always explain what your analysis counts (iterations, comparisons, assignments).
- Differentiate time and space when relevant.
- (Optional) Use JMH for micro-benchmarks in Java.

