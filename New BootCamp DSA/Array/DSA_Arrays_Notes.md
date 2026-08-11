# DSA — Arrays

## 1. What is an Array?

An **array** is a linear data structure used to store multiple values of the same type in a contiguous block of memory.

Example:

```java
int[] arr = {10, 20, 30, 40, 50};
```

Visual representation:

```text
Index:    0    1    2    3    4
          ↓    ↓    ↓    ↓    ↓
Array:   10   20   30   40   50
```

### Important Properties

- Arrays store multiple elements.
- Elements are accessed using an index.
- Indexing starts from `0` in Java.
- Array size is fixed after creation.
- `arr.length` gives the number of elements.
- Accessing an invalid index causes `ArrayIndexOutOfBoundsException`.

---

# 2. Array Declaration and Initialization

### Declaration

```java
int[] arr;
```

### Creation

```java
arr = new int[5];
```

### Declaration + Creation

```java
int[] arr = new int[5];
```

### Initialization with Values

```java
int[] arr = {10, 20, 30, 40, 50};
```

### Accessing Elements

```java
System.out.println(arr[0]); // 10
System.out.println(arr[3]); // 40
```

### Updating an Element

```java
arr[2] = 100;
```

Array becomes:

```text
[10, 20, 100, 40, 50]
```

---

# 3. Traversing an Array

Traversal means visiting every element of an array.

### Using for loop

```java
int[] arr = {10, 20, 30, 40, 50};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Enhanced for loop

```java
for (int value : arr) {
    System.out.println(value);
}
```

### Which one is important for DSA?

The normal `for` loop is especially important because we get access to the **index**.

```java
for (int i = 0; i < arr.length; i++) {
    // i = index
    // arr[i] = value
}
```

---

# 4. Taking Array Input

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

int[] arr = new int[n];

for (int i = 0; i < n; i++) {
    arr[i] = sc.nextInt();
}
```

Example input:

```text
5
10 20 30 40 50
```

---

# 5. Basic Array Operations

## 5.1 Print All Elements

```java
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```

**Time Complexity:** `O(n)`

---

## 5.2 Find Sum

```java
int sum = 0;

for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
}

System.out.println(sum);
```

Example:

```text
Input:  [10, 20, 30, 40]
Output: 100
```

**Time Complexity:** `O(n)`

---

## 5.3 Find Average

```java
int sum = 0;

for (int value : arr) {
    sum += value;
}

double average = (double) sum / arr.length;
```

**Time Complexity:** `O(n)`

---

# 6. Find Maximum Element

Example:

```text
Input:  [5, 2, 9, 1, 7]
Output: 9
```

Solution:

```java
int max = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
}

System.out.println(max);
```

### Why start with `arr[0]`?

Because the maximum should be initialized using an actual array value.

Avoid:

```java
int max = 0;
```

This can fail when all elements are negative.

Example:

```text
[-10, -5, -20]
```

Correct:

```java
int max = arr[0];
```

**Time Complexity:** `O(n)`

**Space Complexity:** `O(1)`

---

# 7. Find Minimum Element

```java
int min = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    }
}

System.out.println(min);
```

**Time Complexity:** `O(n)`

**Space Complexity:** `O(1)`

---

# 8. Linear Search

Linear Search checks elements one by one.

Example:

```text
Array:  [10, 20, 30, 40, 50]
Target: 30

Output: 2
```

```java
int target = 30;
int index = -1;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        index = i;
        break;
    }
}

System.out.println(index);
```

If the element does not exist:

```text
Output: -1
```

### Complexity

Best Case: `O(1)`

Worst Case: `O(n)`

Average Case: `O(n)`

Space: `O(1)`

---

# 9. Count Occurrences

Find how many times a target occurs.

Example:

```text
Input:  [2, 5, 2, 7, 2, 9]
Target: 2

Output: 3
```

```java
int target = 2;
int count = 0;

for (int value : arr) {
    if (value == target) {
        count++;
    }
}

System.out.println(count);
```

**Time Complexity:** `O(n)`

---

# 10. Count Even and Odd Numbers

```java
int even = 0;
int odd = 0;

for (int value : arr) {
    if (value % 2 == 0) {
        even++;
    } else {
        odd++;
    }
}
```

**Time Complexity:** `O(n)`

---

# 11. Reverse an Array

Example:

```text
Input:
[1, 2, 3, 4, 5]

Output:
[5, 4, 3, 2, 1]
```

Use two pointers:

```text
i →                  ← j
[1, 2, 3, 4, 5]
```

```java
int i = 0;
int j = arr.length - 1;

while (i < j) {

    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    i++;
    j--;
}
```

### Complexity

Time: `O(n)`

Space: `O(1)`

This is an important introduction to the **Two Pointer Technique**.

---

# 12. Check if Array is Sorted

An array is sorted in ascending order if:

```text
arr[i] <= arr[i + 1]
```

for every valid `i`.

