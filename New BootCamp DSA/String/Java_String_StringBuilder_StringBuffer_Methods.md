# Java `String`, `StringBuilder`, and `StringBuffer` --- Complete Method Notes

> **Java version:** Java 21\
> These notes cover the commonly used and public API methods declared by
> `String`, `StringBuilder`, and `StringBuffer`, with examples.
> Inherited methods from `Object` are not repeated. Some methods are
> overloaded, meaning the same method name accepts different parameter
> types.

------------------------------------------------------------------------

## 1. `String` in Java

A `String` represents a sequence of characters.

``` java
String name = "Akash";
String message = new String("Hello");
```

### Important concept: `String` is immutable

Once a `String` object is created, its contents cannot be changed.
Methods that appear to modify a string return a **new** string.

``` java
String text = "hello";
text.toUpperCase();

System.out.println(text); // hello: original is unchanged

text = text.toUpperCase();
System.out.println(text); // HELLO
```

## 2. `String` methods

### A. Length and character access

  ---------------------------------------------------------------------------------------------------------------
  Method                                        What it does            Example
  --------------------------------------------- ----------------------- -----------------------------------------
  `length()`                                    Returns the number of   `"Java".length()` → `4`
                                                UTF-16 code units in    
                                                the string              

  `isEmpty()`                                   Checks whether length   `"".isEmpty()` → `true`
                                                is `0`                  

  `isBlank()`                                   Checks whether the      `"   ".isBlank()` → `true`
                                                string is empty or      
                                                contains only           
                                                whitespace (Java 11+)   

  `charAt(int index)`                           Returns the character   `"Java".charAt(1)` → `'a'`
                                                at an index; indexing   
                                                starts at `0`           

  `codePointAt(int index)`                      Returns the Unicode     `"ABC".codePointAt(0)` → `65`
                                                code point at an index  

  `codePointBefore(int index)`                  Returns the code point  `"ABC".codePointBefore(1)` → `65`
                                                before an index         

  `codePointCount(int begin, int end)`          Counts Unicode code     `"Java".codePointCount(0, 4)` → `4`
                                                points in a range       

  `offsetByCodePoints(int index, int offset)`   Finds an index after    `"Java".offsetByCodePoints(0, 2)` → `2`
                                                moving by a number of   
                                                Unicode code points     

  `toCharArray()`                               Copies characters into  `"cat".toCharArray()`
                                                a `char[]`              

  `getChars(srcBegin, srcEnd, dst, dstBegin)`   Copies a range of       `"Java".getChars(0, 2, arr, 0)`
                                                characters into an      
                                                existing array          

  `getBytes()`                                  Encodes the string into `"Java".getBytes()`
                                                bytes using the default 
                                                charset                 

  `getBytes(Charset charset)`                   Encodes using the       `text.getBytes(StandardCharsets.UTF_8)`
                                                specified charset       

  `getBytes(String charsetName)`                Encodes using a named   `text.getBytes("UTF-8")`
                                                charset                 
  ---------------------------------------------------------------------------------------------------------------

**Note:** Java `String` indexes are based on UTF-16 code units. For most
basic English examples, each visible character uses one index position,
but some Unicode characters use two code units.

### B. Comparing strings

  ---------------------------------------------------------------------------------------------------------------------
  Method                                    What it does            Example
  ----------------------------------------- ----------------------- ---------------------------------------------------
  `equals(Object other)`                    Checks whether the      `"Java".equals("Java")` → `true`
                                            contents are equal;     
                                            case-sensitive          

  `equalsIgnoreCase(String other)`          Compares while ignoring `"java".equalsIgnoreCase("JAVA")` → `true`
                                            case differences        

  `compareTo(String other)`                 Lexicographically       `"apple".compareTo("banana")` → negative
                                            compares strings;       
                                            returns negative, zero, 
                                            or positive             

  `compareToIgnoreCase(String other)`       Lexicographic           `"a".compareToIgnoreCase("A")` → `0`
                                            comparison ignoring     
                                            case                    

  `contentEquals(CharSequence cs)`          Compares content with a `"Java".contentEquals(new StringBuilder("Java"))`
                                            `CharSequence` such as  
                                            `StringBuilder`         

  `regionMatches(...)`                      Compares portions of    `"Java".regionMatches(0, "Jazz", 0, 2)` → `true`
                                            two strings             

  `startsWith(String prefix)`               Checks whether a string `"Java".startsWith("Ja")` → `true`
                                            begins with a prefix    

  `startsWith(String prefix, int offset)`   Checks for a prefix     `"Java".startsWith("va", 2)` → `true`
                                            starting at a specified 
                                            index                   

  `endsWith(String suffix)`                 Checks whether a string `"Java".endsWith("va")` → `true`
                                            ends with a suffix      

  `hashCode()`                              Returns the string's    `"Java".hashCode()`
                                            hash code               
  ---------------------------------------------------------------------------------------------------------------------

