# Day 2 – Two Pointer Technique (Part 3)
# Partition Pattern (Dutch National Flag)

---

# Introduction

So far, we have learned two Two Pointer patterns.

## Pattern 1

```
Left               Right

1 2 3 4 5 6
```

Used for

- Pair Sum
- Palindrome
- Reverse Array

---

## Pattern 2

```
Slow
Fast

↓

1 2 3 4 5
```

Used for

- Remove Elements
- Remove Duplicates
- Move Zeroes

---

# Today

We learn the third and final Two Pointer pattern.

# Partition

Unlike the previous patterns,

our goal is **NOT**

- finding a pair
- comparing elements
- removing elements

Our goal is

> **Group similar elements together.**

---

# Real Life Example

Imagine you have a basket containing

🍎 Apples

🍊 Oranges

🍌 Bananas

Mixed together.

```
🍎 🍌 🍊 🍊 🍎 🍌 🍎
```

Your task is NOT to sort alphabetically.

You only need

```
🍎 🍎 🍎 🍊 🍊 🍌 🍌
```

We are simply **partitioning** the items.

---

# The Idea

Divide the array into regions.

Some regions are already correct.

Only one region is unknown.

Example

```
Correct | Unknown | Correct
```

We slowly shrink the unknown region.

---

# Problem

# Sort Colors

**LeetCode 75**

Pattern

**Partition / Dutch National Flag**

Difficulty ⭐⭐⭐

---

## Problem Statement

Given an array containing only

```
0
1
2
```

Sort the array **in-place**.

You **cannot** use the built-in sort.

---

Example

```
Input

2 0 2 1 1 0

Output

0 0 1 1 2 2
```

---

# Step 1

Brute Force

Simply call

```
Arrays.sort()
```

Complexity

```
O(n log n)
```

But

The interviewer says

> Solve in one pass.

Need

```
O(n)
```

---

# Step 2

Observation

Only three numbers exist.

```
0

1

2
```

We don't need full sorting.

We only need

```
All 0

Then all 1

Then all 2
```

---

# Think Differently

Instead of sorting,

let's divide the array into regions.

Initially

```
Unknown Unknown Unknown Unknown Unknown
```

Gradually

```
0 Region

1 Region

Unknown

2 Region
```

---

# Three Pointers

We use

```
Low

Mid

High
```

---

Initially

```
2 0 2 1 1 0

L
M
          H
```

Meaning

```
Everything before Low

Already 0

Everything after High

Already 2

Middle

Unknown
```

---

# Regions

Always remember

```
0 Region

1 Region

Unknown

2 Region
```

Visualization

```
| 0s | 1s | Unknown | 2s |

       M
L                 H
```

---

# Rules

## Case 1

Current number is

```
0
```

Swap with Low.

Both Low and Mid move.

Because

After swapping,

both regions become correct.

---

Visualization

```
2 0 2 1 1 0

L
M

Current = 2

No

--------------------

Current becomes 0

Swap

0 2 2 1 1 0

L
M
```

---

## Case 2

Current number is

```
1
```

Already belongs in middle.

Simply

```
Mid++
```

Nothing else.

---

## Case 3

Current number is

```
2
```

Swap with High.

Move High only.

Do NOT move Mid.

Why?

Because

The swapped element from the end is unknown.

Need to check it again.

This is the most common mistake.

---

# Algorithm

```
Low = 0

Mid = 0

High = n-1

While Mid <= High

If nums[Mid] == 0

Swap Low and Mid

Low++

Mid++

----------------------

Else if nums[Mid] == 1

Mid++

----------------------

Else

Swap Mid and High

High--
```

---

# Dry Run

Input

```
2 0 2 1 1 0
```

Initially

```
L
M
          H

2 0 2 1 1 0
```

---

Current

```
2
```

Swap with High

```
0 0 2 1 1 2

L
M
        H
```

Notice

Mid did NOT move.

---

Again

Current

```
0
```

Swap Low

```
0 0 2 1 1 2

  L
  M
        H
```

---

Again

```
0
```

Swap

```
0 0 2 1 1 2

    L
    M
      H
```

---

Current

```
2
```

Swap

```
0 0 1 1 2 2

    L
    M
    H
```

---

Current

```
1
```

Move Mid.

---

Current

```
1
```

Move Mid.

Done.

---

# Java Solution

```java
public class SortColors {

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                // Swap low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            }
            else if (nums[mid] == 1) {

                // 1 is already in the correct region
                mid++;

            }
            else {

                // Swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Do not move mid
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);

        for(int num : nums)
            System.out.print(num + " ");
    }
}
```

---

# Why don't we increment Mid after swapping with High?

Suppose

```
2 0 1
```

Swap

```
1 0 2
```

The value that came from High

```
1
```

has never been checked.

If we move Mid immediately,

we may skip it.

Therefore

```
High--

Mid stays
```

This is the most important concept in this algorithm.

---

# Complexity

Time

```
O(n)
```

Each element is processed at most once.

---

Space

```
O(1)
```

Everything is done in-place.

---

# Common Mistakes

❌ Using Arrays.sort()

❌ Moving Mid after swapping with High

❌ Forgetting the meaning of each region

❌ Using nested loops

---

# Visualization to Remember

```
Before

| 0 | 1 | Unknown | 2 |

After every iteration

Unknown region becomes smaller.

Eventually

| 0 | 1 | 2 |
```

---

# Pattern Summary

| Pattern | Starting Position | Used For | Example Problems |
|----------|-------------------|-----------|------------------|
| Opposite Ends | Left & Right | Pair Sum, Palindrome | LC 125, LC 167 |
| Same Direction | Slow & Fast | Remove, Compress, Shift | LC 27, LC 26, LC 283 |
| Partition | Low, Mid, High | Rearranging Groups | LC 75 |

---

# Decision Tree

```
Need to compare both ends?

↓

Opposite Ends

--------------------------------

Need to remove, compress, or move elements?

↓

Same Direction

--------------------------------

Need to rearrange elements into groups?

↓

Partition
```

---

# Final Takeaway

By learning just **three Two Pointer patterns**, you can solve dozens of interview questions.

- **Opposite Ends** → Compare or find pairs in sorted data.
- **Same Direction** → Build or modify the array in-place.
- **Partition** → Rearrange elements into different groups without fully sorting.

> **Golden Rule:** Before writing any code, first identify **which Two Pointer pattern** the problem belongs to. Pattern recognition is often more important than memorizing the solution.
