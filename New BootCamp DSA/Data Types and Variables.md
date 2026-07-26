# Introduction to Data Structures & Algorithms (DSA)
## Java Basics - Data Types & Variables
> 📚 Bootcamp Notes (Java)

---

# What is DSA?

**DSA** stands for **Data Structures and Algorithms**.

- **Data Structure (DS)** → A way to organize and store data efficiently.
- **Algorithm (A)** → A step-by-step procedure to solve a problem.

### Example

Suppose you have names of 10 students.

Without Data Structure:

```
Akash
Rahul
Priya
Ankit
...
```

With Array (Data Structure):

```java
String[] students = {
    "Akash",
    "Rahul",
    "Priya",
    "Ankit"
};
```

Searching becomes much easier.

---

# Why Learn DSA?

DSA helps you to:

- Write efficient code
- Reduce execution time
- Reduce memory usage
- Crack coding interviews
- Solve real-world problems
- Improve logical thinking

---

# Real Life Examples

| Problem | Data Structure |
|----------|---------------|
| Contact List | ArrayList |
| Browser Back Button | Stack |
| Music Playlist | LinkedList |
| Google Maps | Graph |
| Undo Feature | Stack |
| Queue at Ticket Counter | Queue |

---

# DSA = Data Structure + Algorithm

```
Input
   │
   ▼
Data Structure
   │
   ▼
Algorithm
   │
   ▼
Output
```

---

# Java Basics Before DSA

Before learning DSA, you should know:

- Variables
- Data Types
- Operators
- Loops
- Methods
- Arrays
- Classes & Objects

---

# Variables

## What is a Variable?

A variable is a named memory location used to store data.

Think of it as a container.

```
Memory

+-----------+
|   25      |
+-----------+
      ▲
      │
     age
```

---

## Syntax

```java
dataType variableName = value;
```

Example

```java
int age = 20;

String name = "Akash";

double salary = 55000.50;
```

---

# Variable Naming Rules

✔ Can contain letters

✔ Digits allowed (not first)

✔ Can use _ and $

✔ Case Sensitive

✔ Cannot use keywords

### Correct

```java
age

studentName

_marks

salary1

$amount
```

### Incorrect

```java
1age

class

student-name

student name
```

---

# Java Primitive Data Types

Java has **8 Primitive Data Types**.

| Data Type | Size | Range | Formula |
|-----------|------|--------|---------|
| byte | 1 byte (8 bits) | -128 to 127 | -2^7 to (2^7)-1 |
| short | 2 bytes (16 bits) | -32,768 to 32,767 | -2^15 to (2^15)-1 |
| int | 4 bytes (32 bits) | -2,147,483,648 to 2,147,483,647 | -2^31 to (2^31)-1 |
| long | 8 bytes (64 bits) | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | -2^63 to (2^63)-1 |
| float | 4 bytes | Approx ±3.4 × 10^38 | IEEE 754 (32-bit) |
| double | 8 bytes | Approx ±1.7 × 10^308 | IEEE 754 (64-bit) |
| char | 2 bytes | 0 to 65,535 | 0 to 2^16 - 1 |
| boolean | JVM dependent | true / false | Not Numeric |

---

# Memory Formula

Signed Integer Types

```
Minimum = -(2^(n-1))

Maximum = (2^(n-1)) - 1
```

Where,

```
n = Number of bits
```

Example

### byte

```
n = 8

Minimum

= -(2^(8-1))

= -(2^7)

= -128

Maximum

= (2^7)-1

=127
```

---

### short

```
16 bits

Minimum

= -(2^15)

= -32768

Maximum

= (2^15)-1

=32767
```

---

### int

```
32 bits

Minimum

= -(2^31)

Maximum

=(2^31)-1
```

---

### long

```
64 bits

Minimum

= -(2^63)

Maximum

=(2^63)-1
```

---

# Integer Data Types Example

```java
public class IntegerTypes {

    public static void main(String[] args) {

        byte b = 100;

        short s = 25000;

        int i = 1000000;

        long l = 9876543210L;

        System.out.println(b);

        System.out.println(s);

        System.out.println(i);

        System.out.println(l);

    }

}
```

---

# Floating Point Data Types

## float

```java
float price = 199.99f;
```

Suffix **f** is mandatory.

---

## double

```java
double pi = 3.141592653589793;
```

Double is the default decimal type.

---

# Floating Point Example

```java
public class DecimalDemo {

    public static void main(String[] args) {

        float temperature = 37.5f;

        double salary = 55000.756789;

        System.out.println(temperature);

        System.out.println(salary);

    }

}
```

---

# Character Data Type

Stores a **single Unicode character**.

```java
char grade = 'A';

char symbol = '#';

char number = '7';
```

---

Example

```java
public class CharacterDemo {

    public static void main(String[] args) {

        char ch = 'J';

        System.out.println(ch);

    }

}
```

---

# Boolean Data Type

Stores only:

```
true

false
```

Example

```java
boolean isJavaEasy = true;

boolean isLoggedIn = false;
```

---

Program

```java
public class BooleanDemo {

    public static void main(String[] args) {

        boolean passed = true;

        System.out.println(passed);

    }

}
```

---

# Primitive vs Non-Primitive

## Primitive

- int
- byte
- short
- long
- float
- double
- char
- boolean

Stored directly.

Fast.

Fixed size.

---

## Non-Primitive

- String
- Array
- Class
- Interface
- Object

Store references to objects.

Can grow dynamically.

---

# Default Values (Instance Variables)

| Type | Default Value |
|------|---------------|
| byte | 0 |
| short | 0 |
| int | 0 |
| long | 0L |
| float | 0.0f |
| double | 0.0 |
| char | '\u0000' |
| boolean | false |
| Object | null |

> **Note:** Local variables do **not** get default values. They must be initialized before use.

---

# Quick Revision

## Variable

```
A named memory location.
```

## Data Type

```
Defines what kind of value can be stored.
```

## Formula

```
Signed Integer

Minimum = -(2^(n-1))

Maximum = (2^(n-1))-1
```

## Primitive Types

```
byte
short
int
long
float
double
char
boolean
```

---

# Interview Questions

### Q1. Why is `long` written with `L`?

```java
long population = 9000000000L;
```

Because integer literals are `int` by default. `L` tells Java the literal is a `long`.

---

### Q2. Why is `float` written with `f`?

```java
float price = 99.5f;
```

Because decimal literals are `double` by default. `f` tells Java the literal is a `float`.

---

### Q3. Difference between `char` and `String`?

| char | String |
|------|--------|
| Single character | Multiple characters |
| Primitive | Non-Primitive |
| Uses single quotes | Uses double quotes |

```java
char c = 'A';

String s = "A";
```

---

# Summary

- DSA = Data Structures + Algorithms
- Variables are named memory locations.
- Java has **8 primitive data types**.
- Signed integer ranges use the formula:
  - **Minimum = -(2^(n-1))**
  - **Maximum = (2^(n-1)) - 1**
- `float` requires **f**, and `long` requires **L** for larger literals.
- Primitive types store values directly, while non-primitive types store references.

---
**Next Topic:** Input/Output in Java (`Scanner`), Operators, Arrays, and Time & Space Complexity (Big-O) before starting Arrays in DSA.