**Remember:** Use `equals()` to compare string contents. `==` checks
whether two references point to the same object.

``` java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);      // false: different objects
System.out.println(a.equals(b)); // true: same content
```

### C. Searching within a string

  ----------------------------------------------------------------------------------------------------
  Method                                     What it does            Example
  ------------------------------------------ ----------------------- ---------------------------------
  `contains(CharSequence s)`                 Checks whether a        `"Hello Java".contains("Java")` →
                                             sequence occurs         `true`
                                             anywhere                

  `indexOf(int ch)`                          Finds the first         `"banana".indexOf('a')` → `1`
                                             occurrence of a         
                                             character/code point    

  `indexOf(int ch, int fromIndex)`           Searches from a         `"banana".indexOf('a', 2)` → `3`
                                             starting index          

  `indexOf(String str)`                      Finds the first         `"banana".indexOf("na")` → `2`
                                             occurrence of a         
                                             substring               

  `indexOf(String str, int fromIndex)`       Searches for a          `"banana".indexOf("na", 3)` → `4`
                                             substring from an index 

  `lastIndexOf(int ch)`                      Finds the last          `"banana".lastIndexOf('a')` → `5`
                                             occurrence of a         
                                             character/code point    

  `lastIndexOf(int ch, int fromIndex)`       Searches backward from  `"banana".lastIndexOf('a', 3)` →
                                             an index                `3`

  `lastIndexOf(String str)`                  Finds the last          `"banana".lastIndexOf("na")` →
                                             occurrence of a         `4`
                                             substring               

  `lastIndexOf(String str, int fromIndex)`   Finds the last          `"banana".lastIndexOf("na", 3)` →
                                             substring occurrence at `2`
                                             or before an index      
  ----------------------------------------------------------------------------------------------------

`indexOf()` and `lastIndexOf()` return `-1` when no match is found.

### D. Extracting and combining strings

  ---------------------------------------------------------------------------------------------------------------------------------------
  Method                                                                      What it does            Example
  --------------------------------------------------------------------------- ----------------------- -----------------------------------
  `substring(int beginIndex)`                                                 Returns from the given  `"Programming".substring(3)` →
                                                                              index to the end        `"gramming"`

  `substring(int beginIndex, int endIndex)`                                   Returns from            `"Programming".substring(0, 7)` →
                                                                              `beginIndex` up to, but `"Program"`
                                                                              not including,          
                                                                              `endIndex`              

  `subSequence(int start, int end)`                                           Returns a character     `"Programming".subSequence(0, 7)`
                                                                              sequence for a range    

  `concat(String str)`                                                        Concatenates another    `"Hello ".concat("Java")` →
                                                                              string                  `"Hello Java"`

  `join(CharSequence delimiter, CharSequence... elements)`                    Joins multiple          `String.join("-", "A", "B", "C")` →
                                                                              sequences using a       `"A-B-C"`
                                                                              delimiter               

  `join(CharSequence delimiter, Iterable<? extends CharSequence> elements)`   Joins elements from an  `String.join(", ", names)`
                                                                              iterable                

  `repeat(int count)`                                                         Repeats the string a    `"ha".repeat(3)` → `"hahaha"`
                                                                              number of times (Java   
                                                                              11+)                    
  ---------------------------------------------------------------------------------------------------------------------------------------

