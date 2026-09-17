# Array Related Problems → LeetCode Pattern Practice

> **Goal:** Don't memorize solutions. Learn how to look at an array problem, identify the requirement, build a brute-force solution, analyze its complexity, and then discover a better pattern.

---

# 1. How to Approach an Array Problem

Whenever you see an array problem, don't immediately think:

> "Which LeetCode pattern is this?"

Instead follow this process:

```text
Understand the Problem
        ↓
Identify Input & Output
        ↓
Try a Small Example
        ↓
Think of Brute Force
        ↓
Write / Explain the Brute Force
        ↓
Calculate Time Complexity
        ↓
Look for Repeated Work
        ↓
Ask: Can I Remember Something?
        ↓
Ask: Can I Avoid Extra Space?
        ↓
Identify the Pattern
        ↓
Optimize
        ↓
Code
        ↓
Dry Run
        ↓
Edge Cases
        ↓
Final Complexity
```

---

# 2. Phase 1 — Normal Array Problems

Before solving difficult LeetCode problems, become comfortable with normal array operations.

These problems may look simple, but they build the thinking required for harder problems.

---

## Problem 1 — Find Maximum Element

### Example

```text
Input:
[10, 25, 7, 45, 18]

Output:
45
```

### Think

We don't know which element is maximum.

Start with:

```text
max = first element
```

Then compare every other element.

### Pattern

```text
Traversal
+
Maintain Maximum
```

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 3. Find Minimum Element

### Example

```text
Input:
[10, 25, 7, 45, 18]

Output:
7
```

### Pattern

```text
Traversal
+
Maintain Minimum
```

---

# 4. Find Sum of All Elements

### Example

```text
Input:
[10, 20, 30, 40]

Output:
100
```

Think:

```text
sum = 0

for every element:
    sum += element
```

### Pattern

```text
Accumulation
```

This pattern will become very important later.

---

# 5. Count Even and Odd Elements

### Example

```text
Input:
[10, 7, 4, 9, 12]

Even = 3
Odd  = 2
```

### Think

Maintain counters:

```text
evenCount
oddCount
```

### Pattern

```text
Counting
```

---

# 6. Count Positive, Negative and Zero

### Example

```text
Input:
[-2, 5, 0, -7, 8, 0]

Positive = 2
Negative = 2
Zero     = 2
```

### Pattern

```text
Traversal
+
Counting
```

---

# 7. Linear Search

### Problem

Find whether a given element exists in an array.

```text
Input:
nums = [10, 20, 30, 40, 50]
target = 30

Output:
true
```

### Think

Check every element one by one.

```text
10 → No
20 → No
30 → Yes
```

### Pattern

```text
Linear Search
```

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 8. Find First Occurrence

### Example

```text
nums = [5, 2, 7, 2, 9]
target = 2

Output:
index = 1
```

### Important

As soon as we find the target, we can stop.

```text
if nums[i] == target:
    return i
```

### Pattern

```text
Traversal + Early Stopping
```

---

# 9. Find Last Occurrence

### Example

```text
nums = [5, 2, 7, 2, 9]
target = 2

Output:
index = 3
```

### Think

Continue traversing and keep updating the answer.

```text
answer = -1

if nums[i] == target:
    answer = i
```

---

# 10. Check Whether Array is Sorted

### Example 1

```text
[1, 2, 3, 5, 8]

Output:
true
```

### Example 2

```text
[1, 5, 3, 8]

Output:
false
```

### Key Observation

We don't need to compare every element with every other element.

Only compare:

```text
nums[i] with nums[i + 1]
```

### Pattern

```text
Adjacent Comparison
```

---

# 11. Find Second Largest Element

### Example

```text
Input:
[10, 50, 20, 40, 30]

Output:
40
```

### First Thought

Sort the array.

```text
[10,20,30,40,50]
```

Then take the second last element.

But sorting costs:

```text
O(n log n)
```

### Better Thinking

Can we maintain:

```text
largest
secondLargest
```

while traversing?

This introduces an important idea:

> **Maintain useful information while moving through the array.**

### Pattern

```text
Maintain State
```

---

