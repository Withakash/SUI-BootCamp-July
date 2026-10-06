# Java Core Logic Building: Loops, Digit Extraction, Patterns & Method Architecture

The journey toward mastering Computer Science and Data Structures & Algorithms (DSA) begins with control flow, iterative mechanics, and procedural modularity. Before diving into complex data structures like trees or graphs, a developer must build strong mental models for state mutation, two-dimensional spatial coordinate mapping, and robust method contract design.

This study guide provides a structured, step-by-step breakdown across four foundational domains of Java programming:
1. **Number-Based & Digit Extraction Problems**
2. **Pattern Problems & Dry-Running Programs**
3. **Methods: Parameters, Return Values & Method Overloading**
4. **Hands-On: Writing Methods for Basic Algorithmic Problems**

---

## 1. Domain 1: Number-Based Mechanics & Digit Extraction Problems

Digit manipulation introduces fundamental arithmetic operations in positional base-10 number systems. Rather than relying on string conversions—which introduce memory overhead and runtime latency—manipulating scalar integers at the numerical level enforces direct state tracking, modular arithmetic, and clean loop termination conditions.

### Mathematical Foundations of Digit Extraction

Given any positive decimal integer $n$, individual digits are isolated sequentially from right to left (least significant to most significant) using two primary operations:

1. **Least Significant Digit Extraction**: 
   $$d = n \pmod{10}$$
   The remainder modulo 10 yields the rightmost digit of $n$.

2. **Integer Truncation**: 
   $$n = \lfloor n / 10 \rfloor \quad \text{(in Java: } n = n / 10 \text{)}$$
   Integer division by 10 truncates the rightmost digit, shifting remaining digits one position to the right.

3. **Digit Assembly / Reversal**:
   $$\text{reversed} = (\text{reversed} \times 10) + d$$
   Multiplying the accumulated value by 10 shifts existing digits to the left, making space to append the newly extracted digit $d$.

> **Time Complexity Principle**: Because integer division by 10 reduces $n$ logarithmically, digit extraction runs in $\mathcal{O}(\log_{10} n)$ time complexity, corresponding directly to the number of digits in $n$.

---

### Primality Testing & The Square Root Boundary Optimization

Determining whether an integer $n > 1$ is prime requires checking if $n$ possesses any proper divisors other than $1$ and $n$.

* **Naive Approach ($\mathcal{O}(n)$)**: Iterate $i$ from $2$ to $n-1$. If $n \pmod i == 0$, $n$ is composite.
* **Optimized Trial Division ($\mathcal{O}(\sqrt{n})$)**: If a composite integer $n$ can be factored as $n = a \times b$, at least one factor must satisfy $a \le \sqrt{n}$. Therefore, restricting trial division checks to the range $2 \le i \le \lfloor\sqrt{n}\rfloor$ guarantees detecting composite factors while drastically reducing iteration counts.

#### Practical Question 1: Prime Verification Range ($1 \le n \le 50$)

Below is the complete Java implementation featuring an optimized `isPrime(int n)` predicate method invoked inside `main()` for numbers $1$ through $50$:

```java
public class PrimeRangeVerification {

    /**
     * Predicate method to check if a given integer n is prime.
     * Uses trial division up to sqrt(n) for O(sqrt(n)) time complexity.
     *
     * @param n Integer to evaluate
     * @return true if n is prime; false otherwise
     */
    public static boolean isPrime(int n) {
        // Corner Case: Numbers <= 1 are not prime
        if (n <= 1) {
            return false;
        }
        
        // 2 and 3 are prime numbers
        if (n <= 3) {
            return true;
        }

        // Eliminate multiples of 2 and 3 for quick pruning
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Trial division loop up to sqrt(n) using i * i <= n
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  PRIME NUMBER VERIFICATION (1 TO 50)    ");
        System.out.println("=========================================");

        int primeCount = 0;

        for (int n = 1; n <= 50; n++) {
            boolean status = isPrime(n);
            if (status) {
                primeCount++;
                System.out.printf("Number %2d : PRIME [✓]%n", n);
            } else {
                System.out.printf("Number %2d : COMPOSITE / NOT PRIME%n", n);
            }
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total primes found between 1 and 50: " + primeCount);
        System.out.println("=========================================");
    }
}
```

---

### Practical Question 2: Palindrome Number Verification

A number is a palindrome if it reads the same backward as forward (e.g., $121$, $1331$). Negative numbers are never palindromic due to the leading minus sign.

