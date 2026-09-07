# ⭐ PATTERN PROGRAMMING (MASTER)

---

# 🧠 CORE IDEA (MOST IMPORTANT)

👉 Every pattern = **Nested Loops**

* Outer loop → rows
* Inner loop → columns

```java
for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= cols; j++){
        System.out.print("*");
    }
    System.out.println();
}
```

👉 Always ask:

* How many rows?
* What changes in each row?
* What prints in each column?

---

# 🔢 TYPE 1 — CONSTANT PATTERN

### ⭐ Pattern

```
***
***
***
```

### Code

```java
for(int i=1;i<=3;i++){
    for(int j=1;j<=3;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

👉 Logic: rows fixed, columns fixed

---

# 🔺 TYPE 2 — INCREASING STAR PATTERN

### Pattern

```
*
**
***
```

### Code

```java
for(int i=1;i<=3;i++){
    for(int j=1;j<=i;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

👉 Logic: columns depend on row (j <= i)

---

# 🔻 TYPE 3 — DECREASING STAR PATTERN

### Pattern

```
***
**
*
```

### Code

```java
for(int i=3;i>=1;i--){
    for(int j=1;j<=i;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

👉 Logic: reverse loop

---

# 🔢 TYPE 4 — NUMBER INCREASING

### Pattern

```
1
12
123
```

### Code

```java
for(int i=1;i<=3;i++){
    for(int j=1;j<=i;j++){
        System.out.print(j);
    }
    System.out.println();
}
```

👉 Logic: print column number

---

# 🔢 TYPE 5 — SAME NUMBER ROW

### Pattern

```
1
22
333
```

### Code

```java
for(int i=1;i<=3;i++){
    for(int j=1;j<=i;j++){
        System.out.print(i);
    }
    System.out.println();
}
```

👉 Logic: print row number

---

# 🔁 TYPE 6 — REVERSE NUMBER PATTERN

### Pattern

```
321
21
1
```

### Code

```java
for(int i=3;i>=1;i--){
    for(int j=i;j>=1;j--){
        System.out.print(j);
    }
    System.out.println();
}
```

---

# 🧱 TYPE 7 — RIGHT ANGLE TRIANGLE (SPACES)

### Pattern

```
  *
 **
***
```

### Code

```java
int n = 3;
for(int i=1;i<=n;i++){
    for(int s=1;s<=n-i;s++){
        System.out.print(" ");
    }
    for(int j=1;j<=i;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

👉 Logic: spaces + stars

---

# 🔺 TYPE 8 — PYRAMID

### Pattern

```
  *
 ***
*****
```

### Code

```java
int n = 3;
for(int i=1;i<=n;i++){
    for(int s=1;s<=n-i;s++){
        System.out.print(" ");
    }
    for(int j=1;j<=2*i-1;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

👉 Logic: stars = 2*i-1

---

# 🔻 TYPE 9 — INVERTED PYRAMID

### Pattern

```
*****
 ***
  *
```

### Code

```java
int n = 3;
for(int i=n;i>=1;i--){
    for(int s=1;s<=n-i;s++){
        System.out.print(" ");
    }
    for(int j=1;j<=2*i-1;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

---

# 🔷 TYPE 10 — DIAMOND

### Pattern

```
  *
 ***
*****
 ***
  *
```

### Code

```java
int n = 3;

// upper
for(int i=1;i<=n;i++){
    for(int s=1;s<=n-i;s++) System.out.print(" ");
    for(int j=1;j<=2*i-1;j++) System.out.print("*");
    System.out.println();
}

// lower
for(int i=n-1;i>=1;i--){
    for(int s=1;s<=n-i;s++) System.out.print(" ");
    for(int j=1;j<=2*i-1;j++) System.out.print("*");
    System.out.println();
}
```

---

# 🎯 HOW TO BUILD ANY PATTERN (STEP-BY-STEP)

1. Count rows
2. Identify columns per row
3. Check pattern growth (increase/decrease)
4. Add spaces if alignment needed
5. Convert into loops

---

# 💣 TRICKY PATTERNS

## 1. Alternate 0/1

```
1
01
101
```

```java
for(int i=1;i<=3;i++){
    int num = i % 2;
    for(int j=1;j<=i;j++){
        System.out.print(num);
        num = 1 - num;
    }
    System.out.println();
}
```

---

## 2. Number Triangle Continuous

```
1
23
456
```

```java
int num = 1;
for(int i=1;i<=3;i++){
    for(int j=1;j<=i;j++){
        System.out.print(num++);
    }
    System.out.println();
}
```

---

## 3. Hollow Square

```
***
* *
***
```

```java
int n = 3;
for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
        if(i==1 || i==n || j==1 || j==n)
            System.out.print("*");
        else
            System.out.print(" ");
    }
    System.out.println();
}
```

---

# 🧑‍💻 PRACTICE PROBLEMS

1. Print square pattern
2. Increasing triangle
3. Decreasing triangle
4. Pyramid pattern
5. Inverted pyramid
6. Diamond
7. Number triangle
8. Reverse number triangle
9. Hollow square
10. Continuous numbers triangle

---

# ⚡ COMMON MISTAKES

* Forgetting `println()` → everything in one line
* Wrong loop limits
* Mixing i and j
* Not handling spaces properly

---

# ⚡ GOLDEN RULE

👉 Pattern = Rows + Columns + Logic (relation between i & j)