# 12. Reverse an Array

### Example

```text
Input:
[1, 2, 3, 4, 5]

Output:
[5, 4, 3, 2, 1]
```

### First Thought

Create another array.

But can we do it **in-place**?

Think about:

```text
left
right
```

and swap:

```text
left ↔ right
```

Then move:

```text
left++
right--
```

### Pattern

```text
Two Pointer
```

This is our first major bridge to LeetCode patterns.

---

# 13. Find Duplicate Elements

### Example

```text
Input:
[1, 2, 3, 2, 4, 1]

Duplicates:
1, 2
```

### Brute Force

Compare every pair.

```text
for i
    for j
```

### Complexity

```text
O(n²)
```

Later we can ask:

> Can we remember which elements we've already seen?

This leads toward:

```text
HashSet / HashMap

```

Leetcode 217

---

# 14. Remove Duplicates

### Example

```text
Input:
[1, 2, 2, 3, 3, 4]

Output:
[1, 2, 3, 4]
```

This problem becomes particularly interesting when the array is **sorted**.

Think:

> Can I use one pointer to read and another pointer to write?

This will lead directly to:

```text
LeetCode 26
Remove Duplicates from Sorted Array
```

---

# 15. Move All Zeroes to the End

### Example

```text
Input:
[0, 1, 0, 3, 12]

Output:
[1, 3, 12, 0, 0]
```

Important requirements:

- Keep non-zero elements in their original order.
- Move zeroes to the end.
- Modify the array in-place.

Think:

```text
Read Pointer
Write Pointer
```

This leads directly to:

```text
LeetCode 283
Move Zeroes
```

---

# 16. Find Missing Number

### Example

```text
Input:
[3, 0, 1]

Numbers should be:
0, 1, 2, 3

Missing:
2
```

Possible approaches:

```text
Brute Force
Sorting
Hashing
Mathematical Sum
XOR
```

This is a good example of:

> **One problem can have multiple valid approaches.**

---

# 17. Phase 2 — LeetCode Array Problems

Now move from normal array problems to LeetCode.

The goal is not simply:

> "Solve the problem."

The goal is:

> **"What pattern can I discover from the problem?"**

---

# Level 1 — Array Fundamentals

## LeetCode 1929 — Concatenation of Array

### Example

```text
Input:
[1, 2, 1]

Output:
[1, 2, 1, 1, 2, 1]
```

### Learn

- Array traversal
- Index mapping
- Creating output arrays

### Pattern

```text
Basic Array Manipulation
```

---

## LeetCode 1470 — Shuffle the Array

### Example

```text
Input:
[2,5,1,3,4,7]

Output:
[2,3,5,4,1,7]
```

### Learn

- Index mapping
- Understanding array structure
- Traversal

### Pattern

```text
Index Mapping
```

---

## LeetCode 1365 — How Many Numbers Are Smaller Than the Current Number

### Example

```text
Input:
[8,1,2,2,3]

Output:
[4,0,1,1,3]
```

### First approach

For every element:

```text
compare it with every other element
```

This gives:

```text
O(n²)
```

Then ask:

> Can we optimize this?

This is an excellent problem for teaching **brute force first**.

---

# Level 2 — Carry Forward / Maintain State

## LeetCode 1480 — Running Sum of 1d Array

### Example

```text
Input:
[1,2,3,4]

Output:
[1,3,6,10]
```

### Pattern

```text
Carry Forward
```

The important question:

> What information from the previous element can I reuse?

Answer:

```text
previous sum
```

---

# LeetCode 121 — Best Time to Buy and Sell Stock

### Example

```text
Input:
[7,1,5,3,6,4]

Output:
5
```

### Pattern

```text
Maintain State
+
Minimum So Far
```

Instead of checking every possible buy/sell pair, maintain:

```text
minimum price seen so far
best profit so far
```

### Key Lesson

```text
1480:
Remember sum so far

121:
Remember minimum so far
```

Different problems, same underlying thinking:

> **Maintain useful information while traversing.**

---

# Level 3 — Two Pointer

## LeetCode 283 — Move Zeroes

```text
[0,1,0,3,12]

→

[1,3,12,0,0]
```

