# Example: Adjacency Matrix Multiplication in a Scheduling Problem

## Scenario
Consider a set of **tasks** with **dependencies**, meaning some tasks cannot start until others are completed.

Tasks:  
- A: Design the architecture  
- B: Implement the code  
- C: Test the system  
- D: Deploy the application  

Dependencies (A → B means “B depends on A”):  
- A → B (coding requires the design)  
- B → C (testing requires code)  
- C → D (deployment requires tests)  
- A → C (some tests depend directly on the design)

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 1 | 0 |
| **B** | 0 | 0 | 1 | 0 |
| **C** | 0 | 0 | 0 | 1 |
| **D** | 0 | 0 | 0 | 0 |

Each row represents a **preceding task**, and each column represents a **dependent task**.  
A value of 1 indicates that a task must be completed before another can start.

---

## Matrix Multiplication: A² = A × A

This operation shows **indirect second-level dependencies** — tasks that depend on others **through an intermediate task**.

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 1 | 1 |
| **B** | 0 | 0 | 0 | 1 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 1 → Task A indirectly influences C (A → B → C), in addition to the direct A → C relation.  
- A²₍A,D₎ = 1 → Task A indirectly influences D through A → B → C → D.  
- A²₍B,D₎ = 1 → Task B indirectly influences D through B → C → D.  
- Task D has no outgoing dependencies (it’s the final task in the workflow).

---

## Analytical Insights

1. **Indirect dependency detection:**  
   Identifies which tasks are connected by multiple dependency levels (useful for critical path analysis).

2. **Critical path analysis:**  
   Reveals which initial tasks have the greatest downstream impact on the overall schedule.

3. **Delay propagation:**  
   If one task is delayed, A² shows which tasks will be affected within two dependency levels.

4. **Planning optimization:**  
   Highlights redundant or unnecessary dependencies that may create scheduling bottlenecks.

---

## Extensions

- A³ → shows **third-level dependencies** (longer paths in the scheduling graph).  
- (I + A + A² + … + Aᵏ) → measures **total task reachability** (direct and indirect dependencies).  
- Weighted adjacency matrices → edges can represent **task duration**, **priority**, or **risk**, allowing cumulative impact analysis.
