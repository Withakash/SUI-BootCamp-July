# Custom Dynamic Array in Java (`MyArray`) -- Complete Student Notes

## 1. Introduction

In Java, arrays have a fixed size.

``` java
int[] arr = new int[5];
```

This array can store only **5 elements**. Once it is full, we cannot
directly add more elements.

Java provides `ArrayList`, which automatically grows when required:

``` java
ArrayList<Integer> list = new ArrayList<>();
```

But before using `ArrayList`, it is important to understand:

> **How can we build our own dynamic array from scratch?**

In this project, we create a custom class called:

``` java
MyArray
```

and gradually add operations such as:

-   Insert
-   Insert at first
-   Insert at last
-   Insert at a given index
-   Delete
-   Delete from first
-   Delete from last
-   Delete from a given index
-   Search
-   Update
-   Dynamic expansion
-   Dynamic shrinking
-   Size and capacity
-   Generics

------------------------------------------------------------------------

# 2. Step 1 -- Understanding a Normal Array

A normal Java array has two important properties:

``` java
int[] arr = new int[10];
```

### Capacity

The total number of positions available.

``` text
Capacity = 10
```

### Size

The number of elements currently stored.

Example:

``` text
Array Capacity = 10

[10, 20, 30, _, _, _, _, _, _, _]

Size = 3
```

We need a variable to track the current number of elements.

------------------------------------------------------------------------

# 3. Step 2 -- Creating the `MyArray` Class

``` java
class MyArray {

    private int ptr;
    private int[] arr;

    MyArray() {
        ptr = 0;
        arr = new int[10];
    }
}
```

## Explanation

### `arr`

``` java
private int[] arr;
```

This is the actual array where elements are stored.

### `ptr`

``` java
private int ptr;
```

`ptr` tells us:

> Where the next element should be inserted.

Initially:

``` text
ptr = 0

[ _, _, _, _, _, _, _, _, _, _ ]
  ↑
Next insertion
```

After inserting three elements:

``` text
[ 10, 20, 30, _, _, _, _, _, _, _ ]
              ↑
            ptr = 3
```

So `ptr` is also equal to the current **size**.

------------------------------------------------------------------------

# 4. Step 3 -- Checking if the Array is Empty

``` java
boolean isEmpty() {
    return ptr == 0;
}
```

If:

``` text
ptr = 0
```

there are no elements.

Therefore:

``` text
Array is Empty
```

------------------------------------------------------------------------

# 5. Step 4 -- Checking if the Array is Full

``` java
boolean isFull() {
    return ptr == arr.length;
}
```

Example:

``` text
arr.length = 10
ptr = 10
```

Therefore:

``` text
Array is Full
```

------------------------------------------------------------------------

# 6. Step 5 -- Basic Insert Operation

Initially, we can write:

``` java
void insert(int val) {

    if (isFull()) {
        return;
    }

    arr[ptr] = val;
    ptr++;
}
```

Or the shorter version:

``` java
void insert(int val) {

    if (isFull()) {
        return;
    }

    arr[ptr++] = val;
}
```

## Example

``` java
insert(10);
insert(20);
insert(30);
```

Flow:

``` text
insert(10)

[10, _, _, _, _, _, _, _, _, _]
 ptr = 1


insert(20)

[10, 20, _, _, _, _, _, _, _, _]
 ptr = 2
```

### Time Complexity

``` text
O(1)
```

because we directly insert at the end.

------------------------------------------------------------------------

# 7. Problem with Fixed Arrays

Suppose our array has capacity 10:

``` text
[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

Capacity = 10
Size = 10
```

Now:

``` java
insert(101);
```

There is no space.

A fixed array cannot automatically grow.

So we introduce:

# Dynamic Expansion

------------------------------------------------------------------------

# 8. Step 6 -- Creating the `upgrade()` Method

Our growth strategy is:

``` text
New Size = Old Size + Old Size / 2
```

This means the array grows by approximately **50%**.

``` java
void upgrade() {

    int newSize = arr.length + (arr.length / 2);

    int[] newArr = new int[newSize];

    for (int i = 0; i < arr.length; i++) {
        newArr[i] = arr[i];
    }

    arr = newArr;

    System.out.println("Hamne Naya Array Banaya");
}
```