### E. Replacing text

  ----------------------------------------------------------------------------------------------------------------------
  Method                                                     What it does            Example
  ---------------------------------------------------------- ----------------------- -----------------------------------
  `replace(char oldChar, char newChar)`                      Replaces every matching `"banana".replace('a', 'o')` →
                                                             character               `"bonono"`

  `replace(CharSequence target, CharSequence replacement)`   Replaces every literal  `"one one".replace("one", "two")` →
                                                             matching sequence       `"two two"`

  `replaceAll(String regex, String replacement)`             Replaces every regex    `"a1b2".replaceAll("\\d", "#")` →
                                                             match                   `"a#b#"`

  `replaceFirst(String regex, String replacement)`           Replaces only the first `"a1b2".replaceFirst("\\d", "#")` →
                                                             regex match             `"a#b2"`
  ----------------------------------------------------------------------------------------------------------------------

`replaceAll()` and `replaceFirst()` use regular expressions. `replace()`
does not interpret its target as a regular expression.

### F. Changing letter case and whitespace

  ----------------------------------------------------------------------------------------
  Method                         What it does            Example
  ------------------------------ ----------------------- ---------------------------------
  `toUpperCase()`                Converts to uppercase   `"Java".toUpperCase()` → `"JAVA"`
                                 using the default       
                                 locale                  

  `toUpperCase(Locale locale)`   Converts using a        `text.toUpperCase(Locale.ROOT)`
                                 specified locale        

  `toLowerCase()`                Converts to lowercase   `"JAVA".toLowerCase()` → `"java"`
                                 using the default       
                                 locale                  

  `toLowerCase(Locale locale)`   Converts using a        `text.toLowerCase(Locale.ROOT)`
                                 specified locale        

  `trim()`                       Removes                 `"  Java  ".trim()` → `"Java"`
                                 leading/trailing        
                                 characters with code    
                                 points up to U+0020     

  `strip()`                      Removes                 `"  Java  ".strip()` → `"Java"`
                                 leading/trailing        
                                 Unicode whitespace      
                                 (Java 11+)              

  `stripLeading()`               Removes leading Unicode `"  Java".stripLeading()` →
                                 whitespace (Java 11+)   `"Java"`

  `stripTrailing()`              Removes trailing        `"Java  ".stripTrailing()` →
                                 Unicode whitespace      `"Java"`
                                 (Java 11+)              

  `indent(int n)`                Adjusts line            `"Java\nCode".indent(2)`
                                 indentation (Java 12+)  

  `stripIndent()`                Removes incidental      `text.stripIndent()`
                                 indentation from        
                                 multi-line text (Java   
                                 15+)                    

  `translateEscapes()`           Interprets Java escape  `"A\\nB".translateEscapes()`
                                 sequences in the string contains a newline
                                 (Java 15+)              

  `toString()`                   Returns this string     `"Java".toString()` → `"Java"`
                                 itself                  
  ----------------------------------------------------------------------------------------

### G. Splitting strings

  ------------------------------------------------------------------------------------
  Method                             What it does            Example
  ---------------------------------- ----------------------- -------------------------
  `split(String regex)`              Splits around regex     `"a,b,c".split(",")`
                                     matches; trailing empty 
                                     parts are discarded     

  `split(String regex, int limit)`   Controls how many       `"a,b,".split(",", -1)` →
                                     splits occur and how    `["a","b",""]`
                                     trailing empty parts    
                                     are handled             

  `lines()`                          Returns a stream of     `"A\nB".lines()`
                                     lines (Java 11+)        
  ------------------------------------------------------------------------------------

Examples:

``` java
String data = "red,green,blue";
String[] colors = data.split(",");

for (String color : colors) {
    System.out.println(color);
}
```

