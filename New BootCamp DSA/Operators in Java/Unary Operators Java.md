# Unary Operators in Java

> Unary operators work on **only one operand (one variable or one value).**

---

# Unary Operators List

| Operator | Name | Purpose |
|----------|------|---------|
| `+` | Unary Plus | Indicates positive value |
| `-` | Unary Minus | Negates the value |
| `++` | Increment | Increases value by 1 |
| `--` | Decrement | Decreases value by 1 |
| `!` | Logical NOT | Reverses boolean value |
| `~` | Bitwise NOT | Inverts all bits |

---

# 1. Unary Plus (`+`)

## Rule

- Indicates a positive number.
- Does **not** change the value.
- Mostly used for readability.

### Syntax

```java
+variable
```

### Example

```java
int a = 10;

System.out.println(+a);
```

**Output**

```text
10
```

---

## Example

```java
int a = -20;

System.out.println(+a);
```

**Output**

```text
-20
```

---

# Rules

- ✔ Does not modify the value.
- ✔ Rarely used in real projects.
- ✔ Mostly used in mathematical expressions.

---

# 2. Unary Minus (`-`)

## Rule

- Changes the sign of a number.
- Positive → Negative
- Negative → Positive

### Syntax

```java
-variable
```

### Example

```java
int a = 10;

System.out.println(-a);
```

**Output**

```text
-10
```

---

### Example

```java
int a = -25;

System.out.println(-a);
```

**Output**

```text
25
```

---

# Rules

- ✔ Does not change the original variable.
- ✔ Only changes the value used in the expression.

Example

```java
int a = 10;

System.out.println(-a);
System.out.println(a);
```

**Output**

```text
-10
10
```

---

# 3. Increment Operator (`++`)

## Rule

- Increases the value by **1**.

Equivalent to

```java
a = a + 1;
```

---

# Types

- Pre Increment (`++a`)
- Post Increment (`a++`)

---

# Pre Increment (`++a`)

## Rule

- Increment first.
- Use updated value.

```java
int a = 10;

System.out.println(++a);
```

**Output**

```text
11
```

---

### Dry Run

```
a = 10

↓

++a

↓

11

↓

Print 11
```

---

### Example

```java
int a = 5;

int b = ++a;

System.out.println(a);
System.out.println(b);
```

**Output**

```text
6
6
```

---

# Post Increment (`a++`)

## Rule

- Use current value.
- Increment later.

```java
int a = 10;

System.out.println(a++);
```

**Output**

```text
10
```

```java
System.out.println(a);
```

**Output**

```text
11
```

---

### Dry Run

```
a = 10

↓

Print 10

↓

Increment

↓

11
```

---

### Example

```java
int a = 5;

int b = a++;

System.out.println(a);
System.out.println(b);
```

**Output**

```text
6
5
```

---

# Difference

| Pre Increment | Post Increment |
|---------------|----------------|
| Increment First | Use First |
| Then Use | Increment Later |
| `++a` | `a++` |

---

# 4. Decrement Operator (`--`)

## Rule

- Decreases the value by **1**.

Equivalent to

```java
a = a - 1;
```

---

# Types

- Pre Decrement (`--a`)
- Post Decrement (`a--`)

---

# Pre Decrement

```java
int a = 10;

System.out.println(--a);
```

**Output**

```text
9
```

---

### Example

```java
int a = 5;

int b = --a;

System.out.println(a);
System.out.println(b);
```

**Output**

```text
4
4
```

---

# Post Decrement

```java
int a = 10;

System.out.println(a--);
```

**Output**

```text
10
```

```java
System.out.println(a);
```

**Output**

```text
9
```

---

### Example

```java
int a = 5;

int b = a--;

System.out.println(a);
System.out.println(b);
```

**Output**

```text
4
5
```

---

# Difference

| Pre Decrement | Post Decrement |
|---------------|----------------|
| Decrement First | Use First |
| Then Use | Decrement Later |
| `--a` | `a--` |

---

# 5. Logical NOT (`!`)

## Rule

- Works only with boolean values.
- Reverses the boolean value.

```
true  → false

false → true
```

---

### Example

```java
boolean isLoggedIn = true;

System.out.println(!isLoggedIn);
```

**Output**

```text
false
```

---

### Example

```java
boolean rain = false;

System.out.println(!rain);
```

**Output**

```text
true
```

---

# Rules

- ✔ Works only with boolean.
- ❌ Cannot be used with integers.

Wrong

```java
!10
```

Compilation Error

---

# 6. Bitwise NOT (`~`)

## Rule

- Inverts every bit.
- Works only with integer types.

Shortcut

```
~n = -(n + 1)
```

---

### Example

```java
System.out.println(~5);
```

**Output**

```text
-6
```

---

### Example

```java
System.out.println(~10);
```

**Output**

```text
-11
```

---

### Example

```java
System.out.println(~0);
```

**Output**

```text
-1
```

---

# Rules

- ✔ Works with byte, short, int, long.
- ❌ Does not work with float, double, boolean.

---

# Interview Questions

## Q1

Output?

```java
int a = 5;

System.out.println(++a);
```

**Answer**

```text
6
```

---

## Q2

Output?

```java
int a = 5;

System.out.println(a++);
System.out.println(a);
```

**Answer**

```text
5
6
```

---

## Q3

Output?

```java
System.out.println(!true);
```

**Answer**

```text
false
```

---

## Q4

Output?

```java
System.out.println(~5);
```

**Answer**

```text
-6
```

---

# Rules to Remember

- Unary operators work on **one operand** only.
- `+` → Positive sign.
- `-` → Reverse sign.
- `++` → Increase by 1.
- `--` → Decrease by 1.
- `++a` → Increment first, then use.
- `a++` → Use first, then increment.
- `--a` → Decrement first, then use.
- `a--` → Use first, then decrement.
- `!` → Reverse boolean value.
- `~` → Invert all bits (`~n = -(n + 1)`).

---

# Summary

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `+` | Unary Plus | `+a` | Positive value |
| `-` | Unary Minus | `-a` | Reverse sign |
| `++` | Increment | `++a` / `a++` | +1 |
| `--` | Decrement | `--a` / `a--` | -1 |
| `!` | Logical NOT | `!true` | `false` |
| `~` | Bitwise NOT | `~5` | `-6` |