------------------------------------------------------------------------

## How `upgrade()` Works

Suppose:

``` text
Old Capacity = 10
```

Calculate:

``` text
newSize = 10 + 10 / 2
        = 10 + 5
        = 15
```

Create:

``` text
Old Array

[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]


New Array

[10, 20, 30, 40, 50, 60, 70, 80, 90, 100, _, _, _, _, _]
```

Then:

``` java
arr = newArr;
```

Now our class uses the new array.

> The old array will eventually become eligible for Garbage Collection
> because no reference points to it.

------------------------------------------------------------------------

# 9. Step 7 -- Dynamic Insert

Now modify the insert method:

``` java
void insert(int val) {

    if (isFull()) {
        upgrade();
    }

    arr[ptr] = val;
    ptr++;
}
```

Or:

``` java
void insert(int val) {

    if (isFull()) {
        upgrade();
    }

    arr[ptr++] = val;
}
```

## Flow

``` text
INSERT
   |
   v
Is Array Full?
   |
   +---- NO ----> Insert Element
   |
   |
  YES
   |
   v
Upgrade Array
   |
   v
Insert Element
```

------------------------------------------------------------------------

# 10. Step 8 -- Insert at a Given Index

Suppose:

``` text
[10, 20, 30, 40]
```

We want to insert:

``` text
99 at index 2
```

Expected result:

``` text
[10, 20, 99, 30, 40]
```

To make space, we shift elements to the right.

``` java
void insertAtGivenIndex(int idx, int val) {

    if (idx < 0 || idx > ptr) {
        System.out.println("Invalid Index");
        return;
    }

    if (isFull()) {
        upgrade();
    }

    for (int i = ptr; i > idx; i--) {
        arr[i] = arr[i - 1];
    }

    arr[idx] = val;
    ptr++;
}
```

------------------------------------------------------------------------

## Why `idx > ptr`?

For insertion:

If:

``` text
Size = 4
```

valid insertion positions are:

``` text
0  1  2  3  4
```

Index `4` is valid because we can insert at the end.

Therefore:

``` java
idx > ptr
```

is invalid.

------------------------------------------------------------------------

## Shifting Process

Before:

``` text
Index:  0   1   2   3
       [10][20][30][40]
```

Insert `99` at index `2`.

Start shifting from the end:

``` text
[10][20][30][40][_]

Move 40 → right

[10][20][30][40][40]

Move 30 → right

[10][20][30][30][40]

Insert 99

[10][20][99][30][40]
```

### Time Complexity

``` text
O(n)
```

because elements may need to shift.

------------------------------------------------------------------------

# 11. Step 9 -- Insert at First

``` java
void insertAtFirst(int val) {
    insertAtGivenIndex(0, val);
}
```

Instead of rewriting the logic, we reuse the existing method.

Example:

``` text
Before:

[20, 30, 40]

insertAtFirst(10)

After:

[10, 20, 30, 40]
```

------------------------------------------------------------------------

# 12. Step 10 -- Insert at Last

``` java
void insertAtLast(int val) {
    insertAtGivenIndex(ptr, val);
}
```

Since `ptr` represents the next available position, inserting at `ptr`
means inserting at the end.

------------------------------------------------------------------------

# 13. Step 11 -- Delete the Last Element

``` java
int delete() {

    if (isEmpty()) {
        System.out.println("Array Empty hai");
        return -1;
    }

    ptr--;

    return arr[ptr];
}
```

## Example

``` text
[10, 20, 30, 40]
                ^
              ptr = 4
```

After:

``` java
ptr--;
```

``` text
[10, 20, 30, 40]
            ^
          ptr = 3
```

The deleted element is:

``` java
arr[ptr]
```

which is `40`.

This operation behaves similarly to:

``` text
Stack POP
```

### Time Complexity

``` text
O(1)
```

------------------------------------------------------------------------

# 14. Step 12 -- Delete at a Given Index

