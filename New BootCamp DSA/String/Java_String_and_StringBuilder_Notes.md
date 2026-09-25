# Java String & StringBuilder — Complete Student Notes

> **Goal:** Learn the important `String` and `StringBuilder` methods, understand when to use them, and apply them in Java/DSA problems.

---

# Part 1 — Java String

A `String` is a sequence of characters.

```java
String s = "Hello Java";
```

Indexes start from `0`.

```text
H  e  l  l  o     J  a  v  a
0  1  2  3  4  5  6  7  8  9
```

---

# 1. String Immutability

Java `String` is **immutable**.

That means once a String object is created, its content cannot be changed.

```java
String s = "Java";

s.concat(" Programming");

System.out.println(s);
```

Output:

```text
Java
```

`concat()` created a new String, but we did not store it.

Correct:

```java
s = s.concat(" Programming");

System.out.println(s);
```

Output:

```text
Java Programming
```

Remember:

```text
String
  ↓
Immutable
  ↓
Operations create a new String
```

---

# 2. String Creation

## String Literal

```java
String s1 = "Java";
```

## Using `new`

```java
String s2 = new String("Java");
```

For normal programming, you will mostly use String literals.

---

# 3. String Pool

Java maintains a special area called the **String Pool** for String literals.

```java
String s1 = "Java";
String s2 = "Java";
```

Both can refer to the same pooled String object.

Therefore:

```java
System.out.println(s1 == s2);
```

may produce:

```text
true
```

But when comparing String content, use:

```java
s1.equals(s2)
```

---

# 4. `length()`

Returns the number of characters.

```java
String s = "Java";

System.out.println(s.length());
```

Output:

```text
4
```

### Use

Use it when you need:

- Number of characters
- Loop boundary
- Last index

Example:

```java
for (int i = 0; i < s.length(); i++) {
    System.out.println(s.charAt(i));
}
```

---

# 5. `charAt(index)`

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

### Use

Very important in DSA for:

- Character traversal
- Counting characters
- Palindrome
- Searching
- Character comparison

Example:

```java
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    System.out.println(ch);
}
```

---

# 6. `equals()`

Compares String content.

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b));
```

Output:

```text
true
```

### Use

Use it when you want to know whether two Strings contain the same text.

```java
if (name.equals("Akash")) {
    System.out.println("Hello Akash");
}
```

---

# 7. `equalsIgnoreCase()`

Compares Strings while ignoring uppercase/lowercase differences.

```java
String a = "Java";
String b = "JAVA";

System.out.println(a.equalsIgnoreCase(b));
```

Output:

```text
true
```

### Use

Useful when input should be case-insensitive.

---

# 8. `==` vs `.equals()`

`==` compares references.

`.equals()` compares String content.

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
System.out.println(a.equals(b));
```

Output:

```text
false
true
```

### Remember

```text
==          → reference comparison
.equals()   → content comparison
```

For String content comparison, prefer:

```java
a.equals(b)
```

---

# 9. `contains()`

Checks whether one String contains another String.

```java
String s = "I love Java";

System.out.println(s.contains("Java"));
```

Output:

```text
true
```

If not found:

```java
System.out.println(s.contains("Python"));
```

Output:

```text
false
```

### Use

Useful for:

- Searching text
- Checking keywords
- Validation

---

# 10. `indexOf()`

Returns the first index where a character/String occurs.

```java
String s = "banana";

System.out.println(s.indexOf('a'));
```

Output:

```text
1
```

String search:

```java
System.out.println(s.indexOf("na"));
```

Output:

```text
2
```

If not found:

```java
System.out.println(s.indexOf('z'));
```

Output:

```text
-1
```

### Remember

```text
Found     → index
Not found → -1
```

---

# 11. `lastIndexOf()`

Returns the last occurrence.

```java
String s = "banana";

System.out.println(s.lastIndexOf('a'));
```

Output:

```text
5
```

### Use

Useful when you need the **last occurrence** of a character/String.

---

# 12. `startsWith()`

Checks whether the String starts with a particular value.

```java
String s = "Hello Java";

System.out.println(s.startsWith("Hello"));
```

Output:

```text
true
```

### Use

Useful for checking prefixes.

---

# 13. `endsWith()`

Checks whether the String ends with a particular value.

```java
String s = "Hello Java";

System.out.println(s.endsWith("Java"));
```

Output:

```text
true
```

### Use

Useful for:

- File extensions
- Suffix checking
- Input validation

Example:

```java
String file = "notes.txt";

if (file.endsWith(".txt")) {
    System.out.println("Text file");
}
```

---

# 14. `toUpperCase()`