```java
public class PalindromeVerification {

    /**
     * Verifies whether an integer is a palindrome without string conversion.
     *
     * @param x Input integer
     * @return true if x is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int x) {
        // Negative numbers and non-zero numbers ending in 0 are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int digit = x % 10;
            reversed = (reversed * 10) + digit;
            x /= 10; // Truncate last digit
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        int[] testNumbers = {121, -121, 10, 12321, 0, 4554};
        for (int num : testNumbers) {
            System.out.printf("isPalindrome(%6d) -> %b%n", num, isPalindrome(num));
        }
    }
}
```

---

### Practical Question 3: Armstrong Number Verification

An Armstrong number (or Narcissistic number) of $k$ digits equals the sum of its digits each raised to the power $k$. For example, $153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153$.

```java
public class ArmstrongVerification {

    public static boolean isArmstrong(int n) {
        if (n < 0) return false;

        // Step 1: Count total digits (k)
        int temp = n;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        // Step 2: Accumulate sum of digits raised to power k
        temp = n;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {
        int[] testCases = {153, 370, 371, 407, 9474, 123};
        for (int val : testCases) {
            System.out.printf("isArmstrong(%5d) -> %b%n", val, isArmstrong(val));
        }
    }
}
```

---

### Domain 1: Specification Matrix & Problem Reference

| Problem Title | Standard Mapping | Signature Contract | Core Algorithmic Logic | Time / Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Primality Check** | LeetCode 204 / Standard | `boolean isPrime(int n)` | Loop $i = 2 \dots \lfloor\sqrt{n}\rfloor$; return `false` if $n \pmod i == 0$. | $\mathcal{O}(\sqrt{n})$ time, $\mathcal{O}(1)$ space |
| **Palindrome Number** | LeetCode 9 | `boolean isPalindrome(int x)` | Reverse digits using $rev = rev \times 10 + x \pmod{10}$; compare to original. | $\mathcal{O}(\log_{10} x)$ time, $\mathcal{O}(1)$ space |
| **Reverse Integer** | LeetCode 7 | `int reverse(int x)` | Extract digits and check $rev > (2^{31}-1)/10$ for overflow before shifting. | $\mathcal{O}(\log_{10} x)$ time, $\mathcal{O}(1)$ space |
| **Armstrong Number** | LeetCode 1134 | `boolean isArmstrong(int n)` | Count digits $k$, sum $d^k$ for each extracted digit, compare sum to $n$. | $\mathcal{O}(\log_{10} n)$ time, $\mathcal{O}(1)$ space |
| **Add Digits** | LeetCode 258 | `int addDigits(int num)` | Repeatedly sum digits until sum $< 10$ or compute $1 + (num - 1) \pmod 9$. | $\mathcal{O}(1)$ time (math) / $\mathcal{O}(\log_{10} n)$ |

---

## 2. Domain 2: Pattern Problems & Dry-Running Programs

Pattern printing translates geometric and spatial relationships into nested loop control flow. Developing pattern algorithms builds multi-dimensional spatial reasoning, loop bound coordination, and precise state tracing skills.

### Spatial Grid Iteration Mechanics

Pattern problems map a two-dimensional grid where:
* **Outer Loop Counter ($i$)**: Controls the current **row index** and sets the primary row state.
* **Inner Loop Counter ($j$ / $k$)**: Controls **column elements** within row $i$. Inner loop bounds are almost always dynamic expressions dependent on $i$.

> **Decomposition Rule**: Break complex geometric rows into explicit sub-components:
> $$\text{Row}(i) = \text{Leading Spaces}(i) + \text{Primary Symbols}(i) + \text{Trailing Spaces}(i)$$

---

### Classic Pattern Catalog & Mathematical Formulas

#### Pattern 1: Right-Angled Star Triangle ($N$ rows)
* **Row $i$ ($0 \le i < N$)**: Contains $i + 1$ stars.
* **Inner Bound**: $j \in [0, i]$.

```
*
**
***
****
```

#### Pattern 2: Symmetrical Pyramid ($N$ rows)
* **Leading Spaces**: $N - i - 1$
* **Star Column Count**: $2i + 1$
* **Outer Bound**: $i \in [0, N-1]$.

```
   *
  ***
 *****
*******
```

---

### Practical Code Implementation: Symmetrical Pyramid

```java
public class SymmetricalPyramid {

    /**
     * Prints a symmetrical star pyramid of N rows.
     *
     * @param n Number of rows
     */
    public static void printPyramid(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {
            
            // Inner Loop 1: Leading Spaces (N - i - 1)
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Inner Loop 2: Stars (2 * i + 1)
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }

            // Move to next line after completing row i
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Pyramid Pattern (N = 4):");
        printPyramid(4);
    }
}
```

---

### Step-by-Step Execution Trace Table ($N = 4$)

To master program dry-running, we trace execution state-by-state for $N = 4$:

