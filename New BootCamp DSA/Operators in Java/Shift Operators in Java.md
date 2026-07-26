# Shift Operators in Java

> Shift operators move the binary bits of a number to the left or right.

---

# Shift Operators List

| Operator | Name | Example |
|----------|------|---------|
| `<<` | Left Shift | `a << 2` |
| `>>` | Signed Right Shift | `a >> 2` |
| `>>>` | Unsigned Right Shift | `a >>> 2` |

---

# Binary Refresher

```
Decimal      Binary

1            0001

2            0010

3            0011

4            0100

5            0101

8            1000

16           10000
```

---

# How Shift Operators Work

Suppose

```
5

Binary

00000101
```

If bits move

```
Left

↓

<<
```

If bits move

```
Right

↓

>>

or

>>>
```

---

# 1. Left Shift (<<)

## Rule

- Moves all bits to the **left**.
- Empty positions on the right are filled with **0**.
- Every left shift by **1** approximately multiplies the number by **2**.

---

### Syntax

```java
a << n
```

---

## Example

```java
System.out.println(5 << 1);
```

### Dry Run

```
5

00000101

↓

Shift Left 1

00001010

↓

10
```

Output

```text
10
```

---

## Example

```java
System.out.println(5 << 2);
```

```
5

00000101

↓

00010100

↓

20
```

Output

```text
20
```

---

## Example

```java
System.out.println(8 << 3);
```

```
8

00001000

↓

01000000

↓

64
```

Output

```text
64
```

---

# Shortcut

```
a << n

=

a × 2ⁿ
```

Examples

```
5 << 1

↓

5 × 2

↓

10
```

```
5 << 2

↓

5 × 4

↓

20
```

```
5 << 3

↓

5 × 8

↓

40
```

---

# 2. Signed Right Shift (>>)

## Rule

- Moves bits to the **right**.
- Preserves the **sign bit**.
- Empty positions are filled using the leftmost bit.

Positive Number

```
Fill with 0
```

Negative Number

```
Fill with 1
```

---

### Syntax

```java
a >> n
```

---

## Positive Example

```java
System.out.println(16 >> 2);
```

Binary

```
16

00010000

↓

00000100

↓

4
```

Output

```text
4
```

---

## Example

```java
System.out.println(20 >> 2);
```

```
20

00010100

↓

00000101

↓

5
```

Output

```text
5
```

---

# Shortcut

```
a >> n

=

a / 2ⁿ
```

Only when there is no overflow and for powers of two.

---

# Negative Numbers

Example

```java
System.out.println(-8 >> 1);
```

---

## Step 1

Binary representation of -8

```
11111111 11111111 11111111 11111000
```

---

## Step 2

Shift Right

Since it is negative,

fill left side with

```
1
```

Result

```
11111111 11111111 11111111 11111100
```

---

## Step 3

Convert back

```
Invert

↓

00000000 00000000 00000000 00000011

↓

Add 1

↓

00000000 00000000 00000000 00000100

↓

4

↓

Original number was negative

↓

-4
```

Output

```text
-4
```

---

# Why?

Signed Right Shift keeps the sign.

Negative remains negative.

---

# 3. Unsigned Right Shift (>>>)

## Rule

- Moves bits to the right.
- Always fills left side with **0**.
- Ignores the sign bit.

---

### Syntax

```java
a >>> n
```

---

## Positive Example

```java
System.out.println(16 >>> 2);
```

Output

```text
4
```

---

## Negative Example

```java
System.out.println(-8 >>> 1);
```

---

Original

```
11111111 11111111 11111111 11111000
```

Shift

```
01111111 11111111 11111111 11111100
```

Notice

```
1

↓

0
```

Sign changes.

---

Output

```text
2147483644
```

---

# Why So Large?

Because Java now treats the number as positive.

Binary

```
01111111 11111111 11111111 11111100
```

equals

```
2147483644
```

---

# Difference Between >> and >>>

| Feature | `>>` | `>>>` |
|----------|------|--------|
| Preserves Sign | ✅ Yes | ❌ No |
| Positive Number | Same | Same |
| Negative Number | Stays Negative | Becomes Large Positive |
| Left Side Filled With | Sign Bit | 0 |

---

# Visual Comparison

## Signed Right Shift

```
-8

11111111 11111111 11111111 11111000

↓

>>

11111111 11111111 11111111 11111100

↓

-4
```

---

## Unsigned Right Shift

```
-8

11111111 11111111 11111111 11111000

↓

>>>

01111111 11111111 11111111 11111100

↓

2147483644
```

---

# Common Mistakes

## Mistake 1

Thinking

```
>>

and

>>>

are same.
```

They are **not** the same for negative numbers.

---

## Mistake 2

Expecting

```java
5 >> 1
```

to produce

```
2.5
```

Wrong.

Result

```
2
```

Because shifting works on bits, not decimals.

---

# Interview Questions

## Q1

Output?

```java
System.out.println(5 << 1);
```

Answer

```text
10
```

---

## Q2

Output?

```java
System.out.println(20 >> 2);
```

Answer

```text
5
```

---

## Q3

Output?

```java
System.out.println(-8 >> 1);
```

Answer

```text
-4
```

---

## Q4

Output?

```java
System.out.println(-8 >>> 1);
```

Answer

```text
2147483644
```

---

## Q5

Output?

```java
System.out.println(8 << 2);
```

Answer

```text
32
```

---

# Rules to Remember

- `<<` shifts bits left.
- Right side is filled with `0`.
- `<<` approximately multiplies by `2ⁿ`.
- `>>` shifts bits right and preserves the sign.
- Positive numbers fill with `0`.
- Negative numbers fill with `1`.
- `>>>` always fills with `0`.
- `>>>` can convert a negative number into a large positive number.

---

# Summary

| Operator | Name | Example | Output |
|----------|------|---------|--------|
| `<<` | Left Shift | `5 << 1` | `10` |
| `>>` | Signed Right Shift | `20 >> 2` | `5` |
| `>>>` | Unsigned Right Shift | `-8 >>> 1` | `2147483644` |