Converts a String to uppercase.

```java
String s = "java";

System.out.println(s.toUpperCase());
```

Output:

```text
JAVA
```

Remember String is immutable:

```java
s.toUpperCase();
```

does not change `s`.

Use:

```java
s = s.toUpperCase();
```

if you want to store the result.

---

# 15. `toLowerCase()`

Converts a String to lowercase.

```java
String s = "JAVA";

System.out.println(s.toLowerCase());
```

Output:

```text
java
```

---

## Lowercase Without Built-in Method

```java
String s = "JaVa";

String result = "";

for (int i = 0; i < s.length(); i++) {

    char ch = s.charAt(i);

    if (ch >= 'A' && ch <= 'Z') {
        ch = (char)(ch + 32);
    }

    result += ch;
}

System.out.println(result);
```

### Why `+32`?

ASCII:

```text
'A' = 65
'a' = 97

97 - 65 = 32
```

So uppercase letters can be converted using:

```java
ch = (char)(ch + 32);
```

---

# 16. `substring(start)`

Returns the part of a String from `start` to the end.

```java
String s = "Programming";

System.out.println(s.substring(4));
```

Output:

```text
ramming
```

---

# 17. `substring(start, end)`

Extracts characters from `start` to `end - 1`.

```java
String s = "Programming";

System.out.println(s.substring(0, 4));
```

Output:

```text
Prog
```

### Important

```text
substring(start, end)

start → included
end   → excluded
```

For:

```java
s.substring(2, 5)
```

indexes `2, 3, 4` are included.

---

# 18. `concat()`

Joins two Strings.

```java
String a = "Hello";
String b = " Java";

System.out.println(a.concat(b));
```

Output:

```text
Hello Java
```

Remember:

```java
a.concat(b);
```

does not change `a`.

Use:

```java
a = a.concat(b);
```

if you want to store the result.

---

# 19. `replace()`

Replaces characters or character sequences.

```java
String s = "Java Java";

System.out.println(s.replace("Java", "Python"));
```

Output:

```text
Python Python
```

Character replacement:

```java
System.out.println(s.replace('a', 'o'));
```

### Use

Useful for simple text replacement.

---

# 20. `replaceFirst()`

Replaces the first matching occurrence.

```java
String s = "Java Java Java";

System.out.println(
    s.replaceFirst("Java", "Python")
);
```

Output:

```text
Python Java Java
```

---

# 21. `replaceAll()`

Replaces all matches using a regular expression.

Example:

```java
String s = "Java123Programming";

System.out.println(
    s.replaceAll("[0-9]", "")
);
```

Output:

```text
JavaProgramming
```

Remove extra spaces:

```java
String s = "Java   Programming";

System.out.println(
    s.replaceAll("\\s+", " ")
);
```

Output:

```text
Java Programming
```

---

# 22. `trim()`

Removes leading and trailing spaces.

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

# 23. `strip()`

Similar to `trim()`, but handles Unicode whitespace more completely.

```java
String s = "   Java   ";

System.out.println(s.strip());
```

### Use

Use when you need to remove whitespace from both ends.

---

# 24. `stripLeading()`

Removes whitespace from the beginning.

```java
String s = "   Java   ";

System.out.println(s.stripLeading());
```

Result:

```text
Java   
```

---

# 25. `stripTrailing()`

Removes whitespace from the end.

```java
String s = "   Java   ";

System.out.println(s.stripTrailing());
```

Result:

```text
   Java
```

---

# 26. `split()`

Splits a String into a String array.

```java
String s = "Java Python C++";

String[] words = s.split(" ");

for (String word : words) {
    System.out.println(word);
}
```

Output:

```text
Java
Python
C++
```

### Use

Very useful in DSA problems involving words/sentences.

Example:

```java
String s = "hello world";

String[] arr = s.split(" ");

System.out.println(arr[0]);
System.out.println(arr[1]);
```

---

# 27. `toCharArray()`

Converts a String into a character array.

```java
String s = "Java";

char[] arr = s.toCharArray();

for (char ch : arr) {
    System.out.println(ch);
}
```

### Use

Useful when individual characters need to be modified.

Example:

```java
char[] chars = "hello".toCharArray();

chars[0] = 'H';

System.out.println(chars);
```

Output:

```text
Hello
```

---

# 28. `getBytes()`

Converts a String into bytes.

```java
String s = "ABC";

byte[] arr = s.getBytes();

for (byte b : arr) {
    System.out.println(b);
}
```

Output:

```text
65
66
67
```

### Use

Useful in:

- Encoding
- File handling
- Networking

