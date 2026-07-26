# Arithmetic Operators in Java
> **Complete Beginner to Advanced Notes**  
> Theory + Live Code + Dry Run + Memory Diagram + Interview Questions + Practice Programs

---

# Table of Contents

1. Introduction
2. What are Arithmetic Operators?
3. Why do we need Arithmetic Operators?
4. Types of Arithmetic Operators
5. Addition (+)
6. Subtraction (-)
7. Multiplication (*)
8. Division (/)
9. Integer Division vs Floating Point Division
10. Data Type Promotion
11. Modulus (%)
12. Operator Precedence
13. Common Mistakes
14. Interview Questions
15. Practice Questions
16. Summary

---

# What are Arithmetic Operators?

Arithmetic operators are operators that perform **mathematical calculations**.

Just like a calculator performs:

- Addition
- Subtraction
- Multiplication
- Division

Java also performs these calculations using arithmetic operators.

Example

```java
int sum = 10 + 20;
```

Here

```
10  -> Operand

+

-> Arithmetic Operator

20 -> Operand
```

Result

```
30
```

---

# Why Do We Need Arithmetic Operators?

Almost every software application performs calculations.

Examples

- Banking Software
- ATM Machines
- Calculator Apps
- Shopping Websites
- Games
- Student Result System
- Salary Management
- Billing Software

Example

```
Salary

$5000

Bonus

$500

↓

Salary + Bonus

↓

$5500
```

Without arithmetic operators, Java cannot perform any calculations.

---

# Types of Arithmetic Operators

| Operator | Name | Example |
|----------|------|---------|
| + | Addition | 10 + 5 |
| - | Subtraction | 10 - 5 |
| * | Multiplication | 10 * 5 |
| / | Division | 10 / 5 |
| % | Modulus | 10 % 3 |

---

# 1. Addition Operator (+)

## Definition

The addition operator adds two values.

### Syntax

```java
value1 + value2
```

---

## Example 1

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int sum = a + b;

        System.out.println(sum);

    }

}
```

Output

```
30
```

---

## Dry Run

Initially

```
a = 10

b = 20
```

Operation

```
10 + 20

↓

30
```

Variable

```
sum = 30
```

Output

```
30
```

---

## Memory Diagram

```
a

↓

10

b

↓

20

↓

a+b

↓

30

↓

sum

↓

30
```

---

# Addition with Decimal Numbers

```java
System.out.println(10 + 5.5);
```

Output

```
15.5
```

Why?

Java automatically converts

```
10

↓

10.0
```

Calculation becomes

```
10.0 + 5.5

↓

15.5
```

This is called **Automatic Type Promotion**.

---

# String Concatenation using +

The `+` operator is also used with strings.

```java
System.out.println("Java" + " Programming");
```

Output

```
Java Programming
```

---

## Number + String

```java
System.out.println(10 + "20");
```

Output

```
1020
```

Why?

Java converts

```
10

↓

"10"
```

Then joins both strings.

```
"10" + "20"

↓

1020
```

---

# Example

```java
System.out.println("Age : " + 20);
```

Output

```
Age : 20
```

---

# Addition with Characters

```java
System.out.println('A' + 1);
```

Output

```
66
```

Why?

```
ASCII Value

'A'

↓

65

↓

65 + 1

↓

66
```

---

# 2. Subtraction Operator (-)

## Definition

Subtracts one value from another.

Syntax

```java
value1 - value2
```

---

## Example

```java
public class Main {

    public static void main(String[] args) {

        int a = 50;
        int b = 20;

        System.out.println(a - b);

    }

}
```

Output

```
30
```

---

## Dry Run

```
50 - 20

↓

30
```

---

## Negative Result

```java
System.out.println(20 - 50);
```

Output

```
-30
```

Java allows negative numbers.

---

## Practical Example

Bank Balance

```
Balance = $1000

Spent = $250

↓

1000 - 250

↓

750
```

---

# 3. Multiplication Operator (*)

## Definition

Used to multiply two numbers.

Syntax

```java
value1 * value2
```

---

## Example

```java
int price = 50;
int quantity = 8;

System.out.println(price * quantity);
```

Output

```
400
```

---

## Dry Run

```
50 × 8

↓

400
```

---

## Decimal Multiplication

```java
System.out.println(5 * 2.5);
```

Output

```
12.5
```

---

## Real Life Example

Suppose

```
One Pen = $15

Quantity = 8

↓

15 × 8

↓

120
```

---

# 4. Division Operator (/)

## Definition

Divides one number by another.

Syntax

```java
value1 / value2
```

---

## Example

```java
System.out.println(20 / 5);
```

Output

```
4
```

---

# Integer Division

This is one of the most confusing topics for beginners.

Whenever **both operands are integers**, Java performs **Integer Division**.

Fractional part is removed.

---

Example

```java
System.out.println(5 / 2);
```

Mathematically

```
5 / 2

↓

2.5
```

Java

```
2.5

↓

2
```

Output

```
2
```

---

Example

```java
System.out.println(10 / 4);
```

```
10 / 4

↓

2.5

↓