### H. Formatting and value conversion

  --------------------------------------------------------------------------------------------------------------------------------
  Method                                                   What it does            Example
  -------------------------------------------------------- ----------------------- -----------------------------------------------
  `format(String format, Object... args)`                  Creates a formatted     `String.format("Name: %s", "Akash")`
                                                           string using the        
                                                           default locale          

  `format(Locale locale, String format, Object... args)`   Formats using a         `String.format(Locale.ROOT, "%.2f", 12.5)`
                                                           specified locale        

  `formatted(Object... args)`                              Formats this string as  `"Hello, %s".formatted("Akash")`
                                                           a format template (Java 
                                                           15+)                    

  `valueOf(boolean/char/int/long/float/double)`            Converts a primitive    `String.valueOf(123)` → `"123"`
                                                           value to a string       

  `valueOf(char[] data)`                                   Converts a character    `String.valueOf(new char[]{'J','a','v','a'})`
                                                           array to a string       

  `valueOf(char[] data, int offset, int count)`            Converts part of a      `String.valueOf(chars, 0, 2)`
                                                           character array         

  `valueOf(Object obj)`                                    Converts an object to a `String.valueOf(obj)`
                                                           string; `"null"` if     
                                                           reference is null       

  `copyValueOf(char[] data)`                               Converts a character    `String.copyValueOf(chars)`
                                                           array to a string       

  `copyValueOf(char[] data, int offset, int count)`        Converts part of a      `String.copyValueOf(chars, 1, 2)`
                                                           character array         
  --------------------------------------------------------------------------------------------------------------------------------

### I. Creating strings from other data

  ---------------------------------------------------------------------------------------------
  Method                  What it does            Example
  ----------------------- ----------------------- ---------------------------------------------
  `copyValueOf(char[])`   Static method that      `String.copyValueOf(chars)`
                          creates a string from a 
                          character array         

  `valueOf(...)`          Static overloaded       `String.valueOf(25)`
                          methods for primitive   
                          values, objects, and    
                          character arrays        

  `new String(...)`       Constructor overloads   `new String(bytes, StandardCharsets.UTF_8)`
                          that create strings     
                          from other strings,     
                          arrays, or encoded      
                          bytes                   
  ---------------------------------------------------------------------------------------------

**Constructor note:** Constructors are not methods, but common `String`
constructors include `String()`, `String(String)`, `String(char[])`,
`String(char[], int, int)`, `String(byte[], Charset)`,
`String(byte[], int, int, Charset)`, `String(int[], int, int)`, and
legacy charset-name overloads. Avoid platform-default byte encoding when
data must be portable.

### J. Other useful `String` APIs

  ------------------------------------------------------------------------------------------
  Method                                                 What it does
  ------------------------------------------------------ -----------------------------------
  `matches(String regex)`                                Checks whether the entire string
                                                         matches a regular expression

  `intern()`                                             Returns the canonical pooled
                                                         representation of the string

  `describeConstable()`                                  Provides a constant-description
                                                         representation where supported
                                                         (Java 12+)

  `resolveConstantDesc(MethodHandles.Lookup lookup)`     Resolves the string's constant
                                                         description

  `transform(Function<? super String, ? extends R> f)`   Passes this string to a function
                                                         and returns the function result
                                                         (Java 12+)
  ------------------------------------------------------------------------------------------

### K. Static utility methods in Java 21

  ------------------------------------------------------------------------------------------------------
  Method                            What it does            Example
  --------------------------------- ----------------------- --------------------------------------------
  `String.join(...)`                Joins text with a       `String.join("/", "usr", "local", "bin")`
                                    delimiter               

  `String.format(...)`              Formats values into a   `String.format("%d + %d", 2, 3)`
                                    string                  

  `String.valueOf(...)`             Converts a value into a `String.valueOf(true)`
                                    string                  

  `String.copyValueOf(...)`         Creates a string from a `String.copyValueOf(chars)`
                                    character array         

  `String.compare(...)`             Compares two strings    `String.compare("a", "b")`
                                    lexicographically (Java 
                                    21+)                    

  `String.CASE_INSENSITIVE_ORDER`   Comparator for          `list.sort(String.CASE_INSENSITIVE_ORDER)`
                                    case-insensitive string 
                                    ordering                
  ------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------

## 3. `StringBuilder`

`StringBuilder` stores a **mutable sequence of characters**. You can
change its contents without creating a new object for every change.

