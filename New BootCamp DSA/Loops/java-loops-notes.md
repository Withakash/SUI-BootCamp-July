# Java Loops Study Notes: HackerRank Practical Challenge

Understanding loop constructs in Java requires connecting abstract iteration concepts with structured computational tasks. In competitive programming and foundational software development, loops serve as the mechanism for executing repetitive arithmetic operations and generating predictable sequences. This study guide analyzes the **Java Loops I** challenge from HackerRank, examining input parsing, iteration bounds, output string formatting, and complete solution mechanics.

---

## 1. Objective and Problem Specification

The primary objective of the HackerRank **Java Loops I** challenge is to use loop structures to calculate and print multiplication outputs.

### Challenge Requirements

The problem specification establishes a clear arithmetic task and output contract:

* **Input**: A single integer $N$ supplied through standard input.
* **Target Multiples**: The first 10 multiples of $N$, calculated across an index range where $1 \le i \le 10$.
* **Line Format**: Each calculated multiple must be printed on a new line adhering strictly to the template `N x i = result`.
* **Output Quantity**: Exactly 10 lines of formatted output.

Understanding this contract is essential: loop bounds must start precisely at index 1 and terminate after index 10.

---

## 2. Input Reading Mechanics

The starter solution in the HackerRank environment utilizes Java's standard input/output classes to read and parse the integer $N$.

### Boilerplate Input Pipeline

According to the provided starter code, input processing relies on `BufferedReader` wrapped around `InputStreamReader`:

```java
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(bufferedReader.readLine().trim());
bufferedReader.close();
```

### Component Breakdown

Each stage of the input pipeline performs a distinct data transformation step:

1. **`InputStreamReader(System.in)`**: Reads raw byte streams from standard input and converts them into character streams.
2. **`BufferedReader`**: Buffers character input for efficient reading of characters, arrays, and line strings.
3. **`bufferedReader.readLine()`**: Reads a line of text as a string until a line terminator is encountered.
4. **`.trim()`**: Removes leading and trailing white space characters from the string.
5. **`Integer.parseInt(...)`**: Parses the trimmed string argument as a signed decimal integer, storing the result in variable `N`.
6. **`bufferedReader.close()`**: Closes the reader stream to release system resources.

---

## 3. Iteration Logic and Loop Mechanics

To generate the required 10 lines of output, the loop must execute exactly 10 iterations.

### Defining Loop Bounds

The problem specifies that index $i$ ranges from 1 to 10 inclusive ($1 \le i \le 10$). In Java, a standard loop control structure manages this iteration counter.

* **Initial Counter**: $i = 1$
* **Termination Condition**: $i \le 10$
* **Step Increment**: $i = i + 1$ (or `i++`)

During each iteration step, the loop calculates the product $N \times i$ and formats the output string.

---

## 4. Output String Formatting

The output format requires exact string representation with specific spacing around operators:

`N x i = result`

### Construction Rules

For a given integer $N$ and loop counter $i$:

* **Left Operand**: Value of $N$
* **Operator String**: `" x "` (a lowercase 'x' enclosed by single space characters)
* **Right Operand**: Current loop counter $i$
* **Equals String**: `" = "` (an equals sign enclosed by single space characters)
* **Result**: Arithmetic product $N \times i$

In Java, this output line can be generated using standard string concatenation inside `System.out.println`:

`System.out.println(N + " x " + i + " = " + (N * i));`

Alternatively, formatted printing via `System.out.printf` can enforce the template:

`System.out.printf("%d x %d = %d%n", N, i, N * i);`

---

## 5. Complete Solution Implementation

Combining input parsing, loop control, and output string formatting yields the complete Java solution for the HackerRank challenge.

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }

        bufferedReader.close();
    }
}
```

---

## 6. Sample Case Walkthrough

To verify correctness, we trace the solution execution using the sample input provided in the challenge reference.

### Sample Input
`2`

### Iteration Trace Table

The table below outlines the evaluation of each loop iteration when $N = 2$:

| Iteration ($i$) | Formula ($N \times i$) | Computed Result | Output Printed to Standard Output |
| :--- | :--- | :--- | :--- |
| 1 | $2 \times 1$ | 2 | `2 x 1 = 2` |
| 2 | $2 \times 2$ | 4 | `2 x 4 = 8` |
| 3 | $2 \times 3$ | 6 | `2 x 3 = 6` |
| 4 | $2 \times 4$ | 8 | `2 x 4 = 8` |
| 5 | $2 \times 5$ | 10 | `2 x 5 = 10` |
| 6 | $2 \times 6$ | 12 | `2 x 6 = 12` |
| 7 | $2 \times 7$ | 14 | `2 x 7 = 14` |
| 8 | $2 \times 8$ | 16 | `2 x 8 = 16` |
| 9 | $2 \times 9$ | 18 | `2 x 9 = 18` |
| 10 | $2 \times 10$ | 20 | `2 x 10 = 20` |

### Verified Output Stream

```
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
2 x 10 = 20
```

The output stream generated by the loop control structure matches the required sample output line for line.