### Pattern

```text
Read Pointer
+
Write Pointer
```

---

# LeetCode 27 — Remove Element

### Example

```text
Input:
nums = [3,2,2,3]
val = 3

Output:
[2,2]
```

The problem asks us to remove elements **in-place**.

### Important Clues

Look for:

```text
"in-place"
remove
ignore
keep
```

These should make you think:

```text
Read → Write
```

### Pattern

```text
Two Pointer
```

---

# LeetCode 26 — Remove Duplicates from Sorted Array

### Example

```text
Input:
[1,1,2]

Output:
[1,2]
```

### Important Clue

The array is:

```text
SORTED
```

That is a huge clue.

Because equal elements are next to each other.

### Pattern

```text
Two Pointer
+
Sorted Array
```

---

# LeetCode 344 — Reverse String

### Example

```text
Input:
['h','e','l','l','o']

Output:
['o','l','l','e','h']
```

### Pattern

```text
Two Pointer
```

Same idea as reversing an array.

### Important Lesson

A pattern is not limited to one problem.

```text
Reverse Array
      ↓
Reverse String
      ↓
Two Pointer
```

---

# LeetCode 977 — Squares of a Sorted Array

### Example

```text
Input:
[-4,-1,0,3,10]

Output:
[0,1,9,16,100]
```

At first this looks easy:

```text
square every element
sort
```

Complexity:

```text
O(n log n)
```

But because the input is already sorted, we can use a better approach.

### Pattern

```text
Two Pointer
+
Sorted Array
```

This is a good problem to teach:

> **Always read the constraints and properties of the input carefully.**

---

# Level 4 — Frequency / Hashing

## LeetCode 217 — Contains Duplicate

### Example

```text
Input:
[1,2,3,1]

Output:
true
```

### Question

How can we know whether we've already seen an element?

Think:

```text
"What have I seen before?"
```

This naturally leads to:

```text
HashSet
```

### Pattern

```text
Frequency / Seen Before
```

---

# LeetCode 136 — Single Number

### Example

```text
Input:
[2,2,1]

Output:
1
```

Every element appears twice except one.

Possible thinking:

```text
Brute Force
Frequency Map
Sorting
XOR
```

This is an excellent example of learning that:

> **The constraints of a problem can suggest a completely different solution.**

---

# LeetCode 169 — Majority Element

### Example

```text
Input:
[2,2,1,1,1,2,2]

Output:
2
```

### Possible approaches

```text
Nested Loop
HashMap
Sorting
Boyer-Moore Voting
```

Don't jump directly to the optimized solution.

First understand the simple solution.

Then ask:

> "Can we solve this with less space?"

---

# Level 5 — Prefix Sum

## LeetCode 724 — Find Pivot Index

### Example

```text
Input:
[1,7,3,6,5,6]

Output:
3
```

At index `3`:

```text
Left Sum  = 1 + 7 + 3 = 11
Right Sum = 5 + 6 = 11
```

### Important Thinking

Instead of repeatedly calculating:

```text
left sum
right sum
```

we can maintain the total sum and left sum.

### Pattern

```text
Prefix Sum
+
Carry Forward
```

---

# Level 6 — Sliding Window

## LeetCode 643 — Maximum Average Subarray I

### Example

```text
nums = [1,12,-5,-6,50,3]
k = 4
```

We need the maximum average of a subarray of size `k`.

### Brute Force

Calculate the sum of every window from scratch.

This repeats work.

### Better Question

If:

```text
[1,12,-5,-6]
```

moves one position:

```text
[12,-5,-6,50]
```

What changed?

```text
Remove 1
Add 50
```

That is the key idea behind:

```text
Sliding Window
```

---

# Level 7 — Kadane's Algorithm

## LeetCode 53 — Maximum Subarray

### Example

```text
Input:
[-2,1,-3,4,-1,2,1,-5,4]

Output:
6
```

The maximum subarray is:

```text
[4,-1,2,1]
```

Sum:

```text
6
```

### Brute Force

Generate every possible subarray.

```text
O(n²)
```

or worse depending on how the sum is calculated.

