# Example: Adjacency Matrix Multiplication in a Web Page Network

## Scenario
Consider a network of four web pages: A, B, C, and D.  
The edges represent hyperlinks between pages (directed links, where the row is the source and the column is the destination).

Direct links:
- A → B, A → D  
- B → C, B → D  
- C → A  
- D → (no outgoing links)

---

## Adjacency Matrix (A)

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 1 | 0 | 1 |
| **B** | 0 | 0 | 1 | 1 |
| **C** | 1 | 0 | 0 | 0 |
| **D** | 0 | 0 | 0 | 0 |

Each row represents the source page and each column represents the target page.  
A value of 1 indicates a direct hyperlink between two pages.

---

## Matrix Multiplication: A² = A × A

The matrix A² shows how many **two-click paths** exist between web pages.

|     | A | B | C | D |
|-----|---|---|---|---|
| **A** | 0 | 0 | 1 | 1 |
| **B** | 1 | 0 | 0 | 0 |
| **C** | 0 | 1 | 0 | 1 |
| **D** | 0 | 0 | 0 | 0 |

---

## Interpretation

- A²₍A,C₎ = 1 → From page A, you can reach C in two clicks (A → B → C).  
- A²₍A,D₎ = 1 → From page A, you can reach D in two clicks (A → B → D).  
- A²₍B,A₎ = 1 → From page B, you can reach A in two clicks (B → C → A).  
- A²₍C,B₎ = 1 and A²₍C,D₎ = 1 → From page C, you can reach B (C → A → B) and D (C → A → D).  
- The entire row for D is zeros → D is a **sink node** (no outgoing links).

---

## Possible Analyses

- **Two-click reachability:** Determine what percentage of the site is accessible within two clicks from a landing page.  
- **Sink or dead-end detection:** Identify pages with no outgoing links to improve internal navigation.  
- **Conversion path design:** Ensure that key pages (e.g., checkout or signup) are reachable within two clicks.  
- **Internal SEO prioritization:** Pages with many indirect incoming links (high column sums in A²) may attract more navigation flow.

Further extensions:
- A³ → paths reachable in three clicks.  
- (I + A + A² + … + Aᵏ) → cumulative reachability across multiple navigation steps.  
- Weighted adjacency matrices can model link importance or visibility.
