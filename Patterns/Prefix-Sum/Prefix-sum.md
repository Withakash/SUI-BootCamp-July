# 📘 Prefix Sum - Complete Notes (Beginner to Interview Level)

> **Goal:** Understand what Prefix Sum is, why we use it, how to build it, and how to identify Prefix Sum problems in interviews and competitive programming.

---

# What is Prefix Sum?

Imagine you have an array.

```text
Array = [2, 5, 1, 8, 3]
```

Suppose someone asks:

> Find the sum from index **1 to 3**.

Normally, you would calculate

```text
5 + 1 + 8 = 14
```

That's fine for one query.

But what if there are **100,000 queries**?

```text
Sum(2,6)
Sum(1,8)
Sum(5,9)
Sum(3,7)
...
```

Repeating the same calculations becomes slow.

**Prefix Sum solves this by preprocessing the array once.**

---

# Real-Life Analogy

Imagine your monthly savings.

Instead of calculating your total savings from January every time,

you already know

```text
Savings till January

Savings till February

Savings till March

Savings till April
```

Now someone asks

> How much did you save from February to April?

You simply subtract.

Exactly the same idea is used in Prefix Sum.

---

# Definition

A Prefix Sum array stores the cumulative sum from the beginning of the array.

```text
prefix[i]

=

Sum of elements from index 0 to index i
```

---

# Example

Original Array

```text
Index : 0  1  2  3  4

Array : 2  5  1  8  3
```

Build Prefix Sum

```text
prefix[0] = 2

prefix[1] = 2 + 5 = 7

prefix[2] = 2 + 5 + 1 = 8

prefix[3] = 2 + 5 + 1 + 8 = 16

prefix[4] = 2 + 5 + 1 + 8 + 3 = 19
```

Final Prefix Array

```text
Index  : 0   1   2   3   4

Prefix : 2   7   8   16  19
```

---

# Formula

```text
prefix[0] = arr[0]

prefix[i] = prefix[i-1] + arr[i]
```

---

# Java Code

```java
int[] prefix = new int[arr.length];

prefix[0] = arr[0];

for(int i = 1; i < arr.length; i++)
{
    prefix[i] = prefix[i-1] + arr[i];
}
```

Time Complexity

```text
O(n)
```

Space Complexity

```text
O(n)
```

---

# Range Sum Query

Find

```text
Sum(L,R)
```

Formula

If

```text
L == 0
```

```text
Answer = prefix[R]
```

Otherwise

```text
Answer = prefix[R] - prefix[L-1]
```

---

Example

```text
Array

2 5 1 8 3
```

Need

```text
Sum(1,3)
```

```text
prefix[3]=16

prefix[0]=2

16-2=14
```

Answer

```text
14
```

---

# Why Does This Work?

```text
prefix[3]

=

2+5+1+8
```

Remove

```text
prefix[0]

=

2
```

Remaining

```text
5+1+8
```

Exactly the required range.

---

# Complexity Comparison

Without Prefix Sum

```text
Each Query

O(n)
```

For Q Queries

```text
O(n × Q)
```

With Prefix Sum

```text
Build

O(n)

Each Query

O(1)

Total

O(n + Q)
```

---

# When Should You Think About Prefix Sum?

Whenever you see

### ✅ Range Sum

```text
Find sum between L and R
```

---

### ✅ Multiple Queries

```text
100000 queries
```

---

### ✅ Continuous Subarray

```text
Subarray

Range

Interval
```

---

### ✅ Running Total

```text
Running Balance

Running Score

Cumulative Marks

Running Income
```

---

### ✅ Need Cumulative Information

Whenever previous calculations can help answer future questions.

---

# Pattern Recognition

Whenever you see

```text
Array

+

Subarray

+

Sum
```

↓

Think

```text
Prefix Sum
```

---

Whenever you see

```text
Many Range Queries
```

↓

Think

```text
Prefix Sum
```

---

Whenever you see

```text
Running Total
```

↓

Think

```text
Prefix Sum
```

---

# Problems Solved Using Prefix Sum

---

# 1. Range Sum Query

### Idea

Find the sum between two indices.

Example

```text
L = 2

R = 6
```

Technique

```text
Prefix Sum
```

### LeetCode

- 303. Range Sum Query - Immutable
- 304. Range Sum Query 2D - Immutable

---

# 2. Running Sum

### Idea

Return cumulative sums.

Example

```text
Input

1 2 3 4

Output

1 3 6 10
```

Technique

```text
Prefix Sum
```

### LeetCode

- 1480. Running Sum of 1D Array

---

# 3. Pivot Index

### Idea

Find an index where

```text
Left Sum

=

Right Sum
```

Technique

```text
Prefix Sum
```

### LeetCode

- 724. Find Pivot Index

---

# 4. Equilibrium Index

Same idea as Pivot Index.

Common interview question.

Technique

```text
Prefix Sum
```

### Practice

- GeeksforGeeks - Equilibrium Point

---

# 5. Count Subarrays with Sum = K

