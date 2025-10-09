# Example: Adjacency Matrix Multiplication in a Recommendation System

## Scenario
Consider a simple recommendation system with two types of nodes:
- **Users**: U₁, U₂  
- **Items**: I₁, I₂, I₃  

Edges indicate that a user has **positively rated** an item (for instance, a rating ≥ 4 stars).

Relationships:
- U₁ → I₁, I₂  
- U₂ → I₂, I₃  

---

## Adjacency Matrix (A)
We arrange the nodes as [U₁, U₂, I₁, I₂, I₃].  
The adjacency matrix is **bipartite**, meaning users connect only to items.

|     | U₁ | U₂ | I₁ | I₂ | I₃ |
|-----|----|----|----|----|----|
| **U₁** | 0 | 0 | 1 | 1 | 0 |
| **U₂** | 0 | 0 | 0 | 1 | 1 |
| **I₁** | 0 | 0 | 0 | 0 | 0 |
| **I₂** | 0 | 0 | 0 | 0 | 0 |
| **I₃** | 0 | 0 | 0 | 0 | 0 |

Each row represents a user or item, and each column represents a possible connection (rating or preference).

---

## Operation 1: A × Aᵀ (User Similarity)

Multiplying A by its transpose yields **user–user similarity**, based on shared items.

|     | U₁ | U₂ | I₁ | I₂ | I₃ |
|-----|----|----|----|----|----|
| **U₁** | 2 | 1 | 0 | 0 | 0 |
| **U₂** | 1 | 2 | 0 | 0 | 0 |
| **I₁** | 0 | 0 | 1 | 0 | 0 |
| **I₂** | 0 | 0 | 0 | 1 | 0 |
| **I₃** | 0 | 0 | 0 | 0 | 1 |

### Interpretation
- The top-left block (users × users) measures similarity:
  - (U₁, U₂) = 1 → They both liked item I₂.  
  - (U₁, U₁) = 2 → U₁ rated two items in total.  
  - Higher values indicate stronger preference overlap.
- The system can recommend item **I₃** to **U₁**, since **U₂**, a similar user, rated it positively.

---

## Operation 2: Aᵀ × A (Item Similarity)

This multiplication yields **item–item similarity**, based on the users who rated them.

|     | U₁ | U₂ | I₁ | I₂ | I₃ |
|-----|----|----|----|----|----|
| **I₁** | 0 | 0 | 1 | 1 | 0 |
| **I₂** | 0 | 0 | 1 | 2 | 1 |
| **I₃** | 0 | 0 | 0 | 1 | 1 |

### Interpretation
- (I₁, I₂) = 1 → Both rated by U₁.  
- (I₂, I₃) = 1 → Both rated by U₂.  
- Items with higher co-ratings can be recommended together (e.g., recommend I₃ to someone who liked I₂).

---

## Analytical Insights

- **User similarity:** Identify users with shared preferences (collaborative filtering).  
- **Item similarity:** Detect related or substitutable items (content-based filtering).  
- **Community detection:** Group users with similar behavior patterns.  
- **Preference prediction:** Estimate missing ratings via matrix operations (e.g., A² or matrix factorization).  
- **Recommendation propagation:** Use higher powers (A + A² + …) to infer multi-hop preference relations.