``` java
int deleteAtGivenIndex(int idx) {

    if (isEmpty()) {
        System.out.println("Array Empty hai");
        return -1;
    }

    if (idx < 0 || idx >= ptr) {
        System.out.println("Invalid Index");
        return -1;
    }

    int backup = arr[idx];

    for (int i = idx; i < ptr - 1; i++) {
        arr[i] = arr[i + 1];
    }

    ptr--;

    return backup;
}
```

------------------------------------------------------------------------

## Important Difference: Insert vs Delete Index Validation

### For insertion

``` java
idx > ptr
```

Because insertion at `ptr` is allowed.

### For deletion

``` java
idx >= ptr
```

Because the last valid element is:

``` text
ptr - 1
```

Example:

``` text
Size = 5

Valid element indexes:

0, 1, 2, 3, 4

Index 5 is invalid
```

------------------------------------------------------------------------

# 15. Delete Shifting Process

Before:

``` text
[10, 20, 30, 40, 50]
```

Delete index `2`.

``` text
Deleted = 30
```

Shift:

``` text
40 → index 2
50 → index 3
```

Result:

``` text
[10, 20, 40, 50]
```

### Time Complexity

``` text
O(n)
```

------------------------------------------------------------------------

# 16. Step 13 -- Delete First

``` java
int deleteAtFirst() {
    return deleteAtGivenIndex(0);
}
```

We reuse the existing deletion logic.

------------------------------------------------------------------------

# 17. Step 14 -- Delete Last

``` java
int deleteAtLast() {
    return delete();
}
```

Again, reuse existing code.

------------------------------------------------------------------------

# 18. Step 15 -- Search an Element

``` java
int searchIndex(int val) {

    for (int i = 0; i < ptr; i++) {

        if (arr[i] == val) {
            return i;
        }
    }

    return -1;
}
```

Example:

``` text
[10, 20, 30, 40]
```

Search:

``` java
searchIndex(30);
```

Result:

``` text
2
```

If the element is not found:

``` text
-1
```

### Time Complexity

``` text
Best Case: O(1)
Worst Case: O(n)
```

------------------------------------------------------------------------

# 19. Step 16 -- Delete a Given Element

``` java
int deleteGivenElement(int ele) {

    int idx = searchIndex(ele);

    return deleteAtGivenIndex(idx);
}
```

Example:

``` text
[10, 20, 30, 40]

deleteGivenElement(30)
```

Flow:

``` text
Search 30
   |
   v
Index = 2
   |
   v
deleteAtGivenIndex(2)
```

A cleaner version can explicitly handle "not found":

``` java
int deleteGivenElement(int ele) {

    int idx = searchIndex(ele);

    if (idx == -1) {
        System.out.println("Element Not Found");
        return -1;
    }

    return deleteAtGivenIndex(idx);
}
```

------------------------------------------------------------------------

# 20. Step 17 -- Update by Index

``` java
void updateIndex(int index, int newVal) {

    if (index < 0 || index >= ptr) {
        System.out.println("Can't update");
        return;
    }

    arr[index] = newVal;
}
```

Example:

``` text
Before:

[10, 20, 30]

updateIndex(1, 99)

After:

[10, 99, 30]
```

------------------------------------------------------------------------

# 21. Step 18 -- Update by Value

``` java
void updateValue(int oldValue, int newValue) {

    int index = searchIndex(oldValue);

    if (index == -1) {
        System.out.println("Element Not Found");
        return;
    }

    updateIndex(index, newValue);
}
```

Example:

``` text
[10, 20, 30]

updateValue(20, 99)

[10, 99, 30]
```

------------------------------------------------------------------------

# 22. Step 19 -- Print the Array

``` java
void print() {

    for (int i = 0; i < ptr; i++) {
        System.out.print(arr[i] + " ");
    }
}
```

We use:

``` java
i < ptr
```

instead of:

``` java
i < arr.length
```

because only positions from `0` to `ptr - 1` contain actual elements.

------------------------------------------------------------------------

# 23. Step 20 -- Add `size()`

``` java
int size() {
    return ptr;
}
```

Example:

``` text
Array:

[10, 20, 30]

size() = 3
```

------------------------------------------------------------------------

# 24. Step 21 -- Add `capacity()`

``` java
int capacity() {
    return arr.length;
}
```