2
```

Output

```
2
```

---

Example

```java
System.out.println(7 / 3);
```

```
7 / 3

↓

2.333

↓

2
```

Output

```
2
```

---

# Floating Point Division

If **any one operand** is

- float
- double

Java performs decimal division.

---

Example

```java
System.out.println(5 / 2.0);
```

Output

```
2.5
```

---

Example

```java
System.out.println(5.0 / 2);
```

Output

```
2.5
```

---

Example

```java
System.out.println(3.0 / 1);
```

Output

```
3.0
```

---

Example

```java
System.out.println(5 / 2.4);
```

Output

```
2.0833333333333335
```

---

# Why?

Because Java automatically converts

```
5

↓

5.0
```

Calculation becomes

```
5.0 / 2.4

↓

2.0833333333333335
```

---

# Data Type Promotion

Whenever different data types participate in an expression,

Java converts the smaller type into the larger type.

Promotion Order

```
byte

↓

short

↓

int

↓

long

↓

float

↓

double
```

---

Example

```java
System.out.println(10 + 5.5);
```

Internally

```
10

↓

10.0

↓

10.0 + 5.5

↓

15.5
```

---

Example

```java
System.out.println(100 / 3.0);
```

Output

```
33.333333333333336
```

---

# Division by Zero

## Integer

```java
System.out.println(10 / 0);
```

Output

```
ArithmeticException

/ by zero
```

---

## Double

```java
System.out.println(10.0 / 0);
```

Output

```
Infinity
```

---

## Zero by Zero

```java
System.out.println(0.0 / 0);
```

Output

```
NaN
```

NaN means

```
Not a Number
```

---

# 5. Modulus Operator (%)

## Definition

Returns the remainder after division.

Syntax

```java
value1 % value2
```

---

## Example

```java
System.out.println(17 % 5);
```

Calculation

```
17 ÷ 5

↓

Quotient = 3

Remainder = 2
```

Output

```
2
```

---

## Example

```java
System.out.println(20 % 4);
```

Output

```
0
```

---

## Example

```java
System.out.println(19 % 2);
```

Output

```
1
```

---

# Real Life Example

Check Even or Odd

```java
int number = 10;

if(number % 2 == 0)
    System.out.println("Even");
else
    System.out.println("Odd");
```

Output

```
Even
```

---

# Operator Precedence

Suppose

```java
System.out.println(5 + 2 * 3);
```

Output

```
11
```

Why?

Because multiplication executes first.

```
2 × 3

↓

6

↓

5 + 6

↓

11
```

---

# Precedence Table

| Priority | Operators |
|-----------|-----------|
| Highest | () |
| Next | * / % |
| Lowest | + - |

---

Example

```java
System.out.println((5 + 2) * 3);
```

Output

```
21
```

Because

```
5+2

↓

7

↓

7×3

↓

21
```

---

# Common Mistakes

## Mistake 1

```java
System.out.println(5 / 2);
```

Expected

```
2.5
```

Actual

```
2
```

---

## Mistake 2

```java
System.out.println(5 / 2 * 2);
```

Output

```
4
```

Reason

```
5/2

↓

2

↓

2×2

↓

4
```

---

## Mistake 3

```java
System.out.println(10 + 20 + "30");
```

Output

```
3030
```

Explanation

```
10+20

↓

30

↓

30+"30"

↓

3030
```

---

## Mistake 4

```java
System.out.println("10" + 20 + 30);
```

Output

```
102030
```

Because once Java starts string concatenation, the remaining `+` operations concatenate as strings.

---

# Interview Questions

## Q1

Output?

```java
System.out.println(7 / 2);
```

Answer

```
3
```

---

## Q2

Output?

```java
System.out.println(7 / 2.0);
```

Answer

```
3.5
```

---

## Q3

Output?

```java
System.out.println(17 % 4);
```

Answer

```
1
```

---

## Q4

Output?

```java
System.out.println(10 + 20 * 5);
```

Answer

```
110
```

---

## Q5

Output?

```java
System.out.println((10 + 20) * 5);
```

Answer

```
150
```

---

# Practice Questions

Predict the output before running.

```java
System.out.println(50 + 25);
```

```java
System.out.println(100 - 75);
```

```java
System.out.println(15 * 8);
```

```java
System.out.println(21 / 5);
```

```java
System.out.println(21 / 5.0);
```

```java
System.out.println(29 % 4);
```

```java
System.out.println(10 + 5 * 4);
```

```java
System.out.println((10 + 5) * 4);
```

---

# Summary

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| + | Addition | 10 + 5 | 15 |
| - | Subtraction | 10 - 5 | 5 |
| * | Multiplication | 10 * 5 | 50 |
| / | Division | 10 / 2 | 5 |
| % | Modulus | 17 % 5 | 2 |

---

# Key Takeaways

- Arithmetic operators perform mathematical operations.
- Integer division removes the fractional part.
- Floating-point division keeps the decimal part.
- Java automatically promotes smaller numeric types to larger ones during mixed-type arithmetic.
- `%` returns the remainder after division.
- Operator precedence matters: `*`, `/`, and `%` are evaluated before `+` and `-`, unless parentheses change the order.
