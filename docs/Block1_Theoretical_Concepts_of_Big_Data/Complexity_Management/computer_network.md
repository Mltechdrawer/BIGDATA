# Example: Adjacency Matrix Multiplication in a Computer Network

## Scenario
Consider a network of four devices:  
A (host), B (switch), C (router-1), and D (router-2).  
The edges are **directed communication links** (row = source, column = destination).

Direct links:
- A → B  
- B → C, B → D  
- C → D  
- D → (no outgoing links)

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 0 | 0 |
| **B** | 0 | 0 | 1 | 1 |
| **C** | 0 | 0 | 0 | 1 |
| **D** | 0 | 0 | 0 | 0 |

Each row represents the source device, and each column represents the destination device.  
A value of 1 indicates a direct communication link between two devices.

---

## Matrix Multiplication: A² = A × A

The matrix A² shows how many **two-hop communication paths** exist between devices.

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 1 | 1 |
| **B** | 0 | 0 | 0 | 1 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 1 → Device A can reach C in two hops (A → B → C).  
- A²₍A,D₎ = 1 → Device A can reach D in two hops (A → B → D).  
- A²₍B,D₎ = 1 → Device B can reach D in two hops (B → C → D).  
- Rows with all zeros (like D) indicate **sink nodes** — devices that do not forward traffic.

---

## Possible Analyses

- **Two-hop reachability:** Identify which devices are reachable within two transmissions (useful for TTL, latency estimation, or broadcast domain boundaries).  
- **Critical relay nodes:** Columns with nonzero entries (e.g., C and D) reveal which devices act as communication relays — their failure could break the network.  
- **Routing and segmentation:** Determine which destinations require multiple hops to optimize routing or add redundancy.

---

## Extensions

- A³ → identifies devices reachable in three hops (additional relays).  
- (I + A + A² + … + Aᵏ) → cumulative reachability up to k hops.  
- Weighted adjacency matrices → represent bandwidth, loss, or latency to find the most efficient routes.  
- Redundancy analysis → if A²₍i,j₎ > 1, multiple two-hop paths exist between i and j.