For beginner DSA, this is less important.

---

# 29. `isEmpty()`

Checks whether the String length is `0`.

```java
String s = "";

System.out.println(s.isEmpty());
```

Output:

```text
true
```

---

# 30. `isBlank()`

Checks whether the String is empty or contains only whitespace.

```java
String s = "   ";

System.out.println(s.isBlank());
```

Output:

```text
true
```

Difference:

```java
"".isEmpty();      // true
"   ".isEmpty();   // false

"".isBlank();      // true
"   ".isBlank();   // true
```

---

# 31. `compareTo()`

Compares two Strings lexicographically.

```java
String a = "apple";
String b = "banana";

System.out.println(a.compareTo(b));
```

The exact numeric value is less important than the sign:

```text
result < 0 → a comes before b
result = 0 → both are equal
result > 0 → a comes after b
```

### Use

Useful for:

- Dictionary/lexicographical order
- Sorting
- String comparison

---

# 32. `compareToIgnoreCase()`

Same concept as `compareTo()`, but ignores case.

```java
String a = "java";
String b = "JAVA";

System.out.println(a.compareToIgnoreCase(b));
```

Output:

```text
0
```

---

# 33. `String.format()`

Creates a formatted String.

```java
String name = "Akash";
int age = 22;

String result = String.format(
    "Name: %s, Age: %d",
    name,
    age
);

System.out.println(result);
```

Output:

```text
Name: Akash, Age: 22
```

Common format specifiers:

```text
%s → String
%d → integer
%f → floating point
%c → character
%b → boolean
```

---

# 34. `String.join()`

Joins multiple Strings using a delimiter.

```java
String result = String.join(
    ", ",
    "Java",
    "Python",
    "C++"
);

System.out.println(result);
```

Output:

```text
Java, Python, C++
```

---

# 35. `String.valueOf()`

Converts values into a String.

```java
int age = 22;

String s = String.valueOf(age);

System.out.println(s);
```

Can also be used with:

```java
String.valueOf(10);
String.valueOf(10.5);
String.valueOf(true);
String.valueOf('A');
```

---

# Part 2 — StringBuilder

`StringBuilder` is a mutable sequence of characters.

```java
StringBuilder sb = new StringBuilder();
```

Remember:

```text
String
→ Immutable

StringBuilder
→ Mutable
```

---

# 36. `append()`

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

Can append different types:

```java
sb.append(10);
sb.append(10.5);
sb.append(true);
sb.append('A');
```

### Use

Best-known use:

> Building a String repeatedly.

Example:

```java
StringBuilder result = new StringBuilder();

for (int i = 1; i <= 5; i++) {
    result.append(i);
}

System.out.println(result);
```

Output:

```text
12345
```

---

# 37. `insert()`

Inserts data at a specific index.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.insert(5, " Java");

System.out.println(sb);
```

Output:

```text
Hello Java
```

Another example:

```java
StringBuilder sb = new StringBuilder("Hllo");

sb.insert(1, "e");

System.out.println(sb);
```

Output:

```text
Hello
```

---

# 38. `delete()`

Deletes a range of characters.

```java
StringBuilder sb =
    new StringBuilder("Hello Java");

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

# 39. `deleteCharAt()`

Deletes one character.

```java
StringBuilder sb =
    new StringBuilder("Hello");

sb.deleteCharAt(1);

System.out.println(sb);
```

Output:

```text
Hllo
```

### Use

Remove one character at a specific index.

---

# 40. `replace()`

Replaces a range with another String.

```java
StringBuilder sb =
    new StringBuilder("Hello World");

sb.replace(6, 11, "Java");

System.out.println(sb);
```

Output:

```text
Hello Java
```

Syntax:

```java
sb.replace(start, end, replacement);
```

---

# 41. `reverse()`

Reverses the StringBuilder.

```java
StringBuilder sb =
    new StringBuilder("Java");

sb.reverse();

System.out.println(sb);
```

Output:

```text
avaJ
```

### Use

Very useful for:

- Reverse String
- Reverse number represented as text
- Building reverse output

---

# 42. `setCharAt()`

Changes a character at a particular index.

```java
StringBuilder sb =
    new StringBuilder("Java");

sb.setCharAt(0, 'K');

System.out.println(sb);
```

Output:

```text
Kava
```

This demonstrates why StringBuilder is mutable.

---

# 43. `charAt()`

Returns a character.

```java
StringBuilder sb =
    new StringBuilder("Java");

System.out.println(sb.charAt(2));
```

Output:

```text
v
```

---

# 44. `length()`

Returns the number of characters.

