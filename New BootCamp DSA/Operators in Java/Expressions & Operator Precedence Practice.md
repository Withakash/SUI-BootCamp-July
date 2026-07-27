# 📘 Expressions & Operator Precedence Practice (Java)

---

## 🧠 Operator Precedence Order (High → Low)

```
1.  ()                → Brackets
2.  ++ -- !           → Unary
3.  * / %             → Multiplication, Division, Modulus
4.  + -               → Addition, Subtraction
5.  < > <= >=         → Relational
6.  == !=             → Equality
7.  &&                → Logical AND
8.  ||                → Logical OR
9.  = += -= *= /= %=  → Assignment (Right → Left)
```

---

## 🔥 Important Rules

* Brackets () have highest priority
* Same precedence → follow associativity
* Assignment → Right to Left
* Most operators → Left to Right
* Always evaluate step-by-step

---

# 🧠 Practice Problems (Easy → Hard)

---

## 🟢 Easy

```java
1. int x = 10 + 5 * 2;
2. int x = (10 + 5) * 2;
3. int x = 20 / 5 + 3;
4. int x = 20 / (5 + 3);
5. int x = 5 + 2 * 3;
6. int x = 5 * 2 + 3;
7. int x = 10 % 3 + 2;
8. int x = 10 + 6 / 2;
```

---

## 🟡 Medium

```java
9.  int a = 5; int x = a++ + 2;
10. int a = 5; int x = ++a + 2;
11. int a = 5; int x = a++ + ++a;
12. int a = 5; int x = ++a + ++a;
13. int a = 5; int x = a++ + a++ + a;
14. int a = 5; int x = ++a + a++ + a;
15. int a = 10; boolean res = a > 5 && a < 20;
16. int a = 10; boolean res = a > 5 || a < 5;
17. int a = 10; boolean res = !(a > 5);
```

---

## 🔴 Hard

```java
18. int a = 5, b = 10; int x = a++ + ++b * 2;
19. int a = 5; int x = a++ * 2 + ++a;
20. int a = 5; int x = ++a * 2 + a++;
21. int a = 5; int x = a++ + a++ * ++a;
22. int a = 5; int x = ++a + ++a * ++a;
23. int a = 5; int b = 10; int x = a++ + ++b + a + b++;
24. int a = 5; int b = 10; int x = a++ + ++a + b++ + ++b;
25. int a, b, c; a = b = c = 5; int x = a++ + ++b + c++;
```

---

## 🎯 Instructions for Students

* Do NOT guess answers
* Solve step-by-step
* Track variable values carefully
* Use paper for simulation

---

## 🚀 Goal

> Master precedence + increment → strong coding foundation

---

**End of Practice Sheet ✅**
