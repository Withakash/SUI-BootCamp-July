# Ternary Operator (`?:`) in Java

> The **Ternary Operator** is the **only operator in Java that takes three operands**.  
> It is a shorthand version of the **if-else statement**.

---

# Syntax

```java
condition ? expression1 : expression2;
```

---

# Working

```
          Condition
              |
      ----------------
      |              |
   true            false
      |              |
expression1    expression2
      |              |
      ------Result-----
```

---

# Rule

If the condition is

```
true
```

Java executes

```java
expression1
```

If the condition is

```
false
```

Java executes

```java
expression2
```

---

# Basic Example

```java
int age = 20;

String result = (age >= 18) ? "Eligible" : "Not Eligible";

System.out.println(result);
```

Output

```text
Eligible
```

---

# Dry Run

```
age = 20

↓

20 >= 18

↓

true

↓

"Eligible"

↓

Print
```

---

# Example 2

```java
int age = 15;

String result = (age >= 18) ? "Eligible" : "Not Eligible";

System.out.println(result);
```

Output

```text
Not Eligible
```

---

# Example 3

Largest Number

```java
int a = 10;
int b = 25;

int max = (a > b) ? a : b;

System.out.println(max);
```

Output

```text
25
```

---

# Example 4

Smallest Number

```java
int a = 10;
int b = 25;

int min = (a < b) ? a : b;

System.out.println(min);
```

Output

```text
10
```

---

# Example 5

Even or Odd

```java
int number = 8;

String result = (number % 2 == 0) ? "Even" : "Odd";

System.out.println(result);
```

Output

```text
Even
```

---

# Example 6

Positive or Negative

```java
int number = -20;

String result = (number >= 0) ? "Positive" : "Negative";

System.out.println(result);
```

Output

```text
Negative
```

---

# Example 7

Pass or Fail

```java
int marks = 75;

String result = (marks >= 40) ? "Pass" : "Fail";

System.out.println(result);
```

Output

```text
Pass
```

---

# Nested Ternary Operator

## Rule

One ternary operator can be placed inside another.

### Syntax

```java
condition1
?
expression1
:
(condition2 ? expression2 : expression3);
```

---

## Example

Find Largest Among Three Numbers

```java
int a = 20;
int b = 15;
int c = 30;

int largest =
        (a > b)
        ?
        ((a > c) ? a : c)
        :
        ((b > c) ? b : c);

System.out.println(largest);
```

Output

```text
30
```

---

# Equivalent if-else

```java
if(a > b)
{
    if(a > c)
        largest = a;
    else
        largest = c;
}
else
{
    if(b > c)
        largest = b;
    else
        largest = c;
}
```

---

# Ternary vs if-else

## if-else

```java
if(age >= 18)
{
    result = "Eligible";
}
else
{
    result = "Not Eligible";
}
```

---

## Ternary

```java
result = (age >= 18) ? "Eligible" : "Not Eligible";
```

---

# When to Use

✔ Small conditions

✔ Simple assignments

✔ Returning values

✔ Cleaner code

---

# When NOT to Use

❌ Large logic

❌ Multiple nested conditions

❌ Complex calculations

Use `if-else` instead.

---

# Common Mistakes

## Missing Parentheses

Wrong

```java
int max = a > b ? a : b;
```

✔ Works, but parentheses improve readability.

Better

```java
int max = (a > b) ? a : b;
```

---

## Different Return Types

Wrong

```java
int result = (true) ? 10 : "Hello";
```

Compilation Error

Reason:

Both expressions should be compatible.

---

# Interview Questions

## Q1

Output?

```java
int a = 10;

String result =
        (a > 5)
        ?
        "Yes"
        :
        "No";

System.out.println(result);
```

Answer

```text
Yes
```

---

## Q2

Output?

```java
System.out.println((20 > 30) ? 100 : 200);
```

Answer

```text
200
```

---

## Q3

Output?

```java
int number = 15;

System.out.println((number % 2 == 0) ? "Even" : "Odd");
```

Answer

```text
Odd
```

---

## Q4

Output?

```java
System.out.println((10 < 20) ? (5 > 2) : (3 > 10));
```

Answer

```text
true
```

---

# Practice Questions

Predict the output.

```java
System.out.println((50 > 20) ? "A" : "B");
```

```java
System.out.println((5 % 2 == 0) ? "Even" : "Odd");
```

```java
int x = 30;
int y = 50;

System.out.println((x > y) ? x : y);
```

```java
int marks = 39;

System.out.println((marks >= 40) ? "Pass" : "Fail");
```

---

# Rules to Remember

- Ternary operator uses **three operands**.
- Syntax:

```java
condition ? trueExpression : falseExpression
```

- Returns a value.
- Replaces simple `if-else`.
- Best for short conditions.
- Avoid deeply nested ternary operators for readability.

---

# Summary

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `?:` | Ternary Operator | `(a>b)?a:b` | Returns one of two values based on the condition |
