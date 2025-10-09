# Example: Adjacency Matrix Multiplication in a Knowledge Graph

## Scenario
Consider a small **knowledge graph** where nodes represent **entities** and edges represent **semantic relationships**.

Entities:  
- A: "Albert Einstein"  
- B: "Physics"  
- C: "Nobel Prize"  
- D: "Switzerland"

Relationships:  
- A → B: Einstein is associated with Physics  
- A → D: Einstein lived in Switzerland  
- B → C: Physics is related to the Nobel Prize  
- D → C: Switzerland hosts Nobel Prize institutions  

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 0 | 1 |
| **B** | 0 | 0 | 1 | 0 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 1 | 0 |

Each row represents the **source entity**, and each column represents the **target entity**.  
A value of 1 means there is a **direct semantic relationship** between the entities.

---

## Matrix Multiplication: A² = A × A

The result A² represents **indirect (two-step) relationships**, i.e., entities connected through an intermediate node.

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 2 | 0 |
| **B** | 0 | 0 | 0 | 0 |
| **C** | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 2 →  
  Albert Einstein (A) is semantically connected to the *Nobel Prize (C)* through **two distinct paths**:
  1. A → B → C (Einstein → Physics → Nobel Prize)  
  2. A → D → C (Einstein → Switzerland → Nobel Prize)

  This indicates a **reinforced semantic relationship**: multiple paths in the graph link Einstein to the Nobel Prize.

- All other entries are 0 → no indirect two-step relationships exist among the other entities.

---

## Insights and Applications

- **Implicit relationship inference:** Identify hidden or indirect semantic links (e.g., inferring that "Einstein is related to the Nobel Prize" even if not explicitly stated).  
- **Knowledge discovery:** Find entities that share common semantic intermediaries (useful in semantic search and reasoning systems).  
- **Semantic strength analysis:** Higher values in A² or A³ indicate multiple reinforcing semantic paths between entities.  
- **Query expansion:** Use A² or A³ to retrieve contextually related entities in knowledge retrieval systems.

---

## Extensions

- A³ → captures relationships through three-step paths (longer semantic chains).  
- (I + A + A² + … + Aᵏ) → measures total semantic connectivity for an entity.  
- Weighted adjacency matrices → edges can represent **relationship confidence**, **semantic strength**, or **co-occurrence frequency**.
