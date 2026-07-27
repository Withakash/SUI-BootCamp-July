# Bitwise Operators for DSA & LeetCode (Java)
> 📚 DSA Bootcamp Notes | Beginner to Intermediate

---

# Table of Contents

1. Introduction
2. Why Learn Bitwise Operators?
3. Binary Number System
4. Bitwise Operators
5. Truth Tables
6. Operator Examples
7. Common Bit Manipulation Tricks
8. Most Asked LeetCode Questions
9. Pattern Recognition
10. Interview Tips

---

# What are Bitwise Operators?

Bitwise operators perform operations **bit-by-bit** on integer values.

Instead of working on decimal numbers, the CPU first converts numbers into **binary (0 and 1)**.

Example

```
5 = 0101

3 = 0011
```

Now operation happens on every bit.

---

# Why Learn Bitwise Operators?

Bit manipulation helps in

- Competitive Programming
- LeetCode
- System Programming
- Operating Systems
- Cryptography
- Embedded Systems
- Game Development

Common Interview Questions

✔ Power of Two

✔ Single Number

✔ Missing Number

✔ Counting Bits

✔ Reverse Bits

✔ Hamming Distance

✔ Subsets

---

# Binary Number System

Decimal → Binary

| Decimal | Binary |
|----------|---------|
|0|0000|
|1|0001|
|2|0010|
|3|0011|
|4|0100|
|5|0101|
|6|0110|
|7|0111|
|8|1000|
|9|1001|
|10|1010|

---

# Java Bitwise Operators

| Operator | Name |
|----------|------|
| & | AND |
| \| | OR |
| ^ | XOR |
| ~ | NOT |
| << | Left Shift |
| >> | Signed Right Shift |
| >>> | Unsigned Right Shift |

---

# 1. Bitwise AND (&)

Rule

```
1 & 1 = 1

1 & 0 = 0

0 & 1 = 0

0 & 0 = 0
```

Example

```
5 = 0101

3 = 0011

------------
    0001

=1
```

Java

```java
public class Demo {

    public static void main(String[] args) {

        System.out.println(5 & 3);

    }

}
```

Output

```
1
```

---

# 2. Bitwise OR (|)

Rule

```
1 | 1 =1

1 | 0 =1

0 | 1 =1

0 | 0 =0
```

Example

```
5 =0101

3 =0011

---------
   0111

=7
```

```java
System.out.println(5 | 3);
```

Output

```
7
```

---

# 3. XOR (^)

Most important operator for LeetCode.

Rule

```
1 ^ 1 =0

0 ^ 0 =0

1 ^ 0 =1

0 ^ 1 =1
```

Example

```
5 =0101

3 =0011

---------
   0110

=6
```

```java
System.out.println(5 ^ 3);
```

Output

```
6
```

---

# XOR Properties

```
a ^ a =0

a ^ 0 =a

0 ^ a =a

a ^ b ^ a =b
```

These four properties solve many LeetCode questions.

---

# 4. NOT (~)

Flips every bit.

```
1→0

0→1
```

Example

```
5

00000101

~

11111010
```

Java

```java
System.out.println(~5);
```

Output

```
-6
```

Formula

```
~n = -(n+1)
```

Example

```
~5

= -(5+1)

=-6
```

---

# 5. Left Shift (<<)

Moves bits left.

Formula

```
n << k

=

n × 2^k
```

Example

```
5 <<1

5×2

=10
```

Binary

```
0101

↓

1010
```

Java

```java
System.out.println(5 << 1);
```

Output

```
10
```

---

# 6. Signed Right Shift (>>)

Formula

```
n >> k

=

n / 2^k
```

(Integer division)

Example

```
20>>2

20/4

=5
```

Binary

```
10100

↓

00101
```

```java
System.out.println(20 >> 2);
```

Output

```
5
```

---

# 7. Unsigned Right Shift (>>>)

Fills leftmost bits with **0**.

Useful for unsigned operations.

```java
System.out.println(-8 >>> 1);
```

Produces a very large positive integer because the sign bit is replaced with 0.

---

# Useful Bit Tricks

---

## Check Even or Odd

```java
if((n & 1)==0)
    System.out.println("Even");
else
    System.out.println("Odd");
```

Reason

Even numbers always end with

```
0
```

Odd numbers always end with

```
1
```

---

## Multiply by 2

```java
n << 1
```

---

## Divide by 2

```java
n >> 1
```

---

## Check Power of Two

```java
(n & (n-1))==0
```

Example

```
8

1000

7

0111

------

0000
```

---

## Swap without Temporary Variable

```java
a = a ^ b;

b = a ^ b;

a = a ^ b;
```

---

## Toggle ith Bit

