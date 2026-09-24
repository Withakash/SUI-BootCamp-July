# Lec 9-10: Strings, StringBuilder & Basic Object Building

> **Goal:** Learn how to work with Strings, solve basic String problems, understand `StringBuilder`, and build your first Java classes and objects.

---

# Part 1 — Strings

## 1. What is a String?

A `String` is a sequence of characters.

```java
String name = "Akash";
```

Here:

```text
A k a s h
0 1 2 3 4
```

Each character has an index starting from `0`.

```java
System.out.println(name.charAt(0));
```

Output:

```text
A
```

---

# 2. Creating Strings

There are two common ways.

## Method 1 — String Literal

```java
String s1 = "Java";
```

## Method 2 — Using `new`

```java
String s2 = new String("Java");
```

For normal Java programming, you will mostly use:

```java
String s = "Java";
```

---

# 3. String Immutability

One of the most important concepts about Java Strings is:

> **String is immutable.**

Immutable means:

> Once a String object is created, its content cannot be changed.

Example:

```java
String s = "Java";

s.concat(" Programming");

System.out.println(s);
```

Output:

```text
Java
```

Why?

Because:

```java
s.concat(" Programming");
```

creates a new String, but we did not store that new String.

Correct:

```java
String s = "Java";

s = s.concat(" Programming");

System.out.println(s);
```

Output:

```text
Java Programming
```

Think of it like:

```text
"Java"
   ↓
concat()
   ↓
"Java Programming"

Original "Java" is not modified.
```

---

# 4. String Concatenation

We can combine Strings using `+`.

```java
String firstName = "Akash";
String lastName = "Yadav";

String fullName = firstName + " " + lastName;

System.out.println(fullName);
```

Output:

```text
Akash Yadav
```

We can also concatenate numbers.

```java
int age = 22;

System.out.println("Age = " + age);
```

Output:

```text
Age = 22
```

---

# 5. String Pool

Java maintains a special area called the **String Pool** for String literals.

Example:

```java
String s1 = "Java";
String s2 = "Java";
```

Both can refer to the same String object in the String Pool.

This is why:

```java
System.out.println(s1 == s2);
```

may give:

```text
true
```

But don't use `==` when you want to compare String content.

Use:

```java
s1.equals(s2)
```

---

# 6. `==` vs `equals()`

This is very important.

## `==`

Checks whether two references point to the same object.

## `.equals()`

Checks whether two Strings have the same content.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

Output:

```text
false
true
```

Remember:

```text
==          → reference comparison

.equals()   → content comparison
```

### Rule

When comparing Strings:

```java
if (name.equals("Akash")) {
    System.out.println("Correct");
}
```

Prefer `.equals()`.

---

# 7. Important String Methods

Let's learn the most useful methods.

---

## `length()`

Returns the number of characters.

```java
String s = "Java";

System.out.println(s.length());
```

Output:

```text
4
```

Remember:

```text
String index starts from 0
String length starts counting from 1
```

For:

```text
Java
```

Indexes:

```text
J   a   v   a
0   1   2   3
```

Length:

```text
4
```

---

# 8. `charAt()`

Returns the character at a particular index.

```java
String s = "Java";

System.out.println(s.charAt(0));
System.out.println(s.charAt(2));
```

Output:

```text
J
v
```

### Important

This returns a `char`, not a String.

```java
char ch = s.charAt(0);
```

---

# 9. Traversing a String

We can visit every character using a loop.

```java
String s = "Java";

for (int i = 0; i < s.length(); i++) {
    System.out.println(s.charAt(i));
}
```

Output:

```text
J
a
v
a
```

This pattern is extremely important for DSA.

```java
for (int i = 0; i < s.length(); i++) {

    char ch = s.charAt(i);

    // process ch
}
```

---

# 10. `toUpperCase()`

Converts the String to uppercase.

```java
String s = "java";

System.out.println(s.toUpperCase());
```

Output:

```text
JAVA
```

---

# 11. `toLowerCase()`

```java
String s = "JAVA";

System.out.println(s.toLowerCase());
```

Output:

```text
java
```

---

# 12. `contains()`

Checks whether a String contains another String.

```java
String s = "I love Java";

System.out.println(s.contains("Java"));
```

Output:

```text
true
```

Example:

```java
if (s.contains("Java")) {
    System.out.println("Java found");
}
```

---

# 13. `indexOf()`

Returns the position of a character or String.