Example

```text
Array

1 2 3

K=3
```

Subarrays

```text
[1,2]

[3]
```

Answer

```text
2
```

Technique

```text
Prefix Sum

+

HashMap
```

### LeetCode

- 560. Subarray Sum Equals K

---

# 6. Continuous Subarray Sum

Determine whether a subarray satisfies a condition based on sum.

Technique

```text
Prefix Sum

+

Modulo

+

HashMap
```

### LeetCode

- 523. Continuous Subarray Sum

---

# 7. Longest Subarray with Sum = K

Technique

```text
Prefix Sum

+

HashMap
```

### Practice

- GeeksforGeeks - Longest Subarray with Sum K

---

# 8. Zero Sum Subarray

Observation

If the same Prefix Sum appears twice,

the sum between them is zero.

Technique

```text
Prefix Sum

+

HashSet
```

### Practice

- GeeksforGeeks - Zero Sum Subarrays

---

# 9. Equal Number of 0s and 1s

Convert

```text
0 → -1

1 → +1
```

Then find

```text
Longest Sum = 0
```

Technique

```text
Prefix Sum

+

HashMap
```

### LeetCode

- 525. Contiguous Array

---

# 10. Binary Subarrays With Sum

Technique

```text
Prefix Sum

+

HashMap
```

### LeetCode

- 930. Binary Subarrays With Sum

---

# 11. Number of Nice Subarrays

Technique

```text
Prefix Count

+

HashMap
```

### LeetCode

- 1248. Count Number of Nice Subarrays

---

# 12. Subarrays Divisible by K

Technique

```text
Prefix Sum

+

Modulo

+

HashMap
```

### LeetCode

- 974. Subarray Sums Divisible by K

---

# 13. Maximum Size Subarray Sum = K

Technique

```text
Prefix Sum

+

HashMap
```

### LeetCode (Premium)

- 325. Maximum Size Subarray Sum Equals k

---

# 14. Product Except Self

Although not a normal Prefix Sum problem,

it uses the Prefix concept.

Technique

```text
Prefix Product

+

Suffix Product
```

### LeetCode

- 238. Product of Array Except Self

---

# 15. Trapping Rain Water

Uses

```text
Prefix Maximum

+

Suffix Maximum
```

### LeetCode

- 42. Trapping Rain Water

---

# 16. 2D Prefix Sum

Rectangle Sum Queries

Technique

```text
2D Prefix Sum
```

### LeetCode

- 304. Range Sum Query 2D - Immutable
- 1314. Matrix Block Sum

---

# Prefix Variations

## Prefix XOR

Used in XOR-based problems.

Examples

- 1310. XOR Queries of a Subarray

---

## Prefix Product

Used in multiplication problems.

Examples

- 238. Product of Array Except Self

---

## Prefix Maximum

Stores maximum till index i.

Examples

- 42. Trapping Rain Water

---

## Prefix Minimum

Stores minimum till index i.

Useful in optimization problems.

---

## Prefix Frequency

Stores counts instead of sums.

Useful in character frequency and counting problems.

---

# Advantages

✅ Easy to understand

✅ Very fast for multiple queries

✅ Reduces repeated work

✅ Frequently asked in interviews

✅ Foundation for many advanced algorithms

---

# Limitations

❌ Requires extra memory

❌ Preprocessing is required

❌ Mainly useful for cumulative operations

---

# Complexity Summary

| Operation | Complexity |
|-----------|------------|
| Build Prefix | O(n) |
| One Query | O(1) |
| Q Queries | O(n + Q) |
| Space | O(n) |

---

# Prefix Sum Roadmap (LeetCode)

## 🟢 Easy

| Problem No. | Problem |
|-------------|----------|
| 1480 | Running Sum of 1D Array |
| 303 | Range Sum Query - Immutable |
| 724 | Find Pivot Index |

---

## 🟡 Medium

| Problem No. | Problem |
|-------------|----------|
| 560 | Subarray Sum Equals K |
| 523 | Continuous Subarray Sum |
| 525 | Contiguous Array |
| 930 | Binary Subarrays With Sum |
| 974 | Subarray Sums Divisible by K |
| 1248 | Count Number of Nice Subarrays |
| 1314 | Matrix Block Sum |

---

## 🔴 Hard / Advanced

| Problem No. | Problem |
|-------------|----------|
| 304 | Range Sum Query 2D - Immutable |
| 325 | Maximum Size Subarray Sum Equals K *(Premium)* |
| 42 | Trapping Rain Water *(Prefix + Suffix)* |

---

# Interview Checklist

Whenever you read a problem, ask yourself:

✅ Is there an array?

✅ Is there a continuous range (subarray)?

✅ Is the problem asking about sums?

✅ Are there multiple range queries?

✅ Is cumulative information useful?

If the answer is **YES** to any of these,

> **Think Prefix Sum first.**

---

# One-Line Rule to Remember

> **Prefix Sum stores cumulative information so that repeated range-based computations can be answered in constant time after one preprocessing step.** 