Example:

``` text
Size = 3
Capacity = 10
```

### Important Difference

``` text
SIZE
= Number of actual elements


CAPACITY
= Total available positions
```

------------------------------------------------------------------------

# 25. Step 22 -- Add `get()`

``` java
int get(int index) {

    if (index < 0 || index >= ptr) {
        System.out.println("Invalid Index");
        return -1;
    }

    return arr[index];
}
```

Example:

``` java
get(2);
```

returns the element at index `2`.

------------------------------------------------------------------------

# 26. Step 23 -- Add `contains()`

``` java
boolean contains(int val) {
    return searchIndex(val) != -1;
}
```

Example:

``` java
if (stud.contains(50)) {
    System.out.println("Found");
}
```

------------------------------------------------------------------------

# 27. Step 24 -- Add `clear()`

``` java
void clear() {
    ptr = 0;
}
```

This logically removes all elements.

Example:

``` text
Before:

[10, 20, 30]

After clear():

[]
```

The underlying array still exists, but `ptr = 0`.

------------------------------------------------------------------------

# 28. Step 25 -- Dynamic Shrinking

We already know how to increase capacity.

Now consider:

``` text
Capacity = 100
Size = 5
```

There is a lot of unused memory.

So we can shrink the array.

## Do NOT shrink after every deletion

Bad approach:

``` text
Delete
→ Shrink

Delete
→ Shrink

Delete
→ Shrink
```

This creates too many new arrays.

Instead, shrink only when the array becomes significantly empty.

A good learning rule is:

``` text
If Size <= Capacity / 4
→ Shrink the array
```

This helps prevent **resize thrashing**.

------------------------------------------------------------------------

# 29. Add Default Capacity

``` java
private static final int DEFAULT_CAPACITY = 10;
```

Then:

``` java
MyArray() {
    ptr = 0;
    arr = new int[DEFAULT_CAPACITY];
}
```

------------------------------------------------------------------------

# 30. `shrink()` Method

``` java
void shrink() {

    if (arr.length <= DEFAULT_CAPACITY) {
        return;
    }

    if (ptr <= arr.length / 4) {

        int newSize = Math.max(DEFAULT_CAPACITY, arr.length / 2);

        int[] newArr = new int[newSize];

        for (int i = 0; i < ptr; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;

        System.out.println("Array Shrink Hua");
    }
}
```

## Explanation

Suppose:

``` text
Capacity = 40
Size = 10
```

Since:

``` text
40 / 4 = 10
```

the shrinking condition becomes true.

New size:

``` text
40 / 2 = 20
```

So:

``` text
Old Capacity = 40
New Capacity = 20
```

------------------------------------------------------------------------

# 31. Call `shrink()` After Deletion

Update `delete()`:

``` java
int delete() {

    if (isEmpty()) {
        System.out.println("Array Empty hai");
        return -1;
    }

    ptr--;

    int deletedElement = arr[ptr];

    shrink();

    return deletedElement;
}
```

Also update:

``` java
int deleteAtGivenIndex(int idx) {

    if (isEmpty()) {
        System.out.println("Array Empty hai");
        return -1;
    }

    if (idx < 0 || idx >= ptr) {
        System.out.println("Invalid Index");
        return -1;
    }

    int backup = arr[idx];

    for (int i = idx; i < ptr - 1; i++) {
        arr[i] = arr[i + 1];
    }

    ptr--;

    shrink();

    return backup;
}
```

------------------------------------------------------------------------

# 32. Complete Version 1 -- Dynamic `int` Array