```java
String s = "Hello Java";

System.out.println(s.indexOf('J'));
```

Output:

```text
6
```

Example:

```java
System.out.println(s.indexOf("Java"));
```

Output:

```text
6
```

If the value is not found:

```java
System.out.println(s.indexOf("Python"));
```

Output:

```text
-1
```

So:

```text
found       → index
not found   → -1
```

---

# 14. `startsWith()`

```java
String s = "Hello Java";

System.out.println(s.startsWith("Hello"));
```

Output:

```text
true
```

---

# 15. `endsWith()`

```java
String s = "Hello Java";

System.out.println(s.endsWith("Java"));
```

Output:

```text
true
```

---

# 16. `replace()`

Replace one character/String with another.

```java
String s = "I like Java";

String result = s.replace("Java", "Python");

System.out.println(result);
```

Output:

```text
I like Python
```

Remember:

String is immutable, so:

```java
s.replace("Java", "Python");
```

doesn't change `s`.

Use:

```java
s = s.replace("Java", "Python");
```

if you want to store the result.

---

# 17. `trim()`

Removes spaces from the beginning and end.

```java
String s = "   Java   ";

System.out.println(s.trim());
```

Output:

```text
Java
```

It does not remove spaces between words.

---

# 18. `substring()`

Used to extract part of a String.

Syntax:

```java
substring(start, end)
```

Important:

> `start` is included, `end` is excluded.

Example:

```java
String s = "Programming";

System.out.println(s.substring(0, 4));
```

Output:

```text
Prog
```

Indexes:

```text
P r o g r a m m i n g
0 1 2 3 4 5 6 7 8 9 10
```

```java
s.substring(0, 4)
```

takes:

```text
0 1 2 3
```

---

## Another form

```java
String s = "Programming";

System.out.println(s.substring(4));
```

Output:

```text
ramming
```

It takes everything from index `4` to the end.

---

# 19. Reverse a String

### Problem

Input:

```text
hello
```

Output:

```text
olleh
```

### Basic approach

```java
String s = "hello";

String reverse = "";

for (int i = s.length() - 1; i >= 0; i--) {
    reverse += s.charAt(i);
}

System.out.println(reverse);
```

Output:

```text
olleh
```

### Pattern

```text
Start from last character
        ↓
Move towards first character
        ↓
Add every character
```

---

# 20. Check Palindrome

A palindrome reads the same from both directions.

Examples:

```text
madam
level
racecar
121
```

Non-examples:

```text
hello
java
akash
```

---

## Approach 1 — Reverse and Compare

```java
String s = "madam";

String reverse = "";

for (int i = s.length() - 1; i >= 0; i--) {
    reverse += s.charAt(i);
}

if (s.equals(reverse)) {
    System.out.println("Palindrome");
} else {
    System.out.println("Not Palindrome");
}
```

---

# 21. Palindrome Using Two Pointers

We don't actually need to create another String.

```java
String s = "madam";

int left = 0;
int right = s.length() - 1;

boolean palindrome = true;

while (left < right) {

    if (s.charAt(left) != s.charAt(right)) {
        palindrome = false;
        break;
    }

    left++;
    right--;
}

System.out.println(palindrome);
```

Think:

```text
m a d a m
↑       ↑
L       R

compare

  ↑   ↑
  L   R

compare

    ↑
    L/R
```

This is the same **Two Pointer pattern** used in arrays.

---

# 22. Character Checking

Example: Count how many times `'a'` occurs.

```java
String s = "banana";

int count = 0;

for (int i = 0; i < s.length(); i++) {

    if (s.charAt(i) == 'a') {
        count++;
    }
}

System.out.println(count);
```

Output:

```text
3
```

---

# 23. Count Vowels

```java
String s = "programming";

int count = 0;

for (int i = 0; i < s.length(); i++) {

    char ch = s.charAt(i);

    if (ch == 'a' ||
        ch == 'e' ||
        ch == 'i' ||
        ch == 'o' ||
        ch == 'u') {

        count++;
    }
}

System.out.println(count);
```

---

# 24. LeetCode Practice

## LeetCode 344 — Reverse String

### Problem

Reverse the given character array.

Example:

```text
Input:
["h","e","l","l","o"]

Output:
["o","l","l","e","h"]
```

### Main Pattern

```text
Two Pointer
```

### Solution

```java
class Solution {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
```

---

# 25. LeetCode 125 — Valid Palindrome

Important concepts:

