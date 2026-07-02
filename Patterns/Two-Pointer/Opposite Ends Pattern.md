# Day 2 – Two Pointer Technique (Part 1)
# Opposite Ends Pattern

---

# Introduction

In today's lecture, we are learning the **Opposite Ends Two Pointer Pattern**.

Instead of using a single index, we use **two pointers**:

```
Left -------------------- Right
```

Both pointers start from opposite ends of the array/string and move towards each other.

---

## When should you think of this pattern?

Ask yourself these questions:

- Is the array sorted?
- Am I comparing elements from both ends?
- Do I need to find a pair?
- Can I reduce the search space by moving one pointer?

If the answer is **YES**, then Opposite Ends is probably the correct approach.

---

# Problem 1 - Reverse Array In-place

## Pattern

**Two Pointer — Opposite Ends**

---

## Problem Statement

Given an integer array, reverse the array **without using another array**.

### Example

```
Input

1 2 3 4 5

Output

5 4 3 2 1
```

---

# Step 1 : Understand the Problem

We need to reverse the array.

We cannot create another array.

We should modify the existing array.

---

# Step 2 : Brute Force

Create another array.

```
Original

1 2 3 4 5

New

5 4 3 2 1
```

### Complexity

Time : O(n)

Space : O(n)

Can we do it without extra space?

Yes.

---

# Step 3 : Observation

First element should become last.

Last should become first.

Second should become second last.

Instead of moving every element individually,

we can simply **swap**.

---

Visualization

```
1 2 3 4 5

L       R

Swap

5 2 3 4 1
```

Move pointers.

```
5 2 3 4 1

  L   R

Swap

5 4 3 2 1
```

Pointers meet.

Done.

---

# Algorithm

1. Left = 0
2. Right = n-1
3. While Left < Right
    - Swap
    - Left++
    - Right--
4. Finished

---

# Java Solution

```java
public class ReverseArray {

    public static void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Swap both elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers towards center
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        reverse(arr);

        for(int num : arr)
            System.out.print(num + " ");
    }
}
```

---

# Dry Run

```
Array

1 2 3 4 5

Left = 0
Right = 4

Swap

5 2 3 4 1

Left = 1
Right = 3

Swap

5 4 3 2 1

Left = 2
Right = 2

Stop
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

❌ Forgetting to move pointers

❌ Using left <= right

❌ Creating another array

---

# Key Learning

Whenever you need to exchange values from both ends,
think about the Opposite Ends pattern.

==================================================================

# Problem 2 - Valid Palindrome

LeetCode **125**

Pattern

**Two Pointer — Opposite Ends**

---

## Problem Statement

Given a string, determine whether it is a palindrome.

Ignore

- Spaces
- Symbols
- Punctuation
- Uppercase and lowercase differences

---

Example

```
Input

"A man, a plan, a canal: Panama"

Output

true
```

---

# Step 1 : Brute Force

Create a cleaned string.

Reverse it.

Compare both strings.

Complexity

```
Time : O(n)

Space : O(n)
```

Can we avoid creating another string?

Yes.

---

# Observation

Compare characters from both ends.

If both are same

Move inward.

Otherwise

Not palindrome.

---

Visualization

```
madam

L   R

m == m

Move

 a d a

 L   R

a == a

Move

d

Done
```

---

Need one extra rule.

Ignore

```
,
.
:
space
!
@
#
```

---

# Algorithm

```
Left = 0

Right = n-1

While left < right

Ignore non-alphanumeric characters

Convert both characters to lowercase

Compare

If not equal

Return false

Else

Move both pointers

Return true
```

---

# Java Solution

```java
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char ch1 = Character.toLowerCase(s.charAt(left));
            char ch2 = Character.toLowerCase(s.charAt(right));

            if (ch1 != ch2) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(str));
    }
}
```

---

# Dry Run

```
A man, a plan, a canal: Panama

L                       R

Compare

A and a

Equal

Move

Skip spaces

Skip commas

Continue

All equal

Return true
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

❌ Forgetting lowercase conversion

❌ Comparing spaces

❌ Comparing punctuation

---

# Key Learning

When comparison starts from both ends,
Opposite Ends is usually the best choice.

==================================================================

# Problem 3 - Two Sum II

LeetCode **167**

Pattern

**Two Pointer — Opposite Ends**

---

## Problem Statement

Given a **sorted** array, return the **1-indexed positions**
of two numbers whose sum equals the target.

Exactly one solution exists.

---

Example

```
Input

2 7 11 15

Target = 9

Output

1 2
```

---

# Step 1 : Brute Force

Check every pair.

```
2+7

2+11

2+15

7+11

7+15

...
```

Complexity

```
O(n²)
```

Very slow.

---

# Observation

The array is **sorted**.

This is the clue.

---

Visualization

```
2 7 11 15

L       R

Sum

17

Too large

Move Right
```

Now

```
2 7 11

L     R

13

Still large

Move Right
```

Now

```
2 7

L R

9

Answer found
```

---

# Why does this work?

If

```
Sum > Target
```

The larger value is on the right.

Move right pointer.

---

If

```
Sum < Target
```

Need a larger value.

Move left pointer.

---

This only works because

**THE ARRAY IS SORTED**

---

# Algorithm

```
Left = 0

Right = n-1

While left < right

Sum

If sum == target

Return answer

If sum < target

Left++

Else

Right--
```

---

# Java Solution

```java
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {2,7,11,15};

        int target = 9;

        int[] ans = twoSum(arr, target);

        System.out.println(ans[0] + " " + ans[1]);
    }
}
```

---

# Dry Run

```
2 7 11 15

Target = 9

Left = 2

Right = 15

Sum = 17

Too big

Move Right

--------------------

2 7 11

Sum = 13

Too big

Move Right

--------------------

2 7

Sum = 9

Found
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

❌ Using nested loops

❌ Forgetting the array must be sorted

❌ Returning 0-indexed positions instead of 1-indexed

---

# Key Learning

Whenever you see:

- Sorted array
- Pair sum
- Pair difference
- Compare both ends

Immediately think about the **Opposite Ends Two Pointer Pattern**.

---

# Summary of Today's Learning

| Problem | Pattern | Time | Space |
|----------|----------|------|--------|
| Reverse Array | Opposite Ends | O(n) | O(1) |
| Valid Palindrome (LC 125) | Opposite Ends | O(n) | O(1) |
| Two Sum II (LC 167) | Opposite Ends | O(n) | O(1) |

---

## Takeaway

The **Opposite Ends** pattern works best when:

- The data is **sorted**, or
- You need to compare elements from both ends, or
- You need to find a pair efficiently.

In the next session, we'll learn the **Same Direction Two Pointer Pattern**, where one pointer explores the array while the other builds or updates the answer.