```java
n ^ (1 << i)
```

---

## Set ith Bit

```java
n | (1 << i)
```

---

## Clear ith Bit

```java
n & ~(1 << i)
```

---

## Check ith Bit

```java
(n & (1<<i))!=0
```

---

# Most Asked LeetCode Questions

---

# 1. Single Number

LeetCode #136

Difficulty

Easy ⭐

Problem

Every element appears twice except one.

Find it.

Example

```
[4,1,2,1,2]

Output

4
```

Solution

```java
class Solution {

    public int singleNumber(int[] nums) {

        int ans=0;

        for(int n:nums)

            ans ^= n;

        return ans;

    }

}
```

Time

```
O(n)
```

Space

```
O(1)
```

---

# 2. Missing Number

LeetCode #268

Example

```
0 1 3

Missing

2
```

Solution

```java
class Solution {

    public int missingNumber(int[] nums) {

        int xor=nums.length;

        for(int i=0;i<nums.length;i++){

            xor ^= i;

            xor ^= nums[i];

        }

        return xor;

    }

}
```

---

# 3. Number of 1 Bits

LeetCode #191

Solution

```java
class Solution {

    public int hammingWeight(int n) {

        int count=0;

        while(n!=0){

            count += n&1;

            n >>>=1;

        }

        return count;

    }

}
```

---

# 4. Counting Bits

LeetCode #338

```java
class Solution {

    public int[] countBits(int n) {

        int[] ans=new int[n+1];

        for(int i=1;i<=n;i++){

            ans[i]=ans[i>>1]+(i&1);

        }

        return ans;

    }

}
```

---

# 5. Reverse Bits

LeetCode #190

Idea

Reverse all 32 bits.

```java
class Solution {

    public int reverseBits(int n) {

        int ans=0;

        for(int i=0;i<32;i++){

            ans <<=1;

            ans |= (n&1);

            n >>>=1;

        }

        return ans;

    }

}
```

---

# 6. Power of Two

LeetCode #231

```java
class Solution {

    public boolean isPowerOfTwo(int n) {

        return n>0 && (n&(n-1))==0;

    }

}
```

---

# 7. Hamming Distance

LeetCode #461

```java
class Solution {

    public int hammingDistance(int x,int y){

        int xor=x^y;

        int count=0;

        while(xor!=0){

            count += xor&1;

            xor>>=1;

        }

        return count;

    }

}
```

---

# Bit Manipulation Patterns

| Pattern | Formula |
|----------|----------|
| Even/Odd | (n & 1) |
| Multiply by 2 | n << 1 |
| Divide by 2 | n >> 1 |
| Check ith Bit | (n & (1<<i)) != 0 |
| Set ith Bit | n \| (1<<i) |
| Clear ith Bit | n & ~(1<<i) |
| Toggle ith Bit | n ^ (1<<i) |
| Remove Lowest Set Bit | n & (n-1) |
| Extract Lowest Set Bit | n & -n |
| Power of Two | (n & (n-1)) == 0 |

---

# Interview Tips

✅ Learn XOR properties by heart.

✅ Understand binary conversion.

✅ Practice shifting positive and negative numbers.

✅ Remember:

```
<<  → Multiply by powers of 2

>>  → Divide by powers of 2

>>> → Unsigned right shift
```

✅ Most bitwise interview questions are based on only a few patterns:

- XOR cancellation
- Masking bits
- Shifting bits
- Power of Two
- Counting set bits

---

# Recommended LeetCode Practice Order

| LeetCode | Problem | Difficulty |
|-----------|----------|------------|
|136|Single Number|Easy|
|268|Missing Number|Easy|
|191|Number of 1 Bits|Easy|
|338|Counting Bits|Easy|
|231|Power of Two|Easy|
|461|Hamming Distance|Easy|
|190|Reverse Bits|Easy|
|201|Bitwise AND of Numbers Range|Medium|
|137|Single Number II|Medium|
|260|Single Number III|Medium|
|78|Subsets|Medium|
|1318|Minimum Flips to Make a OR b Equal to c|Medium|

---

# Quick Revision

- `&` → AND
- `|` → OR
- `^` → XOR
- `~` → NOT
- `<<` → Left Shift (× 2^k)
- `>>` → Signed Right Shift (÷ 2^k)
- `>>>` → Unsigned Right Shift
- `n & 1` → Check Even/Odd
- `n & (n - 1)` → Remove Lowest Set Bit
- `(n & (n - 1)) == 0` → Check Power of Two
- XOR is the key to solving many LeetCode bit manipulation problems.

---
**Next Topic:** Arrays for DSA (Traversal, Input/Output, Searching, Prefix Sum, Sliding Window).
