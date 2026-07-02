# Day 2 Assignment – Java Collections Framework (Basics)

**Course:** DSA Problem Solving Bootcamp  
**Day:** 2  
**Topic:** Java Collections Framework (Basics)  
**Difficulty:** Easy  
**Platform:** LeetCode  
**Total Questions:** 3  
**Expected Time:** 45–60 Minutes

---

# Instructions

For every problem, follow this process:

1. Read and understand the problem.
2. Identify which Collection Framework class should be used.
3. Think of a brute-force solution first.
4. Optimize using the appropriate collection.
5. Write the Time Complexity.
6. Write the Space Complexity.
7. Submit your solution on LeetCode.

---

# Problem 1 – Contains Duplicate

**LeetCode:** 217

## Topic

**HashSet**

## Concepts Practiced

- HashSet
- add()
- contains()

## Problem Statement

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

### Example

#### Input

```text
nums = [1,2,3,1]
```

#### Output

```text
true
```

---

### Expected Collection

```java
HashSet<Integer>
```

### Expected Complexity

- Time: **O(n)**
- Space: **O(n)**

---

# Problem 2 – Two Sum

**LeetCode:** 1

## Topic

**HashMap**

## Concepts Practiced

- HashMap
- put()
- get()
- containsKey()

## Problem Statement

Given an integer array `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.

You may assume that exactly one solution exists.

### Example

#### Input

```text
nums = [2,7,11,15]
target = 9
```

#### Output

```text
[0,1]
```

---

### Expected Collection

```java
HashMap<Integer, Integer>
```

Store

```text
Value → Index
```

### Expected Complexity

- Time: **O(n)**
- Space: **O(n)**

---

# Problem 3 – Find the Difference of Two Arrays

**LeetCode:** 2215

## Topic

**ArrayList + HashSet**

## Concepts Practiced

- ArrayList
- HashSet
- add()
- contains()

## Problem Statement

Given two integer arrays `nums1` and `nums2`, return a list of two lists:

- Elements present in `nums1` but not in `nums2`
- Elements present in `nums2` but not in `nums1`

Each list should contain **distinct** elements.

### Example

#### Input

```text
nums1 = [1,2,3]
nums2 = [2,4,6]
```

#### Output

```text
[[1,3],[4,6]]
```

---

### Expected Collections

```java
HashSet<Integer>

ArrayList<Integer>
```

### Expected Complexity

- Time: **O(n + m)**
- Space: **O(n + m)**

---

# Reflection Questions

Answer these questions after completing the assignment.

### HashSet

1. Why is `HashSet` faster than checking duplicates using nested loops?
2. What happens if we add the same element twice into a `HashSet`?
3. Does `HashSet` maintain insertion order?

---

### HashMap

4. Why do we store **Value → Index** in Two Sum?
5. Which method is used to check whether a key already exists?
6. What is the average time complexity of `put()` and `get()`?

---

### ArrayList

7. Why is `ArrayList` used to store the final answer instead of an array?
8. Which method adds an element to an `ArrayList`?
9. Which method returns the number of elements in an `ArrayList`?

---

# Topics Covered Today

- ✅ ArrayList
- ✅ HashSet
- ✅ HashMap

---

# Next Class Preview

**Topic:** Two Pointer Technique

We will learn three important patterns:

1. Opposite Ends
2. Same Direction (Slow & Fast)
3. Partition (Dutch National Flag)

These patterns solve many array and string problems in **O(n)** time.