``` java
class MyArray {

    private static final int DEFAULT_CAPACITY = 10;

    private int ptr;
    private int[] arr;

    MyArray() {
        ptr = 0;
        arr = new int[DEFAULT_CAPACITY];
    }

    // Increase capacity by 50%
    void upgrade() {

        int newSize = arr.length + Math.max(1, arr.length / 2);

        int[] newArr = new int[newSize];

        for (int i = 0; i < ptr; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;

        System.out.println("New Array Created. Capacity: " + newSize);
    }

    // Shrink when utilization is 25% or less
    void shrink() {

        if (arr.length <= DEFAULT_CAPACITY) {
            return;
        }

        if (ptr <= arr.length / 4) {

            int newSize = Math.max(DEFAULT_CAPACITY, arr.length / 2);

            int[] newArr = new int[newSize];

            for (int i = 0; i < ptr; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;

            System.out.println("Array Shrunk. Capacity: " + newSize);
        }
    }

    // Insert at end
    void insert(int val) {

        if (isFull()) {
            upgrade();
        }

        arr[ptr++] = val;
    }

    // Insert at any valid index
    void insertAtGivenIndex(int idx, int val) {

        if (idx < 0 || idx > ptr) {
            System.out.println("Invalid Index");
            return;
        }

        if (isFull()) {
            upgrade();
        }

        for (int i = ptr; i > idx; i--) {
            arr[i] = arr[i - 1];
        }

        arr[idx] = val;
        ptr++;
    }

    void insertAtFirst(int val) {
        insertAtGivenIndex(0, val);
    }

    void insertAtLast(int val) {
        insert(val);
    }

    // Delete last element
    int delete() {

        if (isEmpty()) {
            System.out.println("Array Empty hai");
            return -1;
        }

        int deletedElement = arr[--ptr];

        shrink();

        return deletedElement;
    }

    // Delete from given index
    int deleteAtGivenIndex(int idx) {

        if (isEmpty()) {
            System.out.println("Array Empty hai");
            return -1;
        }

        if (idx < 0 || idx >= ptr) {
            System.out.println("Invalid Index");
            return -1;
        }

        int backup = arr[idx];

        for (int i = idx; i < ptr - 1; i++) {
            arr[i] = arr[i + 1];
        }

        ptr--;

        shrink();

        return backup;
    }

    int deleteAtFirst() {
        return deleteAtGivenIndex(0);
    }

    int deleteAtLast() {
        return delete();
    }

    int deleteGivenElement(int ele) {

        int idx = searchIndex(ele);

        if (idx == -1) {
            System.out.println("Element Not Found");
            return -1;
        }

        return deleteAtGivenIndex(idx);
    }

    // Search
    int searchIndex(int val) {

        for (int i = 0; i < ptr; i++) {
            if (arr[i] == val) {
                return i;
            }
        }

        return -1;
    }

    // Update by index
    void updateIndex(int index, int newVal) {

        if (index < 0 || index >= ptr) {
            System.out.println("Can't update");
            return;
        }

        arr[index] = newVal;
    }

    // Update by value
    void updateValue(int oldValue, int newValue) {

        int index = searchIndex(oldValue);

        if (index == -1) {
            System.out.println("Element Not Found");
            return;
        }

        updateIndex(index, newValue);
    }

    int get(int index) {

        if (index < 0 || index >= ptr) {
            System.out.println("Invalid Index");
            return -1;
        }

        return arr[index];
    }

    boolean contains(int val) {
        return searchIndex(val) != -1;
    }

    int size() {
        return ptr;
    }

    int capacity() {
        return arr.length;
    }

    void clear() {
        ptr = 0;
    }

    boolean isEmpty() {
        return ptr == 0;
    }

    boolean isFull() {
        return ptr == arr.length;
    }

    void print() {

        System.out.print("[");

        for (int i = 0; i < ptr; i++) {

            System.out.print(arr[i]);

            if (i < ptr - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
```

------------------------------------------------------------------------

# 33. Testing Our Custom Array

``` java
public class MyArrayTest {

    public static void main(String[] args) {

        MyArray arr = new MyArray();

        // Insert elements
        for (int i = 10; i <= 200; i += 10) {
            arr.insert(i);
        }

        arr.print();

        System.out.println("Size: " + arr.size());
        System.out.println("Capacity: " + arr.capacity());

        // Insert at first
        arr.insertAtFirst(999);

        // Insert at index
        arr.insertAtGivenIndex(3, 555);

        arr.print();

        // Delete
        System.out.println("Deleted: " + arr.deleteAtFirst());

        // Search
        System.out.println("Index of 50: " + arr.searchIndex(50));

        // Update
        arr.updateValue(100, 777);

        arr.print();
    }
}
```

------------------------------------------------------------------------

