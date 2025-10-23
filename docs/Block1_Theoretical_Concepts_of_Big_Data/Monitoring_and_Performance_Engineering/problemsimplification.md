# Problem Simplification Examples

The **Problem Simplification** rule encourages developers to improve performance not just by optimizing code, but by simplifying the problem itself. Rather than performing unnecessary work, focus only on what the program truly needs to accomplish.

---

## Example 1 — Sorting the Entire List to Find the Median

### Code
```python
def find_median(numbers):
    numbers.sort()  # Sort the entire list
    n = len(numbers)
    if n % 2 == 1:
        return numbers[n // 2]  # If odd, return middle element
    else:
        return (numbers[n // 2 - 1] + numbers[n // 2]) / 2  # If even, average of middle elements

numbers = [5, 3, 8, 9, 1, 7, 4, 6, 2]
print(find_median(numbers))
```

### Issues
- **Time Complexity:** Sorting the entire list requires O(n log n) time, which is inefficient for large datasets.
- **Unnecessary Work:** Sorting all elements is excessive when we only need the median.

This version works correctly but performs more computation than necessary, as it sorts the whole list to find a single value.

---

## Example 2 — Simplifying the Problem Using Quickselect

Instead of sorting the entire list, we can use the **Quickselect algorithm**, which finds the k-th smallest element in average time O(n). This approach directly targets what we need—the median—without doing extra work.

### Code
```python
import random

def quickselect(nums, k):
    if len(nums) == 1:
        return nums[0]

    pivot = random.choice(nums)
    lows  = [el for el in nums if el < pivot]
    highs = [el for el in nums if el > pivot]
    pivots = [el for el in nums if el == pivot]

    if k < len(lows):
        return quickselect(lows, k)
    elif k < len(lows) + len(pivots):
        return pivots[0]
    else:
        return quickselect(highs, k - len(lows) - len(pivots))

def find_median(numbers):
    n = len(numbers)
    if n % 2 == 1:
        return quickselect(numbers, n // 2)
    else:
        left = quickselect(numbers, n // 2 - 1)
        right = quickselect(numbers, n // 2)
        return (left + right) / 2

numbers = [5, 3, 8, 9, 1, 7, 4, 6, 2]
print(find_median(numbers))
```

### Benefits of Problem Simplification
1. **Reduced Complexity:** The Quickselect algorithm achieves average-case O(n) time, improving upon the O(n log n) complexity of sorting.
2. **Efficiency:** By simplifying the problem—finding only the median instead of fully sorting—the program eliminates unnecessary computation.
3. **Scalability:** This approach scales better with large datasets, maintaining fast performance even when n is large.

---

These examples demonstrate Bentley’s principle: simplifying the problem itself often yields greater performance improvements than micro-optimizing code.

