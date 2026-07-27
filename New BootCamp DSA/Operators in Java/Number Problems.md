# 🚀 NUMBER PROBLEMS IN JAVA (Complete Guide)

---

# 🔹 What are Number Problems?

👉 Problems where:

* We take a number as input
* Break it into digits
* Apply logic (math / conditions)
* Produce a result

---

# 🔥 CORE PATTERN (MOST IMPORTANT)

```java
while(n > 0) {
    int digit = n % 10;   // extract last digit
    // process digit
    n = n / 10;           // remove last digit
}
```

👉 If this clicks, most problems become easy.

---

# 📌 1. Reverse a Number

```java
int n = 1234;
int rev = 0;

while(n > 0) {
    int digit = n % 10;
    rev = rev * 10 + digit;
    n /= 10;
}

System.out.println(rev);
```

---

# 📌 2. Palindrome Number

```java
int n = 121, original = n, rev = 0;

while(n > 0) {
    int digit = n % 10;
    rev = rev * 10 + digit;
    n /= 10;
}

if(original == rev)
    System.out.println("Palindrome");
else
    System.out.println("Not Palindrome");
```

---

# 📌 3. Armstrong Number

```java
int n = 153, original = n, sum = 0;

while(n > 0) {
    int digit = n % 10;
    sum += digit * digit * digit;
    n /= 10;
}

if(sum == original)
    System.out.println("Armstrong");
else
    System.out.println("Not Armstrong");
```

---

# 📌 4. Prime Number (Optimized)

```java
int n = 7;
boolean isPrime = true;

if(n <= 1) isPrime = false;

for(int i = 2; i <= Math.sqrt(n); i++) {
    if(n % i == 0) {
        isPrime = false;
        break;
    }
}

System.out.println(isPrime ? "Prime" : "Not Prime");
```

---

# 📌 5. Sum of Digits

```java
int n = 123, sum = 0;

while(n > 0) {
    sum += n % 10;
    n /= 10;
}

System.out.println(sum);
```

---

# 📌 6. Count Digits

```java
int n = 12345;
int count = 0;

while(n > 0) {
    count++;
    n /= 10;
}

System.out.println(count);
```

---

# 📌 7. Fibonacci Series

```java
int n = 10;
int a = 0, b = 1;

for(int i = 1; i <= n; i++) {
    System.out.print(a + " ");
    int next = a + b;
    a = b;
    b = next;
}
```

---

# 📌 8. Factorial

```java
int n = 5;
int fact = 1;

for(int i = 1; i <= n; i++) {
    fact *= i;
}

System.out.println(fact);
```

---

# 📌 9. Strong Number

👉 Sum of factorial of digits = number

```java
int n = 145, original = n;
int sum = 0;

while(n > 0) {
    int digit = n % 10;
    int fact = 1;
    for(int i = 1; i <= digit; i++) fact *= i;
    sum += fact;
    n /= 10;
}

System.out.println(sum == original ? "Strong" : "Not Strong");
```

---

# 📌 10. Perfect Number

```java
int n = 6;
int sum = 0;

for(int i = 1; i < n; i++) {
    if(n % i == 0) sum += i;
}

System.out.println(sum == n ? "Perfect" : "Not Perfect");
```

---

# 📌 11. GCD (HCF)

```java
int a = 12, b = 18;

while(b != 0) {
    int temp = b;
    b = a % b;
    a = temp;
}

System.out.println(a);
```

---

# 📌 12. LCM

```java
int a = 12, b = 18;
int lcm = (a * b) / gcd(a, b);

System.out.println(lcm);
```

---

# 🔥 PREDICT OUTPUT (HARD PRACTICE)

## Q1

```java
int n = 120, rev = 0;
while(n > 0) {
    rev = rev * 10 + n % 10;
    n /= 10;
}
System.out.println(rev);
```

## Q2

```java
int n = 5;
int fact = 1;
for(int i = n; i >= 1; i--) fact *= i;
System.out.println(fact);
```

## Q3

```java
int n = 7;
for(int i = 2; i < n; i++) {
    if(n % i == 0) {
        System.out.println("Not Prime");
        return;
    }
}
System.out.println("Prime");
```

## Q4

```java
int n = 153, sum = 0;
while(n > 0) {
    int d = n % 10;
    sum += d*d*d;
    n /= 10;
}
System.out.println(sum);
```

## Q5

```java
int n = 123;
int count = 0;
while(n != 0) {
    n /= 10;
    count++;
}
System.out.println(count);
```

## Q6

```java
int a = 0, b = 1;
for(int i = 0; i < 5; i++) {
    System.out.print(a + " ");
    int temp = a + b;
    a = b;
    b = temp;
}
```

## Q7

```java
int n = 10, sum = 0;
for(int i = 1; i <= n; i++) sum += i;
System.out.println(sum);
```

## Q8

```java
int n = 121, rev = 0, temp = n;
while(n > 0) {
    rev = rev*10 + n%10;
    n /= 10;
}
System.out.println(temp == rev);
```

## Q9

```java
int n = 10;
for(int i = 1; i <= n; i++) {
    if(i % 2 == 0) continue;
    System.out.print(i + " ");
}
```

## Q10

```java
int n = 100;
int sum = 0;
while(n > 0) {
    sum += n % 10;
    n /= 10;
}
System.out.println(sum);
```

---

# ⚠️ REALITY CHECK

If a student:

* Doesn't understand `%` and `/`
* Can't trace loops step-by-step
* Copies logic without thinking

👉 They will FAIL in number problems.

---

# 🎯 FINAL TAKEAWAY

👉 Master this:

* Digit extraction
* Loop control
* Condition logic

👉 Then:

* 80% problems = EASY
* Remaining = combination of same logic

---

# 🚀 END
