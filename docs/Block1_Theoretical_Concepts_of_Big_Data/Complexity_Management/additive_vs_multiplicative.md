# Additive vs. Multiplicative Costs in Graphs

## 1. Additive Cost

### Definition
In an **additive cost**, the total value of a path is the **sum of the individual costs** of each edge:

**Total Cost (A → C) = A_AB + A_BC**

This model is used when **each step adds an independent cost**, such as:
- Distance traveled  
- Execution time  
- Energy consumed  
- Accumulated price  

### Example
Imagine a graph where nodes represent cities and edge weights are distances (in km):

| Route | Cost (km) |
|--------|------------|
| A → B | 5 |
| B → C | 7 |
| A → C | — |

Then, the total additive cost from A to C via B is:

**Cost (A → B → C) = 5 + 7 = 12**

If there are multiple paths, we choose the one with the **minimum total sum** using algorithms such as **Dijkstra** or **Floyd–Warshall**.

---

## 2. Multiplicative Cost

### Definition
In a **multiplicative cost**, the total value of a path is the **product of the individual costs** (or probabilities, or reliability factors) of each edge:

**Total Cost (A → C) = A_AB × A_BC**

This is used when **each step transforms or attenuates** the effect of the previous one, such as:
- Success probabilities  
- Transmission coefficients (signal loss or energy)  
- Relationship strength or affinity  
- Growth or decay factors  

### Example
Suppose edge weights represent **probabilities of success**:

| Route | Probability |
|--------|--------------|
| A → B | 0.9 |
| B → C | 0.8 |
| A → C | — |

Then, the probability of reaching C from A through B is:

**P(A → B → C) = 0.9 × 0.8 = 0.72**

Each step **reduces** the overall probability of success.

---

## 3. Comparison

| Concept | Additive Cost | Multiplicative Cost |
|----------|----------------|----------------------|
| Operation | Sum (+) | Product (×) |
| Typical Context | Distance, time, energy | Probability, reliability, intensity |
| Total Behavior | Increases with each step | Decreases or amplifies |
| Example Algorithms | Dijkstra, Floyd–Warshall | Markov models, probabilistic propagation |

---

## 4. Graphical Interpretation

**Graph 1 (Additive – distances):**  
A —(5)— B —(7)— C → total cost = 12  

**Graph 2 (Multiplicative – probabilities):**  
A —(0.9)— B —(0.8)— C → total cost = 0.72  

In the first case, traveling becomes more expensive with each step.  
In the second, success becomes less likely with each step.
