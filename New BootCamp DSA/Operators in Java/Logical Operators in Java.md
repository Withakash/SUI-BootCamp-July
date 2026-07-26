# Logical Operators in Java

> Logical operators are used to **combine or reverse boolean expressions**.  
> They always work with **boolean values** and return either `true` or `false`.

---

# Logical Operators List

| Operator | Name | Example |
|----------|------|---------|
| `&&` | Logical AND | `a && b` |
| `||` | Logical OR | `a || b` |
| `!` | Logical NOT | `!a` |

---

# Rule

Logical operators work only with **boolean expressions**.

✔ Valid

```java
true && false
```

```java
10 > 5 && 20 > 15
```

❌ Invalid

```java
10 && 20
```

Compilation Error

---

# 1. Logical AND (&&)

## Rule

Returns **true** only if **both conditions are true**.

### Syntax

```java
condition1 && condition2
```

---

## Truth Table

| Condition 1 | Condition 2 | Result |
|-------------|-------------|--------|
| true | true | true |
| true | false | false |
| false | true | false |
| false | false | false |

---

## Example

```java
int age = 20;

System.out.println(age >= 18 && age <= 60);
```

Output

```text
true
```

---

## Example

```java
int age = 65;

System.out.println(age >= 18 && age <= 60);
```

Output

```text
false
```

---

## Example

```java
System.out.println(10 > 5 && 20 > 10);
```

Output

```text
true
```

---

## Example

```java
System.out.println(10 > 15 && 20 > 10);
```

Output

```text
false
```

---

# Real Life Example

Login System

```java
String username = "admin";
String password = "1234";

boolean login =
        username.equals("admin")
        && password.equals("1234");

System.out.println(login);
```

Output

```text
true
```

Both conditions must be true.

---

# Short-Circuit in AND

## Rule

If the **first condition is false**, Java does **not** check the second condition.

Example

```java
System.out.println(false && true);
```

Java evaluates

```
false

↓

No need to check next condition

↓

false
```

---

Example

```java
int a = 10;

System.out.println(a > 20 && ++a > 5);

System.out.println(a);
```

Output

```text
false
10
```

Why?

```
a > 20

↓

false

↓

Second condition skipped

↓

a remains 10
```

---

# 2. Logical OR (||)

## Rule

Returns **true** if **at least one condition is true**.

### Syntax

```java
condition1 || condition2
```

---

## Truth Table

| Condition 1 | Condition 2 | Result |
|-------------|-------------|--------|
| true | true | true |
| true | false | true |
| false | true | true |
| false | false | false |

---

## Example

```java
System.out.println(10 > 5 || 20 < 10);
```

Output

```text
true
```

---

## Example

```java
System.out.println(5 > 10 || 20 < 10);
```

Output

```text
false
```

---

## Example

```java
int marks = 35;

System.out.println(marks >= 40 || marks >= 35);
```

Output

```text
true
```

---

# Short-Circuit in OR

## Rule

If the **first condition is true**, Java does **not** evaluate the second condition.

Example

```java
int a = 10;

System.out.println(a == 10 || ++a > 20);

System.out.println(a);
```

Output

```text
true
10
```

Reason

```
First Condition

↓

true

↓

Second condition skipped

↓

a remains 10
```

---

# 3. Logical NOT (!)

## Rule

Reverses a boolean value.

```
true

↓

false

false

↓

true
```

---

## Example

```java
boolean isAdmin = true;

System.out.println(!isAdmin);
```

Output

```text
false
```

---

## Example

```java
System.out.println(!(10 > 5));
```

Output

```text
false
```

---

## Example

```java
System.out.println(!(10 < 5));
```

Output

```text
true
```

---

# Complex Example

```java
int age = 25;
boolean citizen = true;

if (age >= 18 && citizen) {
    System.out.println("Eligible");
}
```

Output

```text
Eligible
```

---

# Difference Between && and &

## && (Logical AND)

- Works with boolean values.
- Uses short-circuit evaluation.

```java
false && anything
```

Second condition is skipped.

---

## & (Bitwise AND)

- Works with bits.
- Can also work with booleans.
- Evaluates both expressions.

Example

```java
int a = 10;

System.out.println(false & ++a > 10);

System.out.println(a);
```

Output

```text
false
11
```

Notice

```
Second condition executed.
```

---

# Difference Between || and |

## || (Logical OR)

Short-circuit.

Stops if first condition is true.

---

## | (Bitwise OR)

Always evaluates both expressions.

---

# Common Mistakes

## Mistake 1

```java
10 && 20
```

Compilation Error

Logical operators work only with boolean values.

---

## Mistake 2

```java
if(age > 18 || age < 60)
```

This is wrong if checking an age range.

Correct

```java
if(age >= 18 && age <= 60)
```

---

## Mistake 3

```java
!5
```

Compilation Error

`!` works only with boolean values.

---

# Interview Questions

## Q1

Output?

```java
System.out.println(true && false);
```

Answer

```text
false
```

---

## Q2

Output?

```java
System.out.println(true || false);
```

Answer

```text
true
```

---

## Q3

Output?

```java
System.out.println(!false);
```

Answer

```text
true
```

---

## Q4

Output?

```java
int a = 5;

System.out.println(false && ++a > 5);

System.out.println(a);
```

Answer

```text
false
5
```

---

## Q5

Output?

```java
int a = 5;

System.out.println(true || ++a > 5);

System.out.println(a);
```

Answer

```text
true
5
```

---

# Practice Questions

Predict the output.

```java
System.out.println(10 > 5 && 20 > 10);
```

```java
System.out.println(10 < 5 || 20 > 10);
```

```java
System.out.println(!(5 > 2));
```

```java
System.out.println((10 > 5) && (5 > 20));
```

```java
System.out.println((10 < 5) || (20 > 10));
```

---

# Rules to Remember

- Logical operators work only with boolean values.
- `&&` returns true only if **both** conditions are true.
- `||` returns true if **any one** condition is true.
- `!` reverses a boolean value.
- `&&` uses short-circuit evaluation.
- `||` uses short-circuit evaluation.
- `&` and `|` always evaluate both operands.
- Use `&&` for checking ranges.
- Use `||` when multiple conditions can satisfy a requirement.

---

# Summary

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `&&` | Logical AND | `true && false` | `false` |
| `||` | Logical OR | `true || false` | `true` |
| `!` | Logical NOT | `!true` | `false` |
