# Example: Adjacency Matrix Multiplication in a Transportation Network

## Scenario
We have a **transportation network** connecting four cities:  
A (Madrid), B (Barcelona), C (Valencia), and D (Seville).

The **direct routes** (by road, rail, or air) are:

| Route | Description |
|--------|-------------|
| A → B | Direct route from Madrid to Barcelona |
| B → C | Direct route from Barcelona to Valencia |
| C → D | Direct route from Valencia to Seville |
| A → D | Direct route from Madrid to Seville |

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 0 | 1 |
| **B** | 0 | 0 | 1 | 0 |
| **C** | 0 | 0 | 0 | 1 |
| **D** | 0 | 0 | 0 | 0 |

Each row represents the origin city, and each column represents the destination city.  
A value of 1 means there is a direct connection between the two cities.

---

## Matrix Multiplication: A² = A × A

The result A² shows how many **indirect routes (two-leg connections)** exist between cities.

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 1 | 0 |
| **B** | 0 | 0 | 0 | 1 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 1 → There is an indirect route from Madrid to Valencia through Barcelona (A → B → C).  
- A²₍B,D₎ = 1 → There is an indirect route from Barcelona to Seville through Valencia (B → C → D).  
- All other values are 0 → no two-leg routes exist between those cities.

This analysis can be used to:
- Identify **reachable cities** in two steps (e.g., flights with one layover).  
- Measure **network efficiency** by counting how many destinations can be reached in a few steps.  
- Detect **bottlenecks** or critical connections in the transport system.

---

## Possible Extensions

- A³ → identifies routes with two layovers (three legs).  
- (A + A² + A³ + …) → measures total **reachability** or overall connectivity.  
- Weighted networks → values represent **distance, time, or cost**, enabling optimization of routes.

