# Assignment Operators in Java

> Assignment operators are used to **assign or update values** stored in variables.

---

# Assignment Operators List

| Operator | Name | Equivalent To |
|----------|------|---------------|
| `=` | Assignment | Assign Value |
| `+=` | Add & Assign | `a = a + b` |
| `-=` | Subtract & Assign | `a = a - b` |
| `*=` | Multiply & Assign | `a = a * b` |
| `/=` | Divide & Assign | `a = a / b` |
| `%=` | Modulus & Assign | `a = a % b` |

---

# 1. Assignment Operator (`=`)

## Rule

- Assigns the value on the right to the variable on the left.
- Existing value is replaced.

### Syntax

```java
variable = value;
```

### Example

```java
int age = 20;

System.out.println(age);
```

**Output**

```text
20
```

---

### Example

```java
int marks = 70;

marks = 85;

System.out.println(marks);
```

**Output**

```text
85
```

---

# Rules

- ✔ Left side must be a variable.
- ✔ Right side can be a value, variable, or expression.
- ✔ Old value is overwritten.

---

# 2. Add and Assign (`+=`)

## Rule

Adds the right value and stores the result.

Equivalent to

```java
a = a + b;
```

### Syntax

```java
a += b;
```

### Example

```java
int salary = 5000;

salary += 1000;

System.out.println(salary);
```

**Output**

```text
6000
```

---

### Example

```java
int x = 10;

x += 5;

System.out.println(x);
```

**Output**

```text
15
```

---

# Rules

- ✔ Short form of `a = a + b`
- ✔ Updates the original variable.

---

# 3. Subtract and Assign (`-=`)

## Rule

Subtracts and stores the result.

Equivalent to

```java
a = a - b;
```

### Example

```java
int wallet = 1000;

wallet -= 250;

System.out.println(wallet);
```

**Output**

```text
750
```

---

### Example

```java
int x = 20;

x -= 8;

System.out.println(x);
```

**Output**

```text
12
```

---

# Rules

- ✔ Updates the same variable.
- ✔ Short form of subtraction assignment.

---

# 4. Multiply and Assign (`*=`)

## Rule

Multiplies and stores the result.

Equivalent to

```java
a = a * b;
```

### Example

```java
int quantity = 5;

quantity *= 4;

System.out.println(quantity);
```

**Output**

```text
20
```

---

### Example

```java
int x = 7;

x *= 3;

System.out.println(x);
```

**Output**

```text
21
```

---

# Rules

- ✔ Updates the original value.
- ✔ Short form of multiplication assignment.

---

# 5. Divide and Assign (`/=`)

## Rule

Divides and stores the result.

Equivalent to

```java
a = a / b;
```

### Example

```java
int number = 20;

number /= 5;

System.out.println(number);
```

**Output**

```text
4
```

---

### Example

```java
int number = 7;

number /= 2;

System.out.println(number);
```

**Output**

```text
3
```

---

# Rules

- ✔ Integer division follows Java rules.
- ✔ Decimal part is discarded for integer variables.

---

# 6. Modulus and Assign (`%=`)

## Rule

Stores the remainder after division.

Equivalent to

```java
a = a % b;
```

### Example

```java
int number = 17;

number %= 5;

System.out.println(number);
```

**Output**

```text
2
```

---

### Example

```java
int x = 20;

x %= 6;

System.out.println(x);
```

**Output**

```text
2
```

---

# Compound Assignment

Instead of writing

```java
int score = 50;

score = score + 10;
```

You can write

```java
int score = 50;

score += 10;
```

Both produce

```text
60
```

---

# Type Casting Rule (Important)

## Works

```java
int a = 10;

a += 5.5;

System.out.println(a);
```

**Output**

```text
15
```

Reason:

Java internally performs

```java
a = (int)(a + 5.5);
```

---

## Does NOT Work

```java
int a = 10;

a = a + 5.5;
```

**Compilation Error**

```text
possible lossy conversion from double to int
```

---

## Correct Way

```java
int a = 10;

a = (int)(a + 5.5);

System.out.println(a);
```

**Output**

```text
15
```

---

# Interview Questions

## Q1

Output?

```java
int a = 10;

a += 5;

System.out.println(a);
```

**Answer**

```text
15
```

---

## Q2

Output?

```java
int a = 20;

a -= 8;

System.out.println(a);
```

**Answer**

```text
12
```

---

## Q3

Output?

```java
int a = 6;

a *= 4;

System.out.println(a);
```

**Answer**

```text
24
```

---

## Q4

Output?

```java
int a = 10;

a /= 4;

System.out.println(a);
```

**Answer**

```text
2
```

---

## Q5

Output?

```java
int a = 19;

a %= 4;

System.out.println(a);
```

**Answer**

```text
3
```

---

## Q6

Will this compile?

```java
int a = 10;

a += 2.5;
```

**Answer**

✅ Yes

---

## Q7

Will this compile?

```java
int a = 10;

a = a + 2.5;
```

**Answer**

❌ No

---

# Rules to Remember

- `=` assigns a value.
- `+=` adds and assigns.
- `-=` subtracts and assigns.
- `*=` multiplies and assigns.
- `/=` divides and assigns.
- `%=` stores the remainder.
- Compound assignment updates the same variable.
- `+=` performs implicit casting when needed.
- Normal assignment (`=`) requires explicit casting for narrowing conversions.

---

# Summary

| Operator | Meaning | Example | Equivalent |
|----------|---------|---------|------------|
| `=` | Assign | `a = 10` | Assign value |
| `+=` | Add & Assign | `a += 5` | `a = a + 5` |
| `-=` | Subtract & Assign | `a -= 5` | `a = a - 5` |
| `*=` | Multiply & Assign | `a *= 5` | `a = a * 5` |
| `/=` | Divide & Assign | `a /= 5` | `a = a / 5` |
| `%=` | Modulus & Assign | `a %= 5` | `a = a % 5` |