```text
String
charAt()
Character checking
Two Pointer
toLowerCase()
```

The key idea:

```text
left → beginning
right → end

Ignore characters that are not letters/numbers.

Compare both sides.
```

Try solving it yourself before looking at the solution.

---

# 26. LeetCode 709 — To Lower Case

Example:

```text
Input:
"Hello"

Output:
"hello"
```

Useful methods:

```java
toLowerCase()
```

---

# 27. LeetCode 58 — Length of Last Word

Example:

```text
Input:
"Hello World"

Output:
5
```

Useful concepts:

```text
String traversal
length()
charAt()
spaces
```

Try solving this without using `split()` first.

---

# Part 2 — StringBuilder

# 28. Why StringBuilder?

Remember:

```text
String → Immutable
```

Suppose we repeatedly modify a String:

```java
String s = "";

for (int i = 1; i <= 5; i++) {
    s += i;
}
```

This works, but repeated String modification can create many String objects.

For frequently changing text, use:

```java
StringBuilder
```

---

# 29. Creating StringBuilder

```java
StringBuilder sb = new StringBuilder();
```

We can also start with a String:

```java
StringBuilder sb = new StringBuilder("Java");
```

---

# 30. `append()`

Adds data at the end.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" Java");

System.out.println(sb);
```

Output:

```text
Hello Java
```

We can append different data types:

```java
sb.append(10);
sb.append(20.5);
sb.append(true);
```

---

# 31. `insert()`

Adds data at a particular index.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.insert(5, " Java");

System.out.println(sb);
```

Output:

```text
Hello Java
```

---

# 32. `delete()`

Deletes characters.

```java
StringBuilder sb = new StringBuilder("Hello Java");

sb.delete(5, 10);

System.out.println(sb);
```

Output:

```text
Hello
```

Remember:

```text
delete(start, end)

start → included
end   → excluded
```

---

# 33. `reverse()`

```java
StringBuilder sb = new StringBuilder("Java");

sb.reverse();

System.out.println(sb);
```

Output:

```text
avaJ
```

---

# 34. `toString()`

Convert `StringBuilder` back to String.

```java
StringBuilder sb = new StringBuilder("Java");

String s = sb.toString();

System.out.println(s);
```

---

# 35. Reverse String Using StringBuilder

```java
String s = "hello";

StringBuilder sb = new StringBuilder(s);

sb.reverse();

System.out.println(sb);
```

Output:

```text
olleh
```

We can also write:

```java
String result = sb.toString();
```

---

# 36. String vs StringBuilder

| String                             | StringBuilder                        |
| ---------------------------------- | ------------------------------------ |
| Immutable                          | Mutable                              |
| Cannot directly modify             | Can modify                           |
| Good for normal text               | Good for repeated modifications      |
| `concat()` creates new String      | `append()` modifies existing builder |
| Thread-safe characteristics differ | Not synchronized                     |

For beginner DSA problems, remember mainly:

```text
String
→ immutable

StringBuilder
→ mutable
```

---

# 37. Reverse Words

Example:

```text
Input:
"hello world"

Output:
"world hello"
```

First understand:

```java
String s = "hello world";

String[] words = s.split(" ");

for (String word : words) {
    System.out.println(word);
}
```

Output:

```text
hello
world
```

We can use `StringBuilder` to construct our answer.

```java
StringBuilder result = new StringBuilder();

result.append("world");
result.append(" ");
result.append("hello");

System.out.println(result);
```

---

# 38. LeetCode 151 — Reverse Words in a String

Example:

```text
Input:
"the sky is blue"

Output:
"blue is sky the"
```

Important concepts:

```text
split()
StringBuilder
String traversal
```

Try solving this after learning `StringBuilder`.

---

# Part 3 — Basic Object Building

# 39. What is a Class?

A class is a **blueprint/template** for creating objects.

Example:

```text
Student
   ↓
Blueprint
```

It can define:

```text
name
rollNo
marks
display()
```

---

# 40. Creating a Class

```java
class Student {

    String name;
    int rollNo;
    double marks;
}
```

Here:

```text
name
rollNo
marks
```

are called **fields**.

---

# 41. What is an Object?

An object is an actual instance of a class.

```java
Student s1 = new Student();
```

Here:

```text
Student
   ↓
class/type

s1
   ↓
reference

new Student()
   ↓
object
```

---

# 42. Assigning Values

```java
Student s1 = new Student();

s1.name = "Akash";
s1.rollNo = 101;
s1.marks = 85.5;
```