```java
StringBuilder sb =
    new StringBuilder("Java");

System.out.println(sb.length());
```

Output:

```text
4
```

---

# 45. `capacity()`

Returns the current capacity.

```java
StringBuilder sb =
    new StringBuilder();

System.out.println(sb.capacity());
```

The default capacity is commonly:

```text
16
```

Capacity is different from length.

```text
length   → actual characters
capacity → available internal capacity
```

---

# 46. `ensureCapacity()`

Ensures that the builder has at least the specified capacity.

```java
StringBuilder sb =
    new StringBuilder();

sb.ensureCapacity(100);
```

### Use

Useful when you know you will build a large String.

This is less important for beginner DSA.

---

# 47. `setLength()`

Changes the length of the StringBuilder.

```java
StringBuilder sb =
    new StringBuilder("Hello");

sb.setLength(3);

System.out.println(sb);
```

Output:

```text
Hel
```

### Use

Useful when you intentionally need to resize/truncate the builder.

---

# 48. `substring()`

Extracts part of the StringBuilder and returns a `String`.

```java
StringBuilder sb =
    new StringBuilder("Programming");

String result = sb.substring(0, 4);

System.out.println(result);
```

Output:

```text
Prog
```

Important:

```text
StringBuilder.substring()
→ returns String
```

---

# 49. `toString()`

Converts StringBuilder into String.

```java
StringBuilder sb =
    new StringBuilder("Java");

String result = sb.toString();

System.out.println(result);
```

### Very important for DSA

Many problems require a `String` as the final answer.

Use:

```java
return sb.toString();
```

---

# 50. `indexOf()`

Finds the first occurrence.

```java
StringBuilder sb =
    new StringBuilder("Hello Java");

System.out.println(sb.indexOf("Java"));
```

Output:

```text
6
```

---

# 51. `lastIndexOf()`

Finds the last occurrence.

```java
StringBuilder sb =
    new StringBuilder("Java Java");

System.out.println(sb.lastIndexOf("Java"));
```

Output:

```text
5
```

---

# 52. `getChars()`

Copies characters into a character array.

```java
StringBuilder sb =
    new StringBuilder("Hello");

char[] arr = new char[5];

sb.getChars(0, 5, arr, 0);

for (char ch : arr) {
    System.out.println(ch);
}
```

This is less commonly required in beginner DSA.

---

# StringBuilder Method Summary

| Method | Use |
|---|---|
| `append()` | Add at the end |
| `insert()` | Insert at an index |
| `delete()` | Delete a range |
| `deleteCharAt()` | Delete one character |
| `replace()` | Replace a range |
| `reverse()` | Reverse |
| `setCharAt()` | Modify one character |
| `charAt()` | Get a character |
| `length()` | Get length |
| `capacity()` | Get capacity |
| `ensureCapacity()` | Ensure minimum capacity |
| `setLength()` | Change length |
| `substring()` | Extract a String |
| `toString()` | Convert to String |
| `indexOf()` | Find first occurrence |
| `lastIndexOf()` | Find last occurrence |
| `getChars()` | Copy characters to array |

---

# String vs StringBuilder

| Feature | String | StringBuilder |
|---|---|---|
| Mutable? | No | Yes |
| `append()` | No | Yes |
| `insert()` | No | Yes |
| `delete()` | No | Yes |
| `reverse()` | No | Yes |
| `setCharAt()` | No | Yes |
| `charAt()` | Yes | Yes |
| `length()` | Yes | Yes |
| `substring()` | Yes | Yes |
| `toString()` | Already String | Converts to String |
| Repeated modifications | Less suitable | Suitable |

---

# DSA Patterns

## Pattern 1 — Traverse a String

```java
for (int i = 0; i < s.length(); i++) {

    char ch = s.charAt(i);

    // process ch
}
```

---

## Pattern 2 — Reverse

Using StringBuilder:

```java
StringBuilder sb = new StringBuilder(s);

sb.reverse();

String result = sb.toString();
```

---

## Pattern 3 — Palindrome

Use two pointers:

```text
left → beginning
right → end

compare
left++
right--
```

Example:

```java
int left = 0;
int right = s.length() - 1;

while (left < right) {

    if (s.charAt(left) != s.charAt(right)) {
        System.out.println("Not Palindrome");
        break;
    }

    left++;
    right--;
}
```

---

## Pattern 4 — Build an Answer

```java
StringBuilder ans = new StringBuilder();

ans.append(...);

return ans.toString();
```

---

# Common Mistakes

## Mistake 1 — Using `==` for String content

Wrong:

```java
if (s1 == s2)
```

Correct:

```java
if (s1.equals(s2))
```