``` java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" Java");
System.out.println(sb); // Hello Java
```

It is generally the best choice for building strings repeatedly **within
one thread**.

### A. Constructors (not methods)

``` java
new StringBuilder()
new StringBuilder(50)          // initial capacity
new StringBuilder("Hello")
new StringBuilder(someSequence)
```

### B. `StringBuilder` methods

  --------------------------------------------------------------------------------------------------------------------------
  Method                                                           What it does            Example
  ---------------------------------------------------------------- ----------------------- ---------------------------------
  `append(...)`                                                    Adds data at the end;   `sb.append(" Java")`
                                                                   overloaded for          
                                                                   primitives, strings,    
                                                                   objects, arrays, and    
                                                                   character sequences     

  `appendCodePoint(int codePoint)`                                 Appends a Unicode code  `sb.appendCodePoint(65)`
                                                                   point                   

  `insert(int offset, ...)`                                        Inserts data at an      `sb.insert(0, "Hi ")`
                                                                   index; many overloads   

  `replace(int start, int end, String str)`                        Replaces the range      `sb.replace(0, 5, "Hey")`
                                                                   `[start, end)`          

  `delete(int start, int end)`                                     Deletes characters in   `sb.delete(0, 2)`
                                                                   `[start, end)`          

  `deleteCharAt(int index)`                                        Deletes one character   `sb.deleteCharAt(0)`

  `reverse()`                                                      Reverses the character  `sb.reverse()`
                                                                   sequence                

  `toString()`                                                     Creates a `String`      `String result = sb.toString()`
                                                                   containing the current  
                                                                   contents                

  `length()`                                                       Returns current         `sb.length()`
                                                                   character-sequence      
                                                                   length                  

  `capacity()`                                                     Returns current         `sb.capacity()`
                                                                   allocated capacity      

  `ensureCapacity(int minimumCapacity)`                            Ensures enough capacity `sb.ensureCapacity(100)`
                                                                   is available            

  `trimToSize()`                                                   Attempts to reduce      `sb.trimToSize()`
                                                                   capacity to the current 
                                                                   length                  

  `setLength(int newLength)`                                       Changes the length;     `sb.setLength(3)`
                                                                   extending fills new     
                                                                   positions with `\u0000` 

  `charAt(int index)`                                              Returns a character at  `sb.charAt(0)`
                                                                   an index                

  `setCharAt(int index, char ch)`                                  Replaces a character at `sb.setCharAt(0, 'J')`
                                                                   an index                

  `getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)`   Copies characters into  `sb.getChars(0, 2, arr, 0)`
                                                                   an array                

  `substring(int start)`                                           Returns a new `String`  `sb.substring(2)`
                                                                   from an index to the    
                                                                   end                     

  `substring(int start, int end)`                                  Returns a new `String`  `sb.substring(0, 3)`
                                                                   for a range             

  `subSequence(int start, int end)`                                Returns a character     `sb.subSequence(0, 3)`
                                                                   sequence for a range    

  `indexOf(String str)`                                            Finds the first         `sb.indexOf("Java")`
                                                                   occurrence of a         
                                                                   substring               

  `indexOf(String str, int fromIndex)`                             Searches from a given   `sb.indexOf("a", 2)`
                                                                   index                   

  `lastIndexOf(String str)`                                        Finds the last          `sb.lastIndexOf("a")`
                                                                   occurrence              

  `lastIndexOf(String str, int fromIndex)`                         Searches backward from  `sb.lastIndexOf("a", 5)`
                                                                   an index                

  `chars()`                                                        Returns an `IntStream`  `sb.chars()`
                                                                   of UTF-16 code units    

  `codePoints()`                                                   Returns an `IntStream`  `sb.codePoints()`
                                                                   of Unicode code points  

  `compareTo(StringBuilder another)`                               Compares this builder   `sb.compareTo(other)`
                                                                   lexicographically (Java 
                                                                   11+)                    
  --------------------------------------------------------------------------------------------------------------------------

### C. The overloaded `append(...)` family

`append` is one of the most-used methods. It supports these kinds of
arguments:

