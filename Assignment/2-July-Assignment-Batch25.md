# Day 2 Assignment - Two Pointer Technique

**Course:** DSA Problem Solving Bootcamp  
**Topic:** Two Pointer Technique  
**Total Problems:** 4  
**Difficulty:** Easy → Medium  
**Expected Time:** 60–90 Minutes

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

```
nums = [3,2,2,3]
val = 3
```

**Output**

```
2
```

Remaining array

```
[2,2]
```

---

### Expected Complexity

- Time: O(n)
- Space: O(1)

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

```
[0,1,0,3,12]
```

**Output**

```
[1,3,12,0,0]
```

---

### Expected Complexity

- Time: O(n)
- Space: O(1)

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

```
numbers = [2,7,11,15]
target = 9
```

**Output**

```
[1,2]
```

---

### Expected Complexity

- Time: O(n)
- Space: O(1)

---

# Problem 4 - Squares of a Sorted Array

**LeetCode:** 977

## Pattern

Two Pointer — Opposite Ends

## Problem Statement

Given a sorted integer array (which may contain negative numbers), return an array of the squares of each number sorted in non-decreasing order.

### Example

**Input**

```
[-7,-3,2,3,11]
```

**Output**

```
[4,9,9,49,121]
```

---

### Expected Complexity

- Time: O(n)
- Space: O(n)

---

# Reflection Questions

After completing all four problems, answer the following:

1. Which problems used the **Same Direction** two-pointer pattern?
2. Which problems used the **Opposite Ends** two-pointer pattern?
3. Why does **Two Sum II** require the array to be sorted?
4. Why can't **Move Zeroes** be solved efficiently using only one pointer?
5. What is the role of the **slow pointer** in Problems 1 and 2?
6. In **Squares of a Sorted Array**, why do we compare the absolute values at both ends?

---

# Challenge (Optional)

Without looking at any solution, explain in your own words:

- When should you think of using the **Opposite Ends** pattern?
- When should you think of using the **Same Direction** pattern?

---

# Next Class Preview

**Topic:** Prefix Sum

Before the next lecture, think about the following question:

> If multiple queries ask for the sum of different subarrays, can we avoid calculating the sum from scratch every time?

We'll answer this using the **Prefix Sum** technique in the next class.