---

## Mistake 2 — Invalid Index

```java
String s = "Java";

s.charAt(4); // Error
```

Valid indexes:

```text
0 1 2 3
```

---

## Mistake 3 — Forgetting `substring()` end is exclusive

```java
s.substring(1, 4);
```

includes:

```text
1, 2, 3
```

Not `4`.

---

## Mistake 4 — Forgetting String immutability

Wrong assumption:

```java
s.toUpperCase();
```

changes `s`.

Actually:

```java
s = s.toUpperCase();
```

is needed to store the returned String.

---

## Mistake 5 — Confusing `char` and `String`

```java
char ch = 'A';
String s = "A";
```

Remember:

```text
char   → 'A'
String → "A"
```

---

# Most Important Methods for DSA

You do not need to memorize every method equally.

## String

Focus first on:

```text
length()
charAt()
equals()
equalsIgnoreCase()
indexOf()
lastIndexOf()
contains()
substring()
toCharArray()
split()
replace()
toLowerCase()
toUpperCase()
trim()
isEmpty()
isBlank()
```

## StringBuilder

Focus first on:

```text
append()
insert()
delete()
deleteCharAt()
replace()
reverse()
setCharAt()
charAt()
length()
toString()
```

---

# Practice Problems

## 1. Count Characters

Input:

```text
programming
```

Find the number of characters.

---

## 2. Count `a`

Input:

```text
banana
```

Output:

```text
3
```

---

## 3. Count Vowels

Input:

```text
education
```

Output:

```text
5
```

---

## 4. Reverse String

Input:

```text
hello
```

Output:

```text
olleh
```

---

## 5. Check Palindrome

Input:

```text
madam
```

Output:

```text
true
```

---

## 6. Find First Occurrence

Input:

```text
programming
```

Find the first occurrence of:

```text
g
```

---

## 7. Find Last Occurrence

Input:

```text
programming
```

Find the last occurrence of:

```text
m
```

---

## 8. Remove Spaces

Input:

```text
I love Java
```

Output:

```text
IloveJava
```

---

## 9. Reverse Using StringBuilder

Input:

```text
Java
```

Output:

```text
avaJ
```

---

## 10. First Repeated Character

Input:

```text
programming
```

Find the first character that appears more than once.

---

# LeetCode Practice

Recommended order:

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

# Quick Revision

## String

```java
String s = "Java";
```

Important methods:

```java
s.length();
s.charAt(index);
s.equals(other);
s.equalsIgnoreCase(other);
s.contains(value);
s.indexOf(value);
s.lastIndexOf(value);
s.startsWith(value);
s.endsWith(value);
s.substring(start);
s.substring(start, end);
s.concat(other);
s.replace(old, new);
s.replaceFirst(regex, replacement);
s.replaceAll(regex, replacement);
s.trim();
s.strip();
s.stripLeading();
s.stripTrailing();
s.toUpperCase();
s.toLowerCase();
s.split(regex);
s.toCharArray();
s.isEmpty();
s.isBlank();
s.compareTo(other);
s.compareToIgnoreCase(other);
```

## StringBuilder

```java
StringBuilder sb = new StringBuilder();
```

Important methods:

```java
sb.append(value);
sb.insert(index, value);
sb.delete(start, end);
sb.deleteCharAt(index);
sb.replace(start, end, value);
sb.reverse();
sb.setCharAt(index, ch);
sb.charAt(index);
sb.length();
sb.capacity();
sb.ensureCapacity(size);
sb.setLength(size);
sb.substring(start);
sb.substring(start, end);
sb.toString();
sb.indexOf(value);
sb.lastIndexOf(value);
```

---

# Final Concept Map

```text
                    STRING
                      |
        +-------------+-------------+
        |             |             |
    Accessing      Searching     Modifying
        |             |             |
     charAt()      indexOf()      replace()
     length()      contains()     concat()
                   startsWith()   substring()
                   endsWith()
        |
        ↓
   DSA Problems
        |
   +----+----+----------+
   |         |          |
Reverse   Palindrome   Counting
   |         |          |
   +---------+----------+
             |
             ↓
       StringBuilder
             |
   +---------+---------+
   |         |         |
append()  reverse()  insert()
   |
   ↓
Build answers efficiently
   |
   ↓
toString()
   |
   ↓
Final String
```

> **Remember:**  
> `String` → immutable  
> `StringBuilder` → mutable  
> `==` → reference comparison  
> `.equals()` → content comparison  
> `substring(start, end)` → end is excluded  
> `charAt(index)` → gives one `char`  
> `toString()` → StringBuilder → String
