# Relentless Suspicion — Examples

**Principle.** Question the necessity of each instruction in a time‑critical piece of code and each field in a space‑critical data structure. Remove redundant work, use optimized primitives, and keep data minimal.

---

## Example 1 — Inefficient Sorting with Redundant Operations

### Code
```python
def time_critical_sort(nums):
    result = nums.copy()  # Unnecessary copy
    for i in range(len(result)):
        for j in range(i + 1, len(result)):
            if result[i] > result[j]:
                # Swap elements (bubble/selection-like)
                result[i], result[j] = result[j], result[i]
    return result

numbers = [5, 3, 8, 4, 2, 9, 1]
print(time_critical_sort(numbers))
```

### Problems
- **Unnecessary Copy (`nums.copy()`):** Adds O(n) time and extra memory traffic.
- **Inefficient Sorting (O(n²))**: Nested loops are too slow for large lists.
- **Redundant Operations:** Many swaps; ignores better built‑in algorithms and cache behaviour.

---

## Example 2 — Use the Optimized Built‑in Sort (Timsort)

### Code
```python
def time_critical_sort(nums):
    nums.sort()  # In‑place sorting, Timsort (average/worst O(n log n))
    return nums

numbers = [5, 3, 8, 4, 2, 9, 1]
print(time_critical_sort(numbers))
```

### Benefits
1. **Reduced Complexity:** Eliminates the extra O(n) copy and unnecessary swaps.
2. **Efficient Sorting:** Leverages Python’s highly optimized **Timsort** for real‑world data.
3. **Improved Readability:** The code states the intent directly — *sort the list*.

> Takeaway: prefer a single well‑tuned library call over custom O(n²) loops.

---

## Example 3 — Space‑Critical Structure with Redundant Fields

### Code
```python
class UserData:
    def __init__(self, username, email, age, address, phone, preferences, bio, membership):
        self.username = username
        self.email = email
        self.age = age
        self.address = address
        self.phone = phone
        self.preferences = preferences
        self.bio = bio
        self.membership = membership
```

### Problems
- **Redundant Fields:** Not all attributes are required for core features.
- **High Memory Usage:** Large fields (e.g., `address`, `bio`, `preferences`) bloat RAM/serialization.

---

## Example 4 — Minimal Schema + Load on Demand

### Code
```python
class UserData:
    def __init__(self, username, email, membership):
        self.username = username
        self.email = email
        self.membership = membership

    # Additional details (address, bio, preferences) can be fetched on demand
    # from a database or profile service only when needed.
```

### Benefits
1. **Reduced Memory Usage:** Store only essential data in memory-critical paths.
2. **Load On Demand:** Expensive/large fields are retrieved only when required, improving footprint and cache locality.

> Takeaway: question each field; keep the in‑memory representation minimal and fetch the rest lazily.

---

**Overall insight.** Relentless suspicion is about removing every instruction and field that does not measurably contribute to the result. Measure, simplify, and rely on optimized primitives wherever possible.