-   `boolean`, `char`, `int`, `long`, `float`, `double`
-   `String`, `StringBuffer`, `StringBuilder`
-   `CharSequence`
-   `char[]` and a selected range of a `char[]`
-   `Object`
-   `append(CharSequence s, int start, int end)`

``` java
StringBuilder sb = new StringBuilder();
sb.append("Age: ").append(20).append(", passed: ").append(true);
System.out.println(sb); // Age: 20, passed: true
```

### D. The overloaded `insert(...)` family

`insert` adds content at a specified index. Overloads support `boolean`,
`char`, integer and floating-point values, `char[]`, `CharSequence`,
`String`, and `Object`, including selected ranges for arrays/sequences.

``` java
StringBuilder sb = new StringBuilder("Jav");
sb.insert(3, "a");
System.out.println(sb); // Java
```

### E. `StringBuilder` range rules

For methods such as `delete(start, end)`, `replace(start, end, text)`,
`substring(start, end)`, and `getChars(start, end, ...)`, the ending
index is normally **exclusive**.

``` java
StringBuilder sb = new StringBuilder("ABCDE");
sb.delete(1, 3);
System.out.println(sb); // ADE (indexes 1 and 2 removed)
```

------------------------------------------------------------------------

## 4. `StringBuffer`

`StringBuffer` is also a mutable sequence of characters. Its main
difference from `StringBuilder` is that its methods are synchronized to
support thread-safe access to an individual buffer.

``` java
StringBuffer buffer = new StringBuffer("Hello");
buffer.append(" Java");
System.out.println(buffer); // Hello Java
```

### `StringBuffer` methods

`StringBuffer` offers essentially the same main method families as
`StringBuilder`:

-   **Adding:** `append(...)`, `appendCodePoint(int)`
-   **Inserting:** `insert(int, ...)`
-   **Editing/removing:** `replace(int, int, String)`,
    `delete(int, int)`, `deleteCharAt(int)`, `setCharAt(int, char)`,
    `setLength(int)`
-   **Reordering:** `reverse()`
-   **Reading/searching:** `length()`, `capacity()`, `charAt(int)`,
    `substring(int)`, `substring(int, int)`, `subSequence(int, int)`,
    `indexOf(String)`, `indexOf(String, int)`, `lastIndexOf(String)`,
    `lastIndexOf(String, int)`, `getChars(...)`
-   **Capacity management:** `ensureCapacity(int)`, `trimToSize()`
-   **Conversion/streams:** `toString()`, `chars()`, `codePoints()`
-   **Comparison:** `compareTo(StringBuffer)` (Java 11+)

Its overloaded `append(...)` and `insert(...)` methods accept the same
general kinds of values as the corresponding `StringBuilder` methods.
`StringBuffer` also has constructors similar to `StringBuilder`: empty,
initial capacity, `String`, or `CharSequence`.

------------------------------------------------------------------------

## 5. Difference between `String`, `StringBuilder`, and `StringBuffer`

  ------------------------------------------------------------------------
  Feature           `String`          `StringBuilder`    `StringBuffer`
  ----------------- ----------------- ------------------ -----------------
  Mutability        Immutable         Mutable            Mutable

  Can change same   No                Yes                Yes
  object's                                               
  contents?                                              

  Thread safety     Immutable object  Not synchronized;  Methods are
                    is safe to share  not thread-safe    synchronized
                    once safely       for concurrent     
                    published         mutation           

  Typical           Often inefficient Usually fastest    Often slower than
  performance for   in loops because  for repeated       `StringBuilder`
  repeated appends  new strings may   changes in one     due to
                    be created        thread             synchronization
                                                         overhead

  Best use          Fixed text,       Building/editing   Shared mutable
                    values, keys,     text in one thread text where
                    messages                             synchronized
                                                         individual
                                                         operations are
                                                         useful

  Common methods    `substring`,      `append`,          Similar editing
                    `split`,          `insert`,          methods to
                    `replace`,        `delete`,          `StringBuilder`
                    `equals`,         `reverse`,         
                    `contains`        `setCharAt`        

  `equals()`        Compares string   Inherits           Inherits
  behavior          content           identity-based     identity-based
                                      `equals()` from    `equals()` from
                                      `Object`           `Object`
  ------------------------------------------------------------------------

