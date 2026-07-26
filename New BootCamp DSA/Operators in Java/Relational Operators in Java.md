# Relational Operators in Java

> Relational operators are used to **compare two values**.  
> The result of every relational operator is always a **boolean** (`true` or `false`).

---

# Relational Operators List

| Operator | Name | Example |
|----------|------|---------|
| `==` | Equal To | `a == b` |
| `!=` | Not Equal To | `a != b` |
| `>` | Greater Than | `a > b` |
| `<` | Less Than | `a < b` |
| `>=` | Greater Than or Equal To | `a >= b` |
| `<=` | Less Than or Equal To | `a <= b` |

---

# Rule

Relational operators always return

```java
true
```

or

```java
false
```

---

# 1. Equal To (`==`)

## Rule

Checks whether both values are equal.

### Syntax

```java
a == b
```

### Example

```java
int a = 10;
int b = 10;

System.out.println(a == b);
```

**Output**

```text
true
```

---

### Example

```java
int a = 10;
int b = 20;

System.out.println(a == b);
```

**Output**

```text
false
```

---

# 2. Not Equal To (`!=`)

## Rule

Checks whether two values are different.

### Example

```java
int a = 10;
int b = 20;

System.out.println(a != b);
```

**Output**

```text
true
```

---

### Example

```java
int a = 30;
int b = 30;

System.out.println(a != b);
```

**Output**

```text
false
```

---

# 3. Greater Than (`>`)

## Rule

Returns `true` if the left value is greater.

### Example

```java
int age = 25;

System.out.println(age > 18);
```

**Output**

```text
true
```

---

### Example

```java
System.out.println(5 > 10);
```

**Output**

```text
false
```

---

# 4. Less Than (`<`)

## Rule

Returns `true` if the left value is smaller.

### Example

```java
System.out.println(5 < 10);
```

**Output**

```text
true
```

---

### Example

```java
System.out.println(15 < 8);
```

**Output**

```text
false
```

---

# 5. Greater Than or Equal To (`>=`)

## Rule

Returns `true` if

- Left value is greater
- OR both are equal

### Example

```java
System.out.println(10 >= 5);
```

**Output**

```text
true
```

---

### Example

```java
System.out.println(10 >= 10);
```

**Output**

```text
true
```

---

### Example

```java
System.out.println(5 >= 10);
```

**Output**

```text
false
```

---

# 6. Less Than or Equal To (`<=`)

## Rule

Returns `true` if

- Left value is smaller
- OR both are equal

### Example

```java
System.out.println(5 <= 10);
```

**Output**

```text
true
```

---

### Example

```java
System.out.println(10 <= 10);
```

**Output**

```text
true
```

---

### Example

```java
System.out.println(20 <= 10);
```

**Output**

```text
false
```

---

# Using Relational Operators in if Statement

```java
int marks = 85;

if (marks >= 40) {
    System.out.println("Pass");
}
```

**Output**

```text
Pass
```

---

# Using Variables

```java
int x = 15;
int y = 20;

System.out.println(x < y);
System.out.println(x > y);
System.out.println(x == y);
```

**Output**

```text
true
false
false
```

---

# Important Difference (`=` vs `==`)

## Assignment Operator (`=`)

Assigns a value.

```java
int a = 10;
```

---

## Equality Operator (`==`)

Compares two values.

```java
System.out.println(a == 10);
```

Output

```text
true
```

---

# Common Mistake

❌ Wrong

```java
if(a = 10)
```

Compilation Error

Reason:

`=` assigns a value.

---

✅ Correct

```java
if(a == 10)
```

---

# String Comparison

## Wrong

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
```

---

## Correct

```java
System.out.println(s1.equals(s2));
```

### Rule

- `==` compares references (memory addresses).
- `.equals()` compares actual string content.

---

# Interview Questions

## Q1

Output?

```java
System.out.println(10 == 10);
```

**Answer**

```text
true
```

---

## Q2

Output?

```java
System.out.println(5 != 10);
```

**Answer**

```text
true
```

---

## Q3

Output?

```java
System.out.println(20 > 15);
```

**Answer**

```text
true
```

---

## Q4

Output?

```java
System.out.println(25 <= 20);
```

**Answer**

```text
false
```

---

## Q5

Output?

```java
int a = 10;

System.out.println(a >= 10);
```

**Answer**

```text
true
```

---

# Practice Questions

Predict the output.

```java
System.out.println(15 == 20);
```

```java
System.out.println(15 != 20);
```

```java
System.out.println(30 > 25);
```

```java
System.out.println(10 < 5);
```

```java
System.out.println(15 >= 15);
```

```java
System.out.println(5 <= 10);
```

---

# Rules to Remember

- Relational operators compare two values.
- Result is always `true` or `false`.
- `==` checks equality.
- `!=` checks inequality.
- `>` checks greater than.
- `<` checks less than.
- `>=` checks greater than or equal to.
- `<=` checks less than or equal to.
- Never confuse `=` with `==`.
- Use `.equals()` to compare String contents.

---

# Summary

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `==` | Equal To | `10 == 10` | `true` |
| `!=` | Not Equal To | `10 != 5` | `true` |
| `>` | Greater Than | `20 > 10` | `true` |
| `<` | Less Than | `5 < 10` | `true` |
| `>=` | Greater Than or Equal | `10 >= 10` | `true` |
| `<=` | Less Than or Equal | `5 <= 10` | `true` |