Example:

```text
[1, 2, 3, 4, 5] → Sorted
[1, 3, 2, 4, 5] → Not Sorted
```

```java
boolean sorted = true;

for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] > arr[i + 1]) {
        sorted = false;
        break;
    }
}

System.out.println(sorted);
```

**Time Complexity:** `O(n)`

---

# 13. Find Second Largest Element

Example:

```text
Input:
[10, 5, 20, 8, 15]

Output:
15
```

A common approach is to maintain two values:

```java
int largest = Integer.MIN_VALUE;
int secondLargest = Integer.MIN_VALUE;

for (int value : arr) {

    if (value > largest) {
        secondLargest = largest;
        largest = value;
    } else if (value > secondLargest && value != largest) {
        secondLargest = value;
    }
}

System.out.println(secondLargest);
```

### Important

Do not automatically sort the array.

Sorting usually takes:

```text
O(n log n)
```

A single traversal can solve this in:

```text
O(n)
```

This is an important example of **optimization**.

---

# 14. Move Zeroes to the End

Example:

```text
Input:
[0, 1, 0, 3, 12]

Output:
[1, 3, 12, 0, 0]
```

Important requirement:

> Maintain the relative order of non-zero elements.

This introduces the **Two Pointer / Fast-Slow Pointer** idea.

---

# 15. Remove Duplicates from Sorted Array

Example:

```text
Input:
[1, 1, 2, 2, 3]

Output:
[1, 2, 3]
```

Important observation:

> The array is already sorted.

This is an important example of using a property of the input to design an efficient solution.

---

# 16. Missing Number

Example:

```text
Input:
[3, 0, 1]

Numbers should be:
0, 1, 2, 3

Missing:
2
```

This problem introduces techniques such as:

- Mathematical sum
- XOR
- Array traversal

LeetCode:

**268. Missing Number**

---

# 17. Single Number

Example:

```text
Input:
[4, 1, 2, 1, 2]

Output:
4
```

Every element appears twice except one.

This is a good introduction to **XOR**.

LeetCode:

**136. Single Number**

---

# 18. Contains Duplicate

Example:

```text
Input:
[1, 2, 3, 1]

Output:
true
```

The goal is to determine whether any value appears at least twice.

LeetCode:

**217. Contains Duplicate**

This introduces the use of a `HashSet` for efficient lookup.

---

# 19. Two Sum

Example:

```text
Input:
[2, 7, 11, 15]
Target = 9

Output:
[0, 1]
```

Because:

```text
arr[0] + arr[1] = 2 + 7 = 9
```

Start with the brute-force approach:

```java
for (int i = 0; i < arr.length; i++) {

    for (int j = i + 1; j < arr.length; j++) {

        if (arr[i] + arr[j] == target) {
            // answer
        }
    }
}
```

Complexity:

```text
O(n²)
```

Later optimize using `HashMap`:

```text
O(n)
```

LeetCode:

**1. Two Sum**

---

# 20. Best Time to Buy and Sell Stock

Example:

```text
Input:
[7, 1, 5, 3, 6, 4]

Output:
5
```

Buy at:

```text
1
```

Sell at:

```text
6
```

Profit:

```text
6 - 1 = 5
```

Important concepts:

- Minimum so far
- Maximum profit
- Single traversal
- Greedy thinking

LeetCode:

**121. Best Time to Buy and Sell Stock**

---

# 21. Maximum Subarray

Example:

```text
Input:
[-2,1,-3,4,-1,2,1,-5,4]

Output:
6
```

The maximum-sum subarray is:

```text
[4, -1, 2, 1]
```

Sum:

```text
4 - 1 + 2 + 1 = 6
```

This introduces **Kadane's Algorithm**.

LeetCode:

**53. Maximum Subarray**

---

# 22. Important Array Patterns

Most array problems are combinations of a few important patterns.

### Pattern 1 — Traversal

```java
for (int i = 0; i < arr.length; i++) {
}
```

Used for:

- Sum
- Maximum
- Minimum
- Counting
- Searching

---

### Pattern 2 — Two Pointers

```text
left →              ← right
```

Used for:

- Reverse Array
- Two Sum (sorted array)
- Move Zeroes
- Remove Duplicates
- Pair problems

---

### Pattern 3 — Frequency Counting

Used for:

- Count occurrences
- Find duplicates
- Frequency of elements
- Anagram-type problems

Common tools:

```java
HashMap
HashSet
```

---

### Pattern 4 — Prefix Sum

Used when multiple range-sum queries are required.

Example:

```text
Array:
[2, 4, 1, 5, 3]

Prefix:
[2, 6, 7, 12, 15]
```

Formula:

```text
prefix[i] = prefix[i - 1] + arr[i]
```

---

### Pattern 5 — Sliding Window

Used for many contiguous subarray problems.

Example:

```text
[2, 1, 5, 1, 3, 2]
```