Print:

```java
System.out.println(s1.name);
System.out.println(s1.rollNo);
System.out.println(s1.marks);
```

---

# 43. Creating Multiple Objects

```java
Student s1 = new Student();
Student s2 = new Student();

s1.name = "Akash";
s1.rollNo = 101;
s1.marks = 85.5;

s2.name = "Rahul";
s2.rollNo = 102;
s2.marks = 91.0;
```

Each object has its own data.

```text
Student class
      |
      |------ s1
      |       name = Akash
      |       rollNo = 101
      |
      |------ s2
              name = Rahul
              rollNo = 102
```

---

# 44. Methods in a Class

A method represents some behavior/action.

```java
class Student {

    String name;
    int rollNo;
    double marks;

    void display() {

        System.out.println(name);
        System.out.println(rollNo);
        System.out.println(marks);
    }
}
```

Call the method:

```java
Student s1 = new Student();

s1.name = "Akash";
s1.rollNo = 101;
s1.marks = 85.5;

s1.display();
```

---

# 45. Constructor

A constructor is used when an object is created.

Example:

```java
class Student {

    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {

        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}
```

Now:

```java
Student s1 = new Student("Akash", 101, 85.5);
```

The constructor automatically runs during object creation.

---

# 46. Understanding `this`

Consider:

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}
```

There are two `name`s:

```text
this.name
   ↓
object's field

name
   ↓
constructor parameter
```

So:

```java
this.name = name;
```

means:

```text
object.name = parameter name
```

---

# 47. Complete Student Example

```java
class Student {

    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {

        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void display() {

        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }

    boolean isPassed() {

        return marks >= 40;
    }
}
```

Main program:

```java
public class Main {

    public static void main(String[] args) {

        Student s1 =
            new Student("Akash", 101, 85.5);

        Student s2 =
            new Student("Rahul", 102, 35.0);

        s1.display();
        System.out.println("Passed: " + s1.isPassed());

        System.out.println();

        s2.display();
        System.out.println("Passed: " + s2.isPassed());
    }
}
```

---

# 48. Other Examples of Classes

The same idea can be used for many real-world objects.

## Book

```java
class Book {

    String title;
    String author;
    double price;

    Book(String title, String author, double price) {

        this.title = title;
        this.author = author;
        this.price = price;
    }
}
```

---

## Car

```java
class Car {

    String brand;
    String model;
    int price;