| Row Index ($i$) | Target Spaces ($N - i - 1$) | Inner Space Loop Iterations ($j$) | Target Stars ($2i + 1$) | Inner Star Loop Iterations ($k$) | Generated Row Text Output | Line State |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **$i = 0$** | $4 - 0 - 1 = 3$ | $j = 0, 1, 2$ (3 steps) | $2(0) + 1 = 1$ | $k = 0$ (1 step) | `"   *"` | Completed |
| **$i = 1$** | $4 - 1 - 1 = 2$ | $j = 0, 1$ (2 steps) | $2(1) + 1 = 3$ | $k = 0, 1, 2$ (3 steps) | `"  ***"` | Completed |
| **$i = 2$** | $4 - 2 - 1 = 1$ | $j = 0$ (1 step) | $2(2) + 1 = 5$ | $k = 0, 1, 2, 3, 4$ (5 steps) | `" *****"` | Completed |
| **$i = 3$** | $4 - 3 - 1 = 0$ | Skips ($0$ steps) | $2(3) + 1 = 7$ | $k = 0, 1, \dots, 6$ (7 steps) | `"*******"` | Completed |

> **Dry-Run Insight**: Tracing loop variables in a structured matrix exposes boundary errors (such as off-by-one errors) before runtime execution.

---

## 3. Domain 3: Methods: Parameters, Return Values & Overloading

Procedural modularity abstracts repetitive logic into reusable, single-purpose methods. Designing clean method interfaces enforces separation of concerns, simplifies debugging, and manages stack frame allocation efficiently.

### Method Execution Stack & Activation Frames

When a Java program invokes a method:
1. **Stack Frame Push**: Java allocates a new activation frame on the call stack containing local variables and parameter slots.
2. **Control Transfer**: Execution shifts to the method body.
3. **Value Return & Pop**: Upon reaching `return`, the calculated result is passed back to the caller frame, the method's stack frame is popped off, and control resumes in the caller.

```
+-----------------------------------+
|  isPrime(int n = 5) Stack Frame   |  <-- Active Frame (Pushed)
+-----------------------------------+
|  main(String[] args) Stack Frame  |  <-- Caller Frame (Waiting)
+-----------------------------------+
```

---

### Parameter Semantics: Strict Pass-By-Value

Java strictly uses **pass-by-value** for all parameters:
* **Primitive Arguments (`int`, `double`, `boolean`)**: The method receives a copy of the primitive value. Modifying parameter variables inside the method has zero effect on caller variables.
* **Reference Arguments (Objects, Arrays)**: The method receives a copy of the memory reference pointing to the object. While reassigning the parameter variable does not alter caller references, modifying the underlying array or object mutates shared heap state.

---

### Static Polymorphism (Method Overloading)

Method Overloading allows multiple methods in the same class to share an identical method name, provided their **parameter signatures** differ.

#### Valid Overloading Criteria
Two methods overload correctly if they differ in:
1. **Number of parameters** (e.g., `add(int a, int b)` vs. `add(int a, int b, int c)`)
2. **Types of parameters** (e.g., `square(int x)` vs. `square(double x)`)
3. **Order of parameter types** (e.g., `process(int a, String b)` vs. `process(String a, int b)`)

> **Invalid Overloading Rule**: Methods **cannot** be overloaded by return type alone. The compiler resolves methods strictly by caller argument types. If signatures are identical, changing `void` to `int` causes a compile-time error.

---

### Practical Overloading Implementation Matrix

```java
public class MethodOverloadingDemonstration {

    // Overload 1: Calculate area of a Circle
    public static double getArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Overload 2: Calculate area of a Rectangle
    public static double getArea(double length, double width) {
        return length * width;
    }

    // Overload 3: Calculate area of a Triangle (Heron's Formula)
    public static double getArea(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        System.out.printf("Circle Area (r = 5.0)       : %.2f%n", getArea(5.0));
        System.out.printf("Rectangle Area (l=4, w=6)   : %.2f%n", getArea(4.0, 6.0));
        System.out.printf("Triangle Area (a=3, b=4, c=5): %.2f%n", getArea(3.0, 4.0, 5.0));
    }
}
```

---

## 4. Domain 4: Hands-On Applied Method Engineering

Writing production-grade code requires combining digit extraction, iterative control flow, and clean method interfaces into modular implementations. Applied method engineering mandates defensive programming against boundary conditions and edge cases.

### Defensive Design Guidelines
1. **Null Reference Guards**: Check array and object parameters for `null` before accessing length or indexing to prevent `NullPointerException`.
2. **Integer Overflow Management**: Prevent numeric wrap-around when handling 32-bit signed integers ($[-2^{31}, 2^{31}-1]$).
3. **Boundary Constraints**: Validate array index bounds ($0 \le \text{index} < \text{length}$) to eliminate `ArrayIndexOutOfBoundsException`.