Instead of repeatedly calculating the sum of every window, maintain the current window.

---

### Pattern 6 — Kadane's Algorithm

Used for:

> Maximum sum contiguous subarray.

Example:

```text
[-2, 1, -3, 4, -1, 2, 1]
```

Answer:

```text
6
```

---

# 23. Array Complexity Cheat Sheet

| Operation | Complexity |
|---|---:|
| Access `arr[i]` | `O(1)` |
| Update `arr[i]` | `O(1)` |
| Traverse | `O(n)` |
| Linear Search | `O(n)` |
| Find Max/Min | `O(n)` |
| Reverse | `O(n)` |
| Binary Search (sorted array) | `O(log n)` |
| Sorting | Usually `O(n log n)` |
| Insert at beginning | `O(n)` |
| Delete from beginning | `O(n)` |

---

# 24. Important Edge Cases

Always test array solutions with:

### Empty Array

```text
[]
```

### One Element

```text
[10]
```

### All Same Elements

```text
[5, 5, 5, 5]
```

### Negative Numbers

```text
[-10, -5, -20]
```

### Already Sorted

```text
[1, 2, 3, 4, 5]
```

### Reverse Sorted

```text
[5, 4, 3, 2, 1]
```

### Duplicate Values

```text
[1, 2, 2, 3, 3]
```

### Large Input

Always think about the expected constraint:

```text
n <= 10
n <= 1,000
n <= 100,000
n <= 1,000,000
```

The constraint often tells you how efficient your solution needs to be.

---

# 25. LeetCode Array Problem Set

## 🟢 Beginner

| # | Problem | Main Concept |
|---|---|---|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | HashMap / Array |
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Two Pointers |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | Two Pointers |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Greedy |
| 136 | [Single Number](https://leetcode.com/problems/single-number/) | XOR |
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/) | Counting |
| 189 | [Rotate Array](https://leetcode.com/problems/rotate-array/) | Array Manipulation |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | HashSet |
| 268 | [Missing Number](https://leetcode.com/problems/missing-number/) | Math / XOR |
| 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | Two Pointers |

---

## 🟡 Intermediate

| # | Problem | Main Concept |
|---|---|---|
| 53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) | Kadane's Algorithm |
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | Sorting + Two Pointers |
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Two Pointers |
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | Prefix/Suffix |
| 560 | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | Prefix Sum + HashMap |
| 75 | [Sort Colors](https://leetcode.com/problems/sort-colors/) | Two Pointers |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | HashMap + Heap |
| 56 | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | Sorting + Intervals |

---

# 26. Recommended Practice Order

Students should not randomly solve problems.

A good progression is:

```text
Array Basics
    ↓
Traversal
    ↓
Sum / Count
    ↓
Max / Min
    ↓
Linear Search
    ↓
Reverse Array
    ↓
Check Sorted
    ↓
Second Largest
    ↓
Two Pointers
    ↓
Move Zeroes
    ↓
Remove Duplicates
    ↓
HashSet / HashMap
    ↓
Two Sum
    ↓
Missing Number
    ↓
Single Number
    ↓
Stock Buy/Sell
    ↓
Kadane's Algorithm
    ↓
Prefix Sum
    ↓
Sliding Window
```

---

# 27. Key DSA Mindset

When solving an array problem, ask:

### Step 1 — What is given?

```text
Array?
Target?
Constraints?
Sorted or unsorted?
```

### Step 2 — What is required?

```text
Value?
Index?
Count?
Subarray?
Pair?
Maximum?
Minimum?
```

### Step 3 — Can I solve it by traversal?

```text
O(n)
```

### Step 4 — Can I optimize?

Think about:

```text
Two Pointers
HashSet
HashMap
Prefix Sum
Sliding Window
Sorting
Binary Search
Greedy
```

### Step 5 — Check edge cases

```text
Empty
One element
Duplicates
Negative values
Already sorted
Reverse sorted
Large input
```

---

# 28. Quick Practice Problems

Before moving to the next DSA topic, students should be comfortable solving:

1. Print array elements
2. Find sum
3. Find average
4. Find maximum
5. Find minimum
6. Count even/odd numbers
7. Linear search
8. Count occurrences
9. Reverse array
10. Check sorted array
11. Find second largest
12. Move zeroes
13. Remove duplicates
14. Find missing number
15. Find duplicate
16. Two Sum
17. Best Time to Buy and Sell Stock
18. Maximum Subarray

---

# 29. Core Takeaway

An array is simple by itself.

The important DSA skill is learning how to **process the array efficiently**.

The progression is:

```text
Basic Traversal
      ↓
Problem Solving
      ↓
Time Complexity
      ↓
Optimization
      ↓
Patterns
      ↓
Two Pointers
      ↓
Hashing
      ↓
Prefix Sum
      ↓
Sliding Window
      ↓
Advanced Array Problems
```

> **Don't memorize solutions. Learn the pattern behind the solution.**
