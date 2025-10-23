# Early Binding — Examples

**Principle.** Move work forward in time. Do work once now to avoid doing it many times later. Precompute constants, cache repeated values, and lift loop‑invariant work out of hot paths.

---

## Example 1 — Building a Connection String Repeatedly (No Early Binding)

### Code
```python
import time

def connect_to_db():
    db_host = "localhost"
    db_user = "user"
    db_password = "password"

    # Built every call — repeated work
    connection_string = f"host={db_host};user={db_user};password={db_password}"

    # Simulate connecting
    time.sleep(0.1)
    print(f"Connecting with: {connection_string}")

# Connect multiple times (repeats construction)
for _ in range(5):
    connect_to_db()
```

### Issues
- **Repeated Work:** The `connection_string` is rebuilt on every call although the data is constant.
- **Inefficiency:** Unnecessary string construction adds overhead inside the loop.

---

## Example 1 (Improved) — Precompute the Connection String (Early Binding)

### Code
```python
import time

# Pre-calculate once (outside the loop / hot path)
db_host = "localhost"
db_user = "user"
db_password = "password"
connection_string = f"host={db_host};user={db_user};password={db_password}"

def connect_to_db(connection_string: str):
    time.sleep(0.1)  # Simulate I/O
    print(f"Connecting with: {connection_string}")

for _ in range(5):
    connect_to_db(connection_string)
```

### Benefits
1. **Efficiency:** Build once, reuse many times.
2. **Reduced Overhead:** Less work inside the loop or hot path.
3. **Readability:** The intent is clearer; constants are defined up front.

---

## Example 2 — Recomputing Square Roots in a Loop (No Early Binding)

### Code
```python
import math

def calculate_square_roots(nums):
    results = []
    for num in nums:
        results.append(math.sqrt(num))  # recalculated every time
    return results

numbers = list(range(1, 11))
print(calculate_square_roots(numbers))
```

### Issue
- **Repeated Computation:** `math.sqrt(n)` is recomputed for the same inputs across iterations or calls.

---

## Example 2 (Improved) — Precompute / Cache with a Lookup Table (Early Binding)

### Code
```python
import math

# Precompute once (e.g., at startup)
square_roots_lookup = {num: math.sqrt(num) for num in range(1, 11)}

def get_square_root(num):
    return square_roots_lookup.get(num, None)

numbers = list(range(1, 11))
print([get_square_root(num) for num in numbers])
```

### Benefits
1. **Efficiency:** Avoids recalculating; lookups are O(1).
2. **Faster Execution:** Accessing a cached value is typically faster than recomputing it.
3. **Reduced Computation:** Work is moved to an earlier, one‑time phase.

---

**Overall insight.** Early binding trades a small amount of memory (for constants or caches) to remove repeated computation from hot paths, improving performance and predictability.