# 34. Step 26 -- Why Do We Need Generics?

Currently:

``` java
class MyArray
```

works only with:

``` text
int
```

We cannot directly store:

``` text
String
Student
Double
Custom Objects
```

For example:

``` java
MyArray<String> names;
```

is impossible with our current implementation.

So we use:

# Generics

------------------------------------------------------------------------

# 35. Creating a Generic Class

``` java
class MyArray<T>
```

`T` represents a type.

It can be:

``` text
Integer
String
Double
Student
Any Object Type
```

Example:

``` java
MyArray<Integer> numbers = new MyArray<>();

MyArray<String> names = new MyArray<>();
```

------------------------------------------------------------------------

# 36. Why Can't We Create `new T[10]`?

This is not allowed:

``` java
T[] arr = new T[10]; // ERROR
```

Java does not allow direct generic array creation.

Therefore, internally we use:

``` java
Object[] arr;
```

``` java
arr = new Object[10];
```

------------------------------------------------------------------------

# 37. Generic `MyArray<T>` -- Basic Structure

``` java
class MyArray<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int ptr;
    private Object[] arr;

    MyArray() {
        ptr = 0;
        arr = new Object[DEFAULT_CAPACITY];
    }
}
```

------------------------------------------------------------------------

# 38. Generic Insert

``` java
void insert(T val) {

    if (isFull()) {
        upgrade();
    }

    arr[ptr++] = val;
}
```

Now we can insert any object type.

------------------------------------------------------------------------

# 39. Generic `get()`

``` java
@SuppressWarnings("unchecked")
T get(int index) {

    if (index < 0 || index >= ptr) {
        throw new IndexOutOfBoundsException("Invalid Index");
    }

    return (T) arr[index];
}
```

The cast is required because internally the array stores `Object`.

------------------------------------------------------------------------

# 40. Generic Version -- Complete Concept

``` java
class MyArray<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int ptr;
    private Object[] arr;

    MyArray() {
        arr = new Object[DEFAULT_CAPACITY];
        ptr = 0;
    }

    private void upgrade() {

        int newSize = arr.length + Math.max(1, arr.length / 2);

        Object[] newArr = new Object[newSize];

        for (int i = 0; i < ptr; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    private void shrink() {

        if (arr.length <= DEFAULT_CAPACITY) {
            return;
        }

        if (ptr <= arr.length / 4) {

            int newSize = Math.max(DEFAULT_CAPACITY, arr.length / 2);

            Object[] newArr = new Object[newSize];

            for (int i = 0; i < ptr; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }
    }

    void insert(T val) {

        if (isFull()) {
            upgrade();
        }

        arr[ptr++] = val;
    }

    void insertAtGivenIndex(int index, T val) {

        if (index < 0 || index > ptr) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        if (isFull()) {
            upgrade();
        }

        for (int i = ptr; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = val;
        ptr++;
    }

    @SuppressWarnings("unchecked")
    T deleteAtGivenIndex(int index) {

        if (index < 0 || index >= ptr) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        T deleted = (T) arr[index];

        for (int i = index; i < ptr - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[ptr - 1] = null;
        ptr--;

        shrink();

        return deleted;
    }

    @SuppressWarnings("unchecked")
    T get(int index) {

        if (index < 0 || index >= ptr) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        return (T) arr[index];
    }

    void update(int index, T value) {

        if (index < 0 || index >= ptr) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        arr[index] = value;
    }

    int size() {
        return ptr;
    }

    int capacity() {
        return arr.length;
    }

    boolean isEmpty() {
        return ptr == 0;
    }

    boolean isFull() {
        return ptr == arr.length;
    }

    void clear() {

        for (int i = 0; i < ptr; i++) {
            arr[i] = null;
        }

        ptr = 0;
    }

    void print() {

        System.out.print("[");

        for (int i = 0; i < ptr; i++) {

            System.out.print(arr[i]);

            if (i < ptr - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
```

------------------------------------------------------------------------

# 41. Using the Generic Version

## Integer

``` java
MyArray<Integer> numbers = new MyArray<>();

numbers.insert(10);
numbers.insert(20);
numbers.insert(30);

numbers.print();
```

