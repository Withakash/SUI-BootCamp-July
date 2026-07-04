# Day 3 Assignment - Two Pointer Technique

**Course:** DSA Problem Solving Bootcamp  
**Topic:** Two Pointer Technique  
**Total Problems:** 6  
**Difficulty:** Easy → Medium  
**Expected Time:** 90–120 Minutes

---

# Instructions

For every problem, follow the complete problem-solving process:

1. Understand the problem.
2. Identify the Two Pointer pattern.
3. Think of a brute-force approach.
4. Optimize using Two Pointers.
5. Write the time and space complexity.
6. Test your solution with your own test cases.

> **Do not use extra arrays unless explicitly allowed. Try to solve the problems in-place whenever possible.**

---

# Problem 1 - Remove Element

**LeetCode:** 27

## Pattern

Two Pointer — Same Direction

## Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place.

The relative order of the remaining elements may be changed.

Return the number of elements remaining after removing `val`.

### Example

**Input**

```text
nums = [3,2,2,3]
val = 3
```

**Output**

```text
2
```

Remaining array

```text
[2,2]
```

---

### Expected Complexity

- Time: **O(n)**
- Space: **O(1)**

---

# Problem 2 - Move Zeroes

**LeetCode:** 283

## Pattern

Two Pointer — Same Direction

## Problem Statement

Given an integer array, move all `0`s to the end while maintaining the relative order of the non-zero elements.

You must perform this operation in-place.

### Example

**Input**

```text
[0,1,0,3,12]
```

**Output**

```text
[1,3,12,0,0]
```

---

### Expected Complexity

- Time: **O(n)**
- Space: **O(1)**

---

# Problem 3 - Two Sum II

**LeetCode:** 167

## Pattern

Two Pointer — Opposite Ends

## Problem Statement

Given a **sorted** array of integers and a target value, return the **1-indexed positions** of the two numbers such that they add up to the target.

Exactly one solution exists.

### Example

**Input**

```text
numbers = [2,7,11,15]
target = 9
```

**Output**

```text
[1,2]
```

---

### Expected Complexity

- Time: **O(n)**
- Space: **O(1)**

---

# Problem 4 - Squares of a Sorted Array

**LeetCode:** 977

## Pattern

Two Pointer — Opposite Ends

## Problem Statement

Given a sorted integer array (which may contain negative numbers), return an array of the squares of each number sorted in non-decreasing order.

### Example

**Input**

```text
[-7,-3,2,3,11]
```

**Output**

```text
[4,9,9,49,121]
```

---

### Expected Complexity

- Time: **O(n)**
- Space: **O(n)**

---

# Problem 5 - Sort Colors

**LeetCode:** 75

## Pattern

Two Pointer / Three Pointer (Dutch National Flag)

## Problem Statement

Given an array containing only `0`, `1`, and `2`, sort the array **in-place** without using the built-in sort function.

### Example

**Input**

```text
[2,0,2,1,1,0]
```

**Output**

```text
[0,0,1,1,2,2]
```

### Hint

Think about maintaining three regions:

- 0's region
- 1's region
- 2's region

Try solving it in **one pass**.

---

### Expected Complexity

- Time: **O(n)**
- Space: **O(1)**

---

# Problem 6 - Separate Even and Odd Numbers (In-place)

## Pattern

Two Pointer — Opposite Ends

## Problem Statement

Given an integer array, rearrange it **in-place** so that:

- All **even** numbers appear before all **odd** numbers.
- The relative order does **not** matter.
- Do **not** use an extra array.

### Example 1

**Input**

```text
[12,7,9,14,6,5,10]
```

**Possible Output**

```text
[12,10,6,14,9,5,7]
```

### Example 2

**Input**

```text
[1,3,5,7,2,4]
```

**Possible Output**

```text
[4,2,5,7,3,1]
```

> Any valid arrangement where all even numbers come before all odd numbers is accepted.

### Hint

Start one pointer from the left and one from the right.

---

### Expected Complexity

- Time: **O(n)**
- Space: **O(1)**

---

# Reflection Questions

After completing all six problems, answer the following:

1. Which problems used the **Same Direction** two-pointer pattern?
2. Which problems used the **Opposite Ends** two-pointer pattern?
3. Which problem used the **Dutch National Flag (Three Pointer)** approach?
4. Why does **Two Sum II** require the array to be sorted?
5. Why can't **Move Zeroes** be solved efficiently using only one pointer?
6. What is the role of the **slow pointer** in Problems 1 and 2?
7. In **Squares of a Sorted Array**, why do we compare the absolute values at both ends?
8. Why is **Sort Colors** completed in a single pass?
9. Why is the relative order not important in the **Even-Odd Separation** problem?
10. Which problem did you find the most challenging, and why?

---

# Challenge (Optional)

Without looking at any solution, explain in your own words:

- When should you think of using the **Opposite Ends** pattern?
- When should you think of using the **Same Direction** pattern?
- When should you think of using the **Dutch National Flag** (Three Pointer) approach?

---

# Pattern Summary

| Problem | Pattern |
|---------|---------|
| Remove Element | Same Direction |
| Move Zeroes | Same Direction |
| Two Sum II | Opposite Ends |
| Squares of a Sorted Array | Opposite Ends |
| Sort Colors | Dutch National Flag (Three Pointer) |
| Separate Even and Odd Numbers | Opposite Ends |

---

# Next Class Preview

## Topic: Prefix Sum

Before the next lecture, think about the following question:

> **If multiple queries ask for the sum of different subarrays, can we avoid calculating the sum from scratch every time?**

We'll answer this using the **Prefix Sum** technique and learn how preprocessing can reduce multiple range-sum queries from **O(n)** to **O(1)**.