---

### Implementation 1: Iterative Fibonacci Sequence Generator

```java
public class FibonacciGenerator {

    /**
     * Computes the n-th Fibonacci number iteratively.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int getFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index n cannot be negative.");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0; // F(0)
        int b = 1; // F(1)
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(0) -> " + getFibonacci(0));
        System.out.println("Fibonacci(1) -> " + getFibonacci(1));
        System.out.println("Fibonacci(10) -> " + getFibonacci(10));
    }
}
```

---

### Implementation 2: Single Number Detection via Bitwise XOR

Given a non-empty array where every element appears twice except for one unique element, find that single element.

* **Bitwise XOR Properties**:
  1. $x \oplus x = 0$
  2. $x \oplus 0 = x$
  3. $a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = b$ (Commutative & Associative)

```java
public class SingleNumberDetector {

    /**
     * Isolates unique element in O(n) time and O(1) space using XOR bitwise properties.
     */
    public static int findSingle(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR cancels paired duplicate values
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1, 2};
        System.out.println("Single Number in [4, 1, 2, 1, 2]: " + findSingle(numbers));
    }
}
```

---

### Implementation 3: Array Rotation via Triple Reverse

Rotates an integer array to the right by $k$ steps in $\mathcal{O}(n)$ time and $\mathcal{O}(1)$ auxiliary space.

Algorithm steps:
1. Normalize $k = k \pmod N$.
2. Reverse the entire array.
3. Reverse the first $k$ elements ($0 \dots k-1$).
4. Reverse the remaining $N - k$ elements ($k \dots N-1$).

```java
import java.util.Arrays;

public class ArrayRotation {

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n; // Normalize shift count
        if (k == 0) return;

        // Step 1: Reverse entire array
        reverseRange(nums, 0, n - 1);
        // Step 2: Reverse first k elements
        reverseRange(nums, 0, k - 1);
        // Step 3: Reverse remaining elements
        reverseRange(nums, k, n - 1);
    }

    private static void reverseRange(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println("Rotated Array by 3 steps: " + Arrays.toString(arr));
    }
}
```

---

### Implementation 4: Two Sum Index Search Engine

Finds indices of two numbers in an array that sum up to a target value in $\mathcal{O}(n)$ time using a Hash Map.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSumEngine {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        // Map stores value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[0]; // Return empty if no pair exists
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println("Two Sum Indices for Target 9: " + Arrays.toString(result));
    }
}
```

---

## 5. Comprehensive Self-Check Review Questions

Test your understanding of Java loops, digit extraction, patterns, and methods:

1. **Digit Extraction**: Why is modulo $10$ used to extract the rightmost digit, and why does $n / 10$ truncate it in Java? What is the time complexity of extracting all digits of $n$?
2. **Primality Optimization**: Why does trial division for checking primality stop at $\sqrt{n}$ rather than $n-1$? How much speedup does this provide for $n = 1,000,000$?
3. **Pattern Loops**: In a symmetrical pyramid pattern of $N$ rows, what are the exact mathematical expressions for the number of leading spaces and stars on row $i$ ($0 \le i < N$)?
4. **Method Overloading**: Can two methods in Java have the same name and parameter list, but different return types (e.g., `int compute(int x)` and `double compute(int x)`)? Explain why or why not.
5. **Pass-By-Value**: If an integer array `int[] arr = {1, 2, 3}` is passed to a method `modify(int[] a)` and the method sets `a[0] = 99`, does the caller see the change in `arr[0]`? What if the method assigns `a = new int[]{10, 20}`?

---

## Glossary of Key Terms

* **Digit Extraction**: The process of isolating individual digits of a decimal number using modular arithmetic ($n \pmod{10}$) and integer division ($n / 10$).
* **Trial Division**: An algorithm for primality testing that checks for divisibility among integers up to a chosen upper limit ($\lfloor\sqrt{n}\rfloor$).
* **Nested Loops**: A control structure where one loop runs inside the body of another loop, commonly used for multi-dimensional spatial grids and matrices.
* **Dry Running**: Manually tracing the execution of a program line-by-line using paper or structured tables to track variable state updates.
* **Activation Stack Frame**: A block of memory allocated on the call stack every time a method is invoked, holding its local variables, parameters, and return address.
* **Pass-By-Value**: The parameter-passing mechanism in Java where copies of argument values (primitives) or copies of object references are passed to methods.
* **Method Overloading**: Static polymorphism where multiple methods share the same name within a class but have distinct parameter signatures.
