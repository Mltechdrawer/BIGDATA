# Example: Adjacency Matrix Multiplication in a Social Network

## Scenario
We have a small **social network** with four users: A, B, C, and D.  
Connections are **directed** — for instance, like Twitter follows (A → B means A follows B).

| Relationship | Description |
|---------------|-------------|
| A → B | A follows B |
| B → C | B follows C |
| C → D | C follows D |
| A → D | A also follows D |

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 0 | 1 |
| **B** | 0 | 0 | 1 | 0 |
| **C** | 0 | 0 | 0 | 1 |
| **D** | 0 | 0 | 0 | 0 |

Each row shows **who follows whom**.

---

## Matrix Multiplication: A² = A × A

This multiplication tells us the number of **paths of length 2** between users — i.e., “friend of a friend” or “follower of a followed user.”

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 1 | 0 |
| **B** | 0 | 0 | 0 | 1 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 1 → A can reach C in two steps (A → B → C).  
- A²₍B,D₎ = 1 → B can reach D in two steps (B → C → D).  
- Other entries are 0 → no two-step paths exist.

This helps answer questions such as:
- “Who can I reach in two hops?”  
- “How many intermediaries are between two users?”  
- “Who could be suggested as a new friend (indirectly connected users)?”

---

## Possible Extensions

- **A³** → paths of length 3 (“friend of a friend of a friend”).  
- **(A + A² + A³ + …)** → overall reachability or connectivity-based centrality.  
- **Weighted networks:** non-binary values can represent **interaction strength** or **frequency**.