Output:

``` text
[10, 20, 30]
```

------------------------------------------------------------------------

## String

``` java
MyArray<String> names = new MyArray<>();

names.insert("Akash");
names.insert("Rahul");
names.insert("Aman");

names.print();
```

Output:

``` text
[Akash, Rahul, Aman]
```

------------------------------------------------------------------------

## Custom Student Object

``` java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " - " + age;
    }
}
```

Usage:

``` java
MyArray<Student> students = new MyArray<>();

students.insert(new Student("Akash", 20));
students.insert(new Student("Rahul", 21));

students.print();
```

------------------------------------------------------------------------

# 42. Important Difference: Primitive vs Generic Types

This works:

``` java
MyArray<Integer>
```

This does NOT work:

``` java
MyArray<int> // ERROR
```

Generics work with objects.

Java automatically converts:

``` text
int ↔ Integer
```

This is called:

# Autoboxing and Unboxing

Example:

``` java
MyArray<Integer> numbers = new MyArray<>();

numbers.insert(10);
```

Java automatically converts:

``` text
10 → Integer.valueOf(10)
```

------------------------------------------------------------------------

# 43. Time Complexity Summary

  Operation           Time Complexity
  ----------------- -----------------
  Insert at End          O(1) average
  Insert at First                O(n)
  Insert at Index                O(n)
  Delete Last                    O(1)
  Delete First                   O(n)
  Delete at Index                O(n)
  Search                         O(n)
  Get by Index                   O(1)
  Update by Index                O(1)
  Dynamic Resize                 O(n)

------------------------------------------------------------------------

# 44. Final Learning Journey

``` text
Normal Java Array
        |
        v
Fixed Size Problem
        |
        v
Create MyArray Class
        |
        v
Track Size Using ptr
        |
        v
Insert Operation
        |
        v
Insert at Index
        |
        v
Delete Operations
        |
        v
Search Operations
        |
        v
Update Operations
        |
        v
Dynamic Expansion
        |
        v
Dynamic Shrinking
        |
        v
Utility Methods
        |
        v
Generics
        |
        v
MyArray<T>
        |
        v
Understanding ArrayList Internals
```

------------------------------------------------------------------------

# 45. What We Have Built

Our custom implementation now demonstrates the core ideas behind a
dynamic array:

``` text
MyArray
│
├── Storage using an Array
├── Size Tracking
├── Capacity Tracking
│
├── Insertion
│   ├── Insert Last
│   ├── Insert First
│   └── Insert at Index
│
├── Deletion
│   ├── Delete Last
│   ├── Delete First
│   ├── Delete at Index
│   └── Delete by Value
│
├── Search
│
├── Update
│
├── Dynamic Expansion
│
├── Dynamic Shrinking
│
└── Generics
    └── MyArray<T>
```

------------------------------------------------------------------------

# 46. Final Takeaway

The main goal of this project is not just to create another array.

The goal is to understand:

> **How higher-level data structures are built internally.**

When we use:

``` java
ArrayList<Integer> list = new ArrayList<>();
```

we should understand concepts such as:

-   Internal arrays
-   Size vs capacity
-   Dynamic resizing
-   Element shifting
-   Searching
-   Index validation
-   Generic programming

After building `MyArray`, learning Java's `ArrayList` becomes much
easier because we already understand the fundamental idea behind a
dynamic array.

------------------------------------------------------------------------

# Practice Tasks for Students

Try implementing these methods yourself:

``` text
1. lastIndexOf(value)
2. removeAll(value)
3. reverse()
4. swap(index1, index2)
5. cloneArray()
6. toArray()
7. sort()
8. max()
9. min()
10. sum()
```

For the generic version, try:

``` text
1. indexOf(T value)
2. contains(T value)
3. remove(T value)
4. replace(T oldValue, T newValue)
```

------------------------------------------------------------------------

# Next Topic

After completing this project, the recommended next step is:

``` text
Custom Dynamic Array
        ↓
Java ArrayList
        ↓
Stack
        ↓
Queue
        ↓
Linked List
        ↓
Other Data Structures
```

**Congratulations! You have now built the foundation of a custom Dynamic
Array in Java.**