### Easy way to remember

-   **String:** fixed text --- once created, its contents do not change.
-   **StringBuilder:** editable text --- usually preferred when one
    thread is building a string.
-   **StringBuffer:** editable text with synchronized methods --- useful
    in some concurrent situations, but synchronization of individual
    methods does not automatically make a multi-step operation atomic.

### Example: `String` vs `StringBuilder`

``` java
String text = "Hello";
text.concat(" Java");
System.out.println(text); // Hello

StringBuilder sb = new StringBuilder("Hello");
sb.append(" Java");
System.out.println(sb); // Hello Java
```

`concat()` returns a new string, but `append()` changes the builder.

### Example: `StringBuilder` vs `StringBuffer`

``` java
StringBuilder builder = new StringBuilder("A");
builder.append("B"); // no synchronization

StringBuffer buffer = new StringBuffer("A");
buffer.append("B");  // synchronized method
```

Use `StringBuilder` by default for local string construction. Use
`StringBuffer` only when its synchronization fits the design; for
complex shared-state coordination, consider external synchronization or
other concurrency tools.

------------------------------------------------------------------------

## 6. Practical examples

### Example 1: Reverse a string

``` java
String input = "hello";
String reversed = new StringBuilder(input).reverse().toString();
System.out.println(reversed); // olleh
```

### Example 2: Build text in a loop

``` java
StringBuilder result = new StringBuilder();

for (int i = 1; i <= 5; i++) {
    result.append(i).append(" ");
}

System.out.println(result.toString()); // 1 2 3 4 5
```

### Example 3: Check if a string is a palindrome

``` java
String word = "level";
String reversed = new StringBuilder(word).reverse().toString();

if (word.equals(reversed)) {
    System.out.println("Palindrome");
} else {
    System.out.println("Not a palindrome");
}
```

### Example 4: Use common `String` methods

``` java
String email = "  student@alta.edu  ";

email = email.strip();

System.out.println(email.length());
System.out.println(email.contains("@"));
System.out.println(email.startsWith("student"));
System.out.println(email.endsWith(".edu"));
System.out.println(email.toLowerCase());
```

------------------------------------------------------------------------

## 7. Common mistakes to avoid

1.  **Using `==` to compare text:** use `equals()` for content
    comparison.
2.  **Forgetting immutability:** `text.toUpperCase()` does not update
    `text`; assign the result.
3.  **Confusing `replace()` with `replaceAll()`:** `replaceAll()` uses
    regex.
4.  **Going out of bounds:** indexes begin at `0`; an index must be
    valid for the operation.
5.  **Misunderstanding end indexes:** most range methods include the
    start and exclude the end.
6.  **Using `StringBuffer` automatically:** prefer `StringBuilder`
    unless synchronized access is needed.
7.  **Assuming `StringBuilder.equals()` compares contents:** convert to
    `String` or compare with `toString().equals(...)` when content
    equality is intended.
8.  **Assuming `StringBuffer` makes every multi-step action atomic:**
    each synchronized method is protected individually, but a sequence
    of calls may still interleave with another thread.

------------------------------------------------------------------------

## 8. Quick revision checklist

-   `length()` → number of UTF-16 code units / sequence length.
-   `charAt(i)` → character at index `i`.
-   `substring(a, b)` → characters from `a` through `b - 1`.
-   `indexOf(x)` → first match; `-1` if absent.
-   `equals()` → content comparison for `String`.
-   `split(regex)` → split using a regular expression.
-   `strip()` → remove Unicode whitespace at both ends.
-   `append()` → add to the end of a builder/buffer.
-   `insert()` → add at a position.
-   `delete()` → remove a range.
-   `reverse()` → reverse a builder/buffer.
-   `capacity()` → allocated storage, not the current character count.
-   `StringBuilder` → mutable, not synchronized.
-   `StringBuffer` → mutable, synchronized methods.