    Car(String brand, String model, int price) {

        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
```

---

## Employee

```java
class Employee {

    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {

        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}
```

---

## BankAccount

```java
class BankAccount {

    String holderName;
    int accountNumber;
    double balance;

    BankAccount(
        String holderName,
        int accountNumber,
        double balance
    ) {

        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {

        balance += amount;
    }
}
```

---

# 49. Hands-on Practice

## Problem 1 — Student

Create a `Student` class with:

```text
name
rollNo
marks
```

Requirements:

* Parameterized constructor
* `display()` method
* Create 3 objects
* Display all students
* Create `isPassed()` method
* Student passes if marks >= 40

---

## Problem 2 — Book

Create a `Book` class:

```text
title
author
price
```

Create 3 book objects and display their information.

Add:

```java
boolean isExpensive()
```

Return `true` if price > 500.

---

## Problem 3 — Employee

Create an `Employee` class:

```text
name
id
salary
```

Add:

```java
void increaseSalary(double percentage)
```

Example:

```text
Salary = 50000
Increase = 10%

New Salary = 55000
```

---

## Problem 4 — BankAccount

Create:

```text
BankAccount
```

Fields:

```text
accountHolder
accountNumber
balance
```

Methods:

```java
deposit()
withdraw()
displayBalance()
```

Rules:

```text
Deposit → increase balance

Withdraw → decrease balance

Withdraw should not be allowed if
amount > balance
```

---

# 50. String Practice Questions

Try these without looking at the solution.

### Q1. Count Characters

Input:

```text
"programming"
```

Find the length without directly printing `length()`.

---

### Q2. Count `a`

Input:

```text
"banana"
```

Output:

```text
3
```

---

### Q3. Count Vowels

Input:

```text
"education"
```

Output:

```text
5
```

---

### Q4. Reverse String

Input:

```text
"hello"
```

Output:

```text
"olleh"
```

---

### Q5. Palindrome

Input:

```text
"madam"
```

Output:

```text
true
```

---

### Q6. Find Character

Input:

```text
"programming"
```

Find the first occurrence of:

```text
'g'
```

---

### Q7. Count a Particular Character

Input:

```text
"mississippi"
```

Find the number of:

```text
'i'
```

---

### Q8. Remove Spaces

Input:

```text
"I love Java"
```

Output:

```text
"IloveJava"
```

---

### Q9. Reverse Using StringBuilder

Input:

```text
"Java"
```

Output:

```text
"avaJ"
```

---

### Q10. First Character Repeated

Input:

```text
"programming"
```

Find the first character that appears more than once.

---

# 51. Important String Patterns for DSA

When you see a String problem, ask:

### Pattern 1 — Need every character?

Use:

```java
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
}
```

---

### Pattern 2 — Need reverse?

Think:

```text
Start from n-1
```

or:

```text
Two Pointer
```

---

### Pattern 3 — Need palindrome?

Think:

```text
Left ↔ Right
```

---

### Pattern 4 — Need to build a new String repeatedly?

Think:

```java
StringBuilder
```

---

### Pattern 5 — Need to compare Strings?

Think:

```java
.equals()
```

not:

```java
==
```

---

### Pattern 6 — Need part of a String?

Think:

```java
substring()
```

---

# 52. Common Mistakes

## Mistake 1

```java
if (s1 == s2)
```

for content comparison.

Use:

```java
if (s1.equals(s2))
```

---

## Mistake 2

Forgetting that indexes start at `0`.

```java
String s = "Java";

s.charAt(4); // ERROR
```

Valid indexes:

```text
0 1 2 3
```

---

## Mistake 3

Wrong substring assumption.

```java
s.substring(1, 4)
```

does **not** include index `4`.

It includes:

```text
1, 2, 3
```

---

## Mistake 4

Forgetting String immutability.

```java
s.toUpperCase();
```

does not permanently modify `s`.

Use:

```java
s = s.toUpperCase();
```

---

## Mistake 5

Confusing `String` and `char`.

```java
char ch = 'A';
String s = "A";
```

Notice:

```text
char    → 'A'
String  → "A"
```

---

# 53. Quick Revision

## String

```java
String s = "Java";
```

Important methods:

```java
s.length()
s.charAt(index)
s.equals(other)
s.contains(value)
s.indexOf(value)
s.substring(start, end)
s.toUpperCase()
s.toLowerCase()
s.replace(old, new)
s.trim()
```

---

## StringBuilder

```java
StringBuilder sb = new StringBuilder();
```

Important methods:

```java
sb.append()
sb.insert()
sb.delete()
sb.reverse()
sb.toString()
```

---

## OOP Basics

```text
Class
 ↓
Blueprint

Object
 ↓
Actual instance

Field
 ↓
Data

Method
 ↓
Behavior

Constructor
 ↓
Initializes object
```

Example:

```java
Student s1 = new Student("Akash", 101, 85);
```

---

# 54. LeetCode Roadmap

Solve these in order:

```text
1. 709 — To Lower Case
        ↓
2. 344 — Reverse String
        ↓
3. 125 — Valid Palindrome
        ↓
4. 58 — Length of Last Word
        ↓
5. 28 — Find the Index of the First Occurrence
        ↓
6. 151 — Reverse Words in a String
        ↓
7. 415 — Add Strings
```

For every problem follow:

```text
Understand
    ↓
Example
    ↓
Brute Force
    ↓
Pattern
    ↓
Time Complexity
    ↓
Code
    ↓
Test
    ↓
Optimize
```

---

# Key Takeaways

Before moving forward, you should be able to explain:

* What is a String?
* Why is String immutable?
* Difference between `==` and `.equals()`
* How `charAt()` works
* How to traverse a String
* How to reverse a String
* How to check a palindrome
* How `substring()` works
* Why StringBuilder is used
* Difference between String and StringBuilder
* How `append()`, `insert()`, `delete()` and `reverse()` work
* What is a class?
* What is an object?
* What are fields and methods?
* What is a constructor?
* Why do we use `this`?
* How to create multiple objects

> **Most important DSA connection:**
>
> ```text
> String
>   ↓
> charAt()
>   ↓
> Traversal
>   ↓
> Two Pointer / Counting / Searching
>   ↓
> LeetCode
> ```
>
> And:
>
> ```text
> String is immutable
>        ↓
> Repeated modification
>        ↓
> StringBuilder
>        ↓
> Efficient String construction
> ```
