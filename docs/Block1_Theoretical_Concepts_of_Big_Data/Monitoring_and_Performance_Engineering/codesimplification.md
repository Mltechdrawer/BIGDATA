# Code Simplification Example 1

The **Code Simplification** rule by Jon Bentley emphasizes that simple programs are both faster and easier to maintain. By reducing unnecessary constructs and using concise syntax, performance and readability can be improved simultaneously.

## Original Code
```python
def sum_of_squares(nums):
    result = 0
    for num in nums:
        if num % 2 == 0:
            result += num ** 2
    return result

numbers = [1, 2, 3, 4, 5, 6, 7, 8]
print(sum_of_squares(numbers))
```

**Output:**
```
120
```

This version works correctly but is unnecessarily verbose: it creates a loop, performs conditional checks, and manually accumulates results.

## Simplified Version
```python
def sum_of_squares(nums):
    return sum(num ** 2 for num in nums if num % 2 == 0)
```

**Output:**
```
120
```

## Explanation
- The expression `(num ** 2 for num in nums if num % 2 == 0)` generates squares of all even numbers.
- `sum()` directly adds those values without needing an intermediate variable.

## Benefits
- **Simplicity:** Fewer lines of code, clearer intent.
- **Performance:** Python comprehensions are internally optimized in C.
- **Readability:** The purpose is immediately visible — *sum of even squares*.
- **Maintainability:** Less code means fewer potential errors.

---

Thess examples demonstrate Bentley’s principle: *simpler code is often faster code*.