**Teaching tip:** First teach `String` and immutability, then common
searching/extraction methods, then `StringBuilder` mutation methods, and
finally compare `StringBuilder` with `StringBuffer`.


---

## 9. LeetCode Practice Problems: `String`, `StringBuilder`, and String Manipulation

These problems help practise string methods, splitting, scanning, character access, two pointers, and building strings. The list moves from beginner-friendly problems to more challenging ones.

### A. Beginner level

| # | LeetCode problem | Main concept to practise |
|---:|---|---|
| 1 | [344. Reverse String](https://leetcode.com/problems/reverse-string/) | Two pointers, swapping characters in a `char[]` |
| 2 | [58. Length of Last Word](https://leetcode.com/problems/length-of-last-word/) | `length()`, `charAt()`, whitespace handling |
| 3 | [709. To Lower Case](https://leetcode.com/problems/to-lower-case/) | Character conversion and `toLowerCase()` |
| 4 | [1768. Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/) | `charAt()`, `StringBuilder.append()` |
| 5 | [1816. Truncate Sentence](https://leetcode.com/problems/truncate-sentence/) | `split()`, substring or builder-based construction |
| 6 | [1108. Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/) | `replace()` or `StringBuilder` |
| 7 | [1678. Goal Parser Interpretation](https://leetcode.com/problems/goal-parser-interpretation/) | `replace()` and simple string processing |
| 8 | [2114. Maximum Number of Words Found in Sentences](https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/) | `split()`, `length()`, counting words |

### B. Intermediate level

| # | LeetCode problem | Main concept to practise |
|---:|---|---|
| 9 | [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) | `trim()`, `split("\\s+")`, reverse traversal, `StringBuilder` |
| 10 | [557. Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/) | Reverse each word while preserving word order |
| 11 | [541. Reverse String II](https://leetcode.com/problems/reverse-string-ii/) | Index ranges, `char[]`, two pointers |
| 12 | [443. String Compression](https://leetcode.com/problems/string-compression/) | In-place character updates, counts, `char[]` |
| 13 | [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | `startsWith()`, `substring()`, character comparison |
| 14 | [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/) | `indexOf()`, substring search |
| 15 | [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Two pointers, character checks, case conversion |
| 16 | [345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/) | Two pointers, `char[]`, swapping |
| 17 | [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | `charAt()`, mapping characters to values |
| 18 | [6. Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/) | Multiple `StringBuilder` objects, traversal patterns |

### C. Advanced practice

| # | LeetCode problem | Main concept to practise |
|---:|---|---|
| 19 | [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding window, character tracking |
| 20 | [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | Two pointers, expand around centre |
| 21 | [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/) | Character arrays, sorting, maps |
| 22 | [394. Decode String](https://leetcode.com/problems/decode-string/) | `StringBuilder`, stacks, nested patterns |
| 23 | [443. String Compression](https://leetcode.com/problems/string-compression/) | In-place writing and count conversion |
| 24 | [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) | Whitespace edge cases and clean result construction |

### D. Suggested practice order

1. Start with **344 — Reverse String** to learn two pointers.
2. Solve **58 — Length of Last Word** to practise spaces and scanning from the end.
3. Solve **1768 — Merge Strings Alternately** to practise `StringBuilder.append()`.
4. Solve **557 — Reverse Words in a String III** to reverse each word separately.
5. Solve **151 — Reverse Words in a String** to reverse word order and handle extra spaces.
6. Continue with **541 — Reverse String II**, **125 — Valid Palindrome**, and **345 — Reverse Vowels of a String**.
7. Move to **443 — String Compression** and **6 — Zigzag Conversion**.
8. Then practise sliding-window and stack-based problems.

### E. Practice rule

For each problem, follow this sequence:

1. Understand the input and expected output.
2. Try a simple brute-force approach.
3. Identify the relevant string operation or pattern.
4. Write the Java solution.
5. Test normal cases and edge cases.
6. State time and space complexity.

**Important:** `StringBuilder` is useful for constructing or editing text, but it is not the solution to every string problem. Some problems are better solved with two pointers, a character array, a hash map, a sliding window, or a stack.
