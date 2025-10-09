# Example: Adjacency Matrix Multiplication in a Biological Network

## Scenario
Consider a biological network where nodes represent **genes** (or proteins) and edges represent **regulatory or interaction relationships**.  
We have four genes: A, B, C, and D, with the following known interactions:

- A → B: Gene A activates gene B  
- B → C: Gene B activates gene C  
- C → D: Gene C activates gene D  
- A → D: Gene A also activates gene D directly  

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 0 | 1 |
| **B** | 0 | 0 | 1 | 0 |
| **C** | 0 | 0 | 0 | 1 |
| **D** | 0 | 0 | 0 | 0 |

Each row represents the **regulating gene (source)** and each column represents the **regulated gene (target)**.  
A value of 1 means there is a **direct regulatory interaction** between two genes.

---

## Matrix Multiplication: A² = A × A

The matrix A² shows **indirect (two-step) interactions** — which genes influence others through an intermediate regulator.

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 1 | 0 |
| **B** | 0 | 0 | 0 | 1 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 1 → Gene A indirectly influences C through B (A → B → C).  
- A²₍B,D₎ = 1 → Gene B indirectly influences D through C (B → C → D).  
- A²₍A,D₎ = 0 → Although A directly regulates D, there is no distinct two-step pathway (already covered in A).  

---

## Biological Insights

- **Indirect or cascade regulation:** Detect genes that affect others through intermediate regulators (e.g., signaling pathways).  
- **Signal propagation:** Analyze how activation of one gene can spread through the network over multiple steps.  
- **Hub genes:** Identify genes with high connectivity in A or A² — potential master regulators or essential genes.  
- **Network redundancy:** If A²₍i,j₎ > 1, multiple regulatory paths exist between i and j, suggesting robustness in gene regulation.

---

## Extensions

- A³ → shows interactions involving three steps (A → B → C → D).  
- (I + A + A² + … + Aᵏ) → total reachability or accumulated influence of a gene across the network.  
- Weighted adjacency matrices → edge weights can represent interaction strength, affinity, or probability of binding.
