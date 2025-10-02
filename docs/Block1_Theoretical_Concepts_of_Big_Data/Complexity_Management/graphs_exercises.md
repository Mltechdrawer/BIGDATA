# Exercises on Graphs in Big Data Context 

## Variant 1 — *Exploring Graph Representations*
**Goal.** Compare adjacency matrix and adjacency list representations in terms of memory usage and query efficiency.  

**Tasks.**
1. Build a synthetic social network graph with different densities (sparse vs dense).  
2. Store the graph both as an adjacency list and as an adjacency matrix.  
3. Measure memory consumption and query time for operations like:  
   - Checking if two nodes are connected.  
   - Finding neighbors of a node.  
4. Plot results as graph size increases.  

**Deliverables.**
- Report (4–6 pages) with plots and analysis.  
- Code that builds both representations and measures performance.  

---

## Variant 2 — *Degrees of Separation in Social Networks*
**Goal.** Empirically measure how the average path length grows in social network graphs, and relate it to the “small-world” phenomenon.  

**Tasks.**
1. Generate synthetic social networks with increasing numbers of nodes (Erdős–Rényi and Barabási–Albert models).  
2. Compute the average shortest path length using BFS or matrix multiplications.  
3. Plot how path length grows with graph size for each model.  
4. Discuss implications for real-world social networks.  

**Deliverables.**
- Report (3–5 pages) with plots and interpretation.  
- Code to generate graphs and compute path lengths.  

---

## Variant 3 — *Shortest Path Performance in Large Graphs*
**Goal.** Empirically compare Dijkstra’s algorithm and BFS (for unweighted graphs) in terms of runtime and scalability.  

**Tasks.**
1. Generate random graphs with varying sizes and edge weights.  
2. Run BFS for unweighted graphs and Dijkstra for weighted graphs.  
3. Measure execution time and number of operations as input size grows.  
4. Plot results and analyze when Dijkstra’s overhead becomes significant.  

**Deliverables.**
- Report (4–6 pages) with analysis and plots.  
- Annotated code to reproduce experiments.  

---

## Variant 4 — *Ranking Web Pages with PageRank*
**Goal.** Explore how PageRank values evolve with graph size and structure.  

**Tasks.**
1. Generate directed graphs simulating web pages and hyperlinks.  
2. Implement the PageRank algorithm using iterative matrix multiplications.  
3. Measure convergence speed (iterations until stable) as graph size increases.  
4. Compare rankings across different graph topologies (chain, star, random).  

**Deliverables.**
- Report (4–6 pages) with convergence plots and discussion.  
- Code implementing PageRank.  

---

## Variant 5 — *Task Scheduling and Dependency Graphs*
**Goal.** Analyze project scheduling using Directed Acyclic Graphs (DAGs).  

**Tasks.**
1. Generate random DAGs representing task dependencies.  
2. Implement topological sorting to find valid execution orders.  
3. Measure execution time and memory usage as graph size increases.  
4. Extend the experiment by adding random cycles to test cycle detection.  

**Deliverables.**
- Report (4–6 pages) with examples and analysis.  
- Code for DAG generation, sorting, and cycle detection.  

---

## Common Notes
- Clearly distinguish between time complexity (theoretical) and observed runtime.  
- Vary graph density to show how sparse vs dense cases differ.  
- Optionally use existing graph libraries (e.g., NetworkX, SNAP, GraphX) to scale experiments.  