### Better Thinking

At every position ask:

> "Should I continue the previous subarray or start a new one?"

Maintain:

```text
currentSum
bestSum
```

### Pattern

```text
Kadane's Algorithm
+
Maintain State
```

---

# 18. Pattern Recognition Cheat Sheet

When you see this:

| Problem Clue           | Think About                 |
| ---------------------- | --------------------------- |
| Find maximum           | Maintain maximum            |
| Find minimum           | Maintain minimum            |
| Sum so far             | Carry Forward               |
| Minimum so far         | Maintain State              |
| Maximum so far         | Maintain State              |
| Count something        | Counter / Frequency         |
| Seen before?           | HashSet                     |
| How many times?        | HashMap / Frequency         |
| Sorted array           | Two Pointer / Binary Search |
| Reverse                | Two Pointer                 |
| Remove in-place        | Read/Write Pointer          |
| Move elements          | Two Pointer                 |
| Pair in sorted array   | Two Pointer                 |
| Subarray of fixed size | Sliding Window              |
| Continuous subarray    | Sliding Window / Prefix Sum |
| Range sum              | Prefix Sum                  |
| Maximum subarray sum   | Kadane                      |
| Search in sorted array | Binary Search               |

> **Important:** These are clues, not automatic answers. Always understand the problem first.

---

# 19. The Most Important Question

After solving every problem, ask yourself:

> **Why did I choose this approach?**

For example:

### 1480

```text
Why Carry Forward?

Because previous sum is useful for calculating current sum.
```

### 121

```text
Why Maintain State?

Because we only need the minimum price seen so far.
```

### 283

```text
Why Two Pointer?

Because we need to read elements and place valid elements
at different positions.
```

### 26

```text
Why Two Pointer?

Because the array is sorted and we need to keep unique elements.
```

### 643

```text
Why Sliding Window?

Because we repeatedly examine a fixed-size continuous section.
```

### 53

```text
Why Kadane?

Because we need the maximum sum of a continuous subarray
and can maintain the best result while traversing.
```

---

# 20. Recommended Practice Order

Follow this order instead of randomly solving problems.

```text
NORMAL ARRAY PROBLEMS
        ↓
Maximum
Minimum
Sum
Count
Search
First / Last Occurrence
Check Sorted
Second Largest
Reverse
Duplicates
Missing Number
        ↓
LEETCODE
        ↓
1929 — Concatenation of Array
1470 — Shuffle the Array
1365 — Smaller Numbers Than Current
        ↓
1480 — Running Sum
        ↓
121 — Best Time to Buy and Sell Stock
        ↓
283 — Move Zeroes
        ↓
27 — Remove Element
        ↓
26 — Remove Duplicates
        ↓
344 — Reverse String
        ↓
977 — Squares of a Sorted Array
        ↓
217 — Contains Duplicate
        ↓
136 — Single Number
        ↓
169 — Majority Element
        ↓
724 — Pivot Index
        ↓
643 — Maximum Average Subarray I
        ↓
53 — Maximum Subarray
```

---

# 21. Your Rule for Every LeetCode Problem

Don't do:

```text
Problem
 ↓
Search solution
 ↓
Memorize code
 ↓
Next problem
```

Instead:

```text
Problem
 ↓
Understand
 ↓
Example
 ↓
Brute Force
 ↓
Complexity
 ↓
Find repeated work
 ↓
Find useful information to remember
 ↓
Pattern
 ↓
Optimize
 ↓
Code
 ↓
Dry Run
 ↓
Edge Cases
 ↓
Complexity
 ↓
"Can I recognize this pattern in another problem?"
```

---

# Final Goal

The goal of this array section is **not** to finish 20–30 LeetCode problems.

The goal is to reach this level of thinking:

```text
I see an array problem
        ↓
I understand what is being asked
        ↓
I can create a brute-force solution
        ↓
I can analyze its complexity
        ↓
I can identify repeated work
        ↓
I can decide what information to maintain
        ↓
I recognize the possible pattern
        ↓
I can implement the optimized solution
```

Once students can do this, they are no longer just learning **array questions**.

They are learning **problem-solving**.
