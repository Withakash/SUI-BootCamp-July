# Day 2 – Two Pointer Technique (Part 2)
# Same Direction Pattern

---

# Introduction

In the previous lecture, we learned the **Opposite Ends** pattern.

Today, we will learn another important Two Pointer pattern:

# Same Direction Two Pointer

Instead of starting from opposite ends, both pointers start from the **left side** and move towards the **right**.

```
Slow
Fast

↓

0 1 2 3 4 5 6
```

Both pointers move in the same direction.

---

# When should you think of this pattern?

Ask yourself these questions:

- Do I need to remove elements?
- Do I need to remove duplicates?
- Do I need to shift elements?
- Do I need to modify the array in-place?
- Do I want to build the answer while scanning the array?

If **YES**, think about the **Same Direction** pattern.

---

# Roles of the Pointers

## Fast Pointer

- Reads the array.
- Explores every element.
- Never skips any element.

Think of it as the **reader**.

---

## Slow Pointer

- Writes the answer.
- Keeps track of where the next valid element should go.

Think of it as the **writer**.

---

Visualization

```
0 1 2 3 4 5

S
F

Fast explores

Slow builds answer
```

---

==================================================================

# Problem 1 - Remove Element

LeetCode **27**

Pattern

**Same Direction**

---

## Problem Statement

Given an integer array `nums` and an integer `val`,
remove all occurrences of `val` in-place.

Return the number of remaining elements.

---

Example

```
Input

nums = [3,2,2,3]

val = 3

Output

2

Remaining array

2 2
```

---

# Step 1 : Brute Force

Create another array.

Copy only valid elements.

Complexity

```
Time O(n)

Space O(n)
```

Can we do it in-place?

Yes.

---

# Observation

Fast visits every element.

Whenever Fast finds a valid element,

Slow stores it.

---

Visualization

```
3 2 2 3

S
F

3 is removed

Fast++

-------------------

3 2 2 3

S
  F

Copy 2

2 2 2 3

Slow++

Fast++

-------------------

2 2

Done
```

---

# Algorithm

```
Slow = 0

For every Fast

If current element is NOT val

Copy it

Slow++
```

---

# Java Solution

```java
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {

            if (nums[fast] != val) {

                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,2,3};

        int length = removeElement(nums,3);

        System.out.println(length);

        for(int i=0;i<length;i++)
            System.out.print(nums[i]+" ");
    }
}
```

---

# Complexity

Time

```
O(n)
```

Space

```
O(1)
```

---

# Common Mistakes

❌ Shifting elements repeatedly

❌ Creating another array

❌ Returning array length instead of new size

---

==================================================================

# Problem 2 - Remove Duplicates from Sorted Array

LeetCode **26**

Pattern

**Same Direction**

---

## Problem Statement

Given a sorted array,
remove duplicates in-place.

Return the number of unique elements.

---

Example

```
Input

1 1 2

Output

Length = 2

Array

1 2
```

---

# Observation

Since the array is sorted,

duplicates are adjacent.

Fast checks every element.

Slow stores only new elements.

---

Visualization

```
1 1 2 2 3

S
F

Duplicate

Fast++

-----------------

1 1 2 2 3

S
  F

Different

Copy

1 2 2 2 3

Slow++

-----------------

Continue...
```

---

# Algorithm

```
Slow = 1

Fast = 1

If nums[fast] != nums[slow-1]

Copy

Slow++
```

---

# Java Solution

```java
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if(nums.length==0)
            return 0;

        int slow = 1;

        for(int fast=1; fast<nums.length; fast++) {

            if(nums[fast] != nums[slow-1]) {

                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,3,4};

        int length = removeDuplicates(arr);

        System.out.println(length);

        for(int i=0;i<length;i++)
            System.out.print(arr[i]+" ");
    }
}
```

---

# Dry Run

```
1 1 2 2 3

Slow=1

Fast=1

Duplicate

Skip

----------------

Fast=2

Different

Copy

1 2 2 2 3

Slow++

Continue...
```

---

# Complexity

Time

```
O(n)
```

Space

```
O(1)
```

---

# Common Mistakes

❌ Forgetting array is sorted

❌ Comparing wrong indices

❌ Starting Slow from 0

---

==================================================================

# Problem 3 - Move Zeroes

LeetCode **283**

Pattern

**Same Direction**

---

## Problem Statement

Move all zeroes to the end while maintaining the relative order of non-zero elements.

Must be done in-place.

---

Example

```
Input

0 1 0 3 12

Output

1 3 12 0 0
```

---

# Brute Force

Create another array.

Copy all non-zero elements.

Fill remaining positions with zero.

Complexity

```
Time O(n)

Space O(n)
```

Can we avoid extra space?

Yes.

---

# Observation

Fast reads every number.

Whenever Fast finds a non-zero value,

Slow stores it.

After finishing,

fill remaining positions with zero.

---

Visualization

```
0 1 0 3 12

S
F

0

Skip

------------------

0 1 0 3 12

S
  F

Copy

1 1 0 3 12

Slow++

------------------

Continue...
```

After copying

```
1 3 12 ? ?

Fill with zero

1 3 12 0 0
```

---

# Algorithm

```
Slow = 0

Traverse using Fast

Copy non-zero values

Increase Slow

After traversal

Fill remaining indices with zero
```

---

# Java Solution

```java
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int slow = 0;

        // Copy all non-zero elements
        for(int fast = 0; fast < nums.length; fast++) {

            if(nums[fast] != 0) {

                nums[slow] = nums[fast];
                slow++;
            }
        }

        // Fill remaining positions with zero
        while(slow < nums.length) {

            nums[slow] = 0;
            slow++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        for(int num : nums)
            System.out.print(num+" ");
    }
}
```

---

# Dry Run

```
0 1 0 3 12

Slow=0

Fast=0

Zero

Skip

----------------

Fast=1

Copy

1 _ _ _ _

Slow=1

----------------

Fast=2

Skip

----------------

Fast=3

Copy

1 3 _ _ _

----------------

Fast=4

Copy

1 3 12 _ _

Fill remaining

1 3 12 0 0
```

---

# Complexity

Time

```
O(n)
```

Space

```
O(1)
```

---

# Common Mistakes

❌ Swapping every time unnecessarily

❌ Forgetting to fill remaining positions with zero

❌ Using extra arrays

---

# Summary

| Problem | Pattern | Time | Space |
|----------|----------|------|--------|
| Remove Element (LC 27) | Same Direction | O(n) | O(1) |
| Remove Duplicates (LC 26) | Same Direction | O(n) | O(1) |
| Move Zeroes (LC 283) | Same Direction | O(n) | O(1) |

---

# Final Takeaway

The **Same Direction Two Pointer** pattern is used when:

- You are **modifying an array in-place**.
- You are **removing elements or duplicates**.
- You are **moving or compressing elements**.
- One pointer **reads** the array (**Fast**), while the other **builds the answer** (**Slow**).

> **Memory Trick:**  
> **Fast Finds → Slow Stores**

If you remember this one sentence, you'll recognize many Same Direction two-pointer problems immediately.
