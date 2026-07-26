# Bitwise Operators in Java

> Bitwise operators work directly on the **binary (bits)** representation of integer values.

---

# What are Bitwise Operators?

Computers store every number in **binary (0 and 1)**.

Example

```text
Decimal : 5

Binary  : 00000101
```

Bitwise operators perform operations on these binary bits.

---

# Bitwise Operators List

| Operator | Name | Example |
|----------|------|---------|
| `&` | Bitwise AND | `a & b` |
| `|` | Bitwise OR | `a \| b` |
| `^` | Bitwise XOR | `a ^ b` |
| `~` | Bitwise NOT | `~a` |

---

# Binary Refresher

```
Decimal    Binary

0          0000

1          0001

2          0010

3          0011

4          0100

5          0101

6          0110

7          0111

8          1000
```

---

# 1. Bitwise AND (&)

## Rule

Returns **1** only when **both bits are 1**.

---

## Truth Table

| A | B | A & B |
|---|---|-------|
| 0 | 0 | 0 |
| 0 | 1 | 0 |
| 1 | 0 | 0 |
| 1 | 1 | 1 |

---

## Example

```java
int a = 5;
int b = 3;

System.out.println(a & b);
```

---

### Dry Run

```
5 = 0101

3 = 0011

------------

    0001
```

Output

```text
1
```

---

## Example

```java
System.out.println(12 & 10);
```

```
12 = 1100

10 = 1010

------------

     1000
```

Output

```text
8
```

---

# 2. Bitwise OR (|)

## Rule

Returns **1** if **at least one bit is 1**.

---

## Truth Table

| A | B | A \| B |
|---|---|--------|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 1 |

---

## Example

```java
int a = 5;
int b = 3;

System.out.println(a | b);
```

Dry Run

```
5 = 0101

3 = 0011

------------

    0111
```

Output

```text
7
```

---

## Example

```java
System.out.println(12 | 10);
```

```
12 = 1100

10 = 1010

------------

     1110
```

Output

```text
14
```

---

# 3. Bitwise XOR (^)

## Rule

Returns **1** only when bits are **different**.

---

## Truth Table

| A | B | A ^ B |
|---|---|-------|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

---

## Example

```java
System.out.println(5 ^ 3);
```

Dry Run

```
5 = 0101

3 = 0011

------------

    0110
```

Output

```text
6
```

---

## Example

```java
System.out.println(10 ^ 12);
```

```
10 = 1010

12 = 1100

------------

     0110
```

Output

```text
6
```

---

# XOR Property (Very Important)

```
0 ^ 0 = 0

1 ^ 1 = 0

0 ^ 1 = 1

1 ^ 0 = 1
```

---

## Number Properties

```
a ^ a = 0

a ^ 0 = a

0 ^ a = a
```

Example

```java
System.out.println(7 ^ 7);
```

Output

```text
0
```

---

# Swapping Using XOR

```java
int a = 10;
int b = 20;

a = a ^ b;
b = a ^ b;
a = a ^ b;

System.out.println(a);
System.out.println(b);
```

Output

```text
20
10
```

---

# 4. Bitwise NOT (~)

## Rule

Flips every bit.

```
0 → 1

1 → 0
```

Shortcut Formula

```
~n = -(n + 1)
```

---

## Example

```java
System.out.println(~5);
```

Output

```text
-6
```

---

Explanation

```
5

↓

00000101

↓

11111010

↓

-6
```

---

## Example

```java
System.out.println(~10);
```

Output

```text
-11
```

---

## Example

```java
System.out.println(~0);
```

Output

```text
-1
```

---

# Even/Odd Check Using Bitwise AND

```java
int number = 18;

if((number & 1) == 0)
    System.out.println("Even");
else
    System.out.println("Odd");
```

Output

```text
Even
```

---

# Common Mistakes

## Mistake 1

Using bitwise operators with floating-point numbers.

```java
5.5 & 3.2
```

❌ Compilation Error

---

## Mistake 2

Confusing

```
&&

and

&
```

Remember

```
&&

↓

Logical

&

↓

Bitwise
```

---

# Interview Questions

## Q1

Output?

```java
System.out.println(5 & 3);
```

Answer

```text
1
```

---

## Q2

Output?

```java
System.out.println(5 | 3);
```

Answer

```text
7
```

---

## Q3

Output?

```java
System.out.println(5 ^ 3);
```

Answer

```text
6
```

---

## Q4

Output?

```java
System.out.println(~5);
```

Answer

```text
-6
```

---

## Q5

Output?

```java
System.out.println(7 ^ 7);
```

Answer

```text
0
```

---

# Rules to Remember

- Bitwise operators work on **binary bits**.
- `&` → 1 only if both bits are 1.
- `|` → 1 if any one bit is 1.
- `^` → 1 if bits are different.
- `~` → Inverts all bits.
- `~n = -(n + 1)`
- `a ^ a = 0`
- `a ^ 0 = a`
- Use `(n & 1)` to check even/odd efficiently.

---

# Summary

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `&` | Bitwise AND | `5 & 3` | `1` |
| `|` | Bitwise OR | `5 \| 3` | `7` |
| `^` | Bitwise XOR | `5 ^ 3` | `6` |
| `~` | Bitwise NOT | `~5` | `-6` |
