# Java Primitive Types

Java provides eight built-in primitive types for representing fundamental values.

Understanding primitive types is important not only for Java syntax, but also for reasoning about numeric ranges, overflow, floating-point precision, character representation, type promotion, and program state in Data Structures and Algorithms.

This note focuses on Java's language-level behavior rather than assuming an exact physical JVM memory layout.

---

## 1. What Is a Primitive Type?

A primitive type is one of Java's built-in fundamental value types.

Java defines exactly eight primitive types:

```text
Primitive Types
│
├── Integral Types
│   ├── byte
│   ├── short
│   ├── int
│   ├── long
│   └── char
│
├── Floating-Point Types
│   ├── float
│   └── double
│
└── Boolean Type
    └── boolean
```

For learning convenience, `char` is often discussed separately as the character type, even though the Java Language Specification classifies it as an integral type.

Example:

```java
int age = 22;
```

Here:

```text
int → primitive type
age → variable
22  → integer literal producing an int value
```

---

## 2. Primitive Types vs Reference Types

Primitive types are different from reference types.

For example:

```java
int age = 22;
```

`int` is a primitive type.

But:

```java
Integer age = 22;
```

`Integer` is not a primitive type. It is a class and therefore a reference type.

Similarly:

```text
int      → primitive type
Integer  → reference type

char     → primitive type
Character → reference type

boolean  → primitive type
Boolean  → reference type
```

Wrapper classes will be studied separately.

---

# Integer Primitive Types

Java has four signed integer primitive types:

```text
byte
short
int
long
```

Their sizes are defined by Java.

| Type | Size | Range Formula |
|---|---:|---|
| `byte` | 8 bits | `-2^7` to `2^7 - 1` |
| `short` | 16 bits | `-2^15` to `2^15 - 1` |
| `int` | 32 bits | `-2^31` to `2^31 - 1` |
| `long` | 64 bits | `-2^63` to `2^63 - 1` |

---

## 3. Bits and Possible Patterns

A bit has two possible states:

```text
0
1
```

Therefore, `n` bits can represent:

```text
2^n
```

distinct bit patterns.

For an 8-bit value:

```text
2^8 = 256
```

So there are 256 possible bit patterns.

Whether those patterns are interpreted as signed or unsigned values does not change the number of bit patterns.

---

## 4. Signed Integer Range

For Java's signed integer types, a useful two's-complement range formula is:

```text
Minimum = -2^(n - 1)

Maximum = 2^(n - 1) - 1
```

where:

```text
n = number of bits
```

---

## 5. Why Is `byte` -128 to 127?

A Java `byte` uses 8 bits.

Using the formula:

```text
Minimum
= -2^(8 - 1)
= -2^7
= -128
```

Maximum:

```text
Maximum
= 2^(8 - 1) - 1
= 2^7 - 1
= 127
```

Therefore:

```text
byte range = -128 to 127
```

Count the values:

```text
-128 ... -1 → 128 negative values

0           → 1 value

1 ... 127   → 127 positive values
```

Total:

```text
128 + 1 + 127 = 256
```

This matches the 256 possible 8-bit patterns.

---

## 6. Why Is the Positive Maximum One Smaller?

It is tempting to expect:

```text
-128 to +128
```

but that would contain 257 values.

Zero also requires a representable value.

For an 8-bit signed integer:

```text
Negative values → 128
Zero            → 1
Positive values → 127
                  ---
Total           → 256
```

That is why the maximum is `127`, not `128`.

---

## 7. Integer Ranges

### byte

```text
Size:
8 bits

Range:
-128 to 127
```

### short

```text
Size:
16 bits

Range:
-32,768 to 32,767
```

Derived from:

```text
-2^15 to 2^15 - 1
```

### int

```text
Size:
32 bits

Range:
-2,147,483,648
to
2,147,483,647
```

Derived from:

```text
-2^31 to 2^31 - 1
```

For DSA, a useful approximation is:

```text
int ≈ ±2.1 billion
```

### long

```text
Size:
64 bits

Range:
-2^63
to
2^63 - 1
```

Exact values:

```text
-9,223,372,036,854,775,808
to
 9,223,372,036,854,775,807
```

For most DSA reasoning, understanding the `2^63` scale is more useful than memorizing every digit.

---

# Integer Overflow

## 8. What Is Integer Overflow?

Overflow occurs when an arithmetic result is outside the representable range of its integer type.

Consider:

```java
byte b = 127;
b++;
```

`127` is the maximum `byte` value.

Conceptually:

```text
127
 ↓ +1
-128
```

For Java integer arithmetic, values behave according to fixed-width two's-complement arithmetic.

An 8-bit conceptual view:

```text
01111111 = 127

+       1

10000000 = -128
```

The value wraps from the maximum representable value to the minimum.

---

## 9. `int` Overflow

Consider:

```java
int x = 2_147_483_647;
x++;

System.out.println(x);
```

Output:

```text
-2147483648
```

Why?

```text
Integer.MAX_VALUE
= 2^31 - 1

+ 1

Integer.MIN_VALUE
= -2^31
```

Normal Java integer overflow does not automatically throw an exception.

---

## 10. Detecting Overflow Explicitly

Sometimes overflow must be detected instead of silently wrapping.

Java provides methods such as:

```java
Math.addExact()
Math.subtractExact()
Math.multiplyExact()
```

For example:

```java
int result = Math.addExact(Integer.MAX_VALUE, 1);
```

This throws an `ArithmeticException` because the mathematical result cannot be represented as an `int`.

The important distinction is:

```text
Normal int arithmetic overflow
→ wraps

Exact arithmetic helpers
→ can detect overflow and throw
```

---

# Floating-Point Types

Java provides:

```text
float
double
```

for floating-point values.

---

## 11. `float`

`float` is a 32-bit IEEE 754 floating-point type.

Example:

```java
float price = 10.5f;
```

The suffix can be:

```text
f
F
```

---

## 12. `double`

`double` is a 64-bit IEEE 754 floating-point type.

Example:

```java
double price = 10.5;
```

A floating-point literal such as:

```text
10.5
```

is `double` by default.

Therefore:

```java
float price = 10.5;
```

does not compile because the `double` expression is not implicitly narrowed to `float` in this assignment.

Correct:

```java
float price = 10.5f;
```

---

## 13. `float` vs `double`

A simplified comparison:

```text
float
→ 32-bit IEEE 754
→ less precision than double

double
→ 64-bit IEEE 754
→ greater precision than float
```

However, neither should be understood as:

> "A type that can represent every decimal number exactly."

---

# Floating-Point Precision

## 14. Why Is `0.1 + 0.2` Interesting?

Consider:

```java
double result = 0.1 + 0.2;

System.out.println(result);
```

A typical output is:

```text
0.30000000000000004
```

Why?

Many decimal fractions cannot be represented exactly using a finite binary floating-point representation.

The stored floating-point values are nearby representable values.

Arithmetic on those approximations can expose small rounding differences.

Conceptually:

```text
Decimal values
      ↓
Binary floating-point representation
      ↓
Nearby representable values
      ↓
Arithmetic
      ↓
Rounding difference
```

---

## 15. Floating-Point Equality

Consider:

```java
System.out.println(0.1 + 0.2 == 0.3);
```

The result is typically:

```text
false
```

because the binary floating-point results do not necessarily represent the exact same mathematical value.

For many numerical algorithms, comparisons may instead use a tolerance:

```java
Math.abs(a - b) < epsilon
```

where `epsilon` is an appropriately chosen tolerance.

### Important

There is no single universal epsilon that is correct for every problem.

The appropriate comparison strategy depends on:

- scale,
- expected error,
- algorithm,
- problem requirements.

---

## 16. Decimal-Exact Use Cases

For applications that require controlled decimal arithmetic, such as many financial calculations, binary floating-point types may not be appropriate.

Java provides:

```java
BigDecimal
```

for decimal arithmetic with explicit precision and rounding control.

`BigDecimal` is not a primitive type.

It will be studied separately.

---

# The `char` Type

## 17. What Is `char`?

Java `char` is a 16-bit unsigned integral type.

It represents one UTF-16 code unit.

Example:

```java
char ch = 'A';
```

For `'A'`:

```text
Unicode code point:
U+0041

Numeric value:
65
```

Therefore:

```java
System.out.println(ch);
```

prints:

```text
A
```

while:

```java
System.out.println((int) ch);
```

prints:

```text
65
```

---

## 18. `char` Has Numeric Behavior

Because `char` is an integral type, it participates in numeric operations.

Example:

```java
char ch = 'A';
ch++;

System.out.println(ch);
System.out.println((int) ch);
```

Output:

```text
B
66
```

Conceptually:

```text
'A'
↓
65
↓ +1
66
↓
'B'
```

However, this does not mean that incrementing any Unicode code unit always produces a meaningful "next character."

---

## 19. Does One `char` Always Mean One Character?

No.

A Java `char` represents one UTF-16 code unit.

Some Unicode code points, especially supplementary characters, require two UTF-16 code units represented as a surrogate pair.

Therefore:

```text
char
≠
guaranteed complete Unicode character
```

This distinction becomes important in advanced string processing.

---

# The `boolean` Type

## 20. What Is `boolean`?

Java's `boolean` type represents logical truth values:

```text
true
false
```

Examples:

```java
boolean active = true;
boolean loggedIn = false;
```

---

## 21. `boolean` Is Not an Integer

This is invalid Java:

```java
boolean flag = 1;
```

Similarly:

```java
boolean flag = 0;
```

is invalid.

Java does not define direct boolean assignment using:

```text
1 → true
0 → false
```

as a language rule.

Correct:

```java
boolean flag = true;
```

or:

```java
boolean flag = false;
```

The numeric value `1` is not assignment-compatible with `boolean`.

---

# Default Values

## 22. Do Primitive Variables Automatically Get Default Values?

The answer depends on context.

It is wrong to memorize either:

```text
"All Java variables get default values."
```

or:

```text
"Java variables do not get default values."
```

The correct question is:

> What kind of variable or storage location are we discussing?

---

## 23. Local Variables

Consider:

```java
public static void main(String[] args) {
    int score;

    System.out.println(score);
}
```

This does not compile.

A local variable must be definitely assigned before it is read.

Therefore:

```text
Local variable
→ no automatic default initialization that allows reading it immediately
```

---

## 24. Fields

Consider:

```java
class Demo {
    int count;
    boolean active;
}
```

Instance fields receive default initialization.

Conceptually:

```text
count  → 0
active → false
```

Static fields also receive default initialization.

---

## 25. Primitive Default Values

Where default initialization applies, primitive defaults include:

```text
byte    → 0
short   → 0
int     → 0
long    → 0L

float   → 0.0f
double  → 0.0d

char    → '\u0000'

boolean → false
```

These rules apply in contexts where Java performs default initialization, such as fields and array components.

Do not blindly apply them to local variables.

---

# Numeric Promotion

## 26. `byte + byte` Does Not Necessarily Produce `byte`

Consider:

```java
byte a = 10;
byte b = 20;

byte c = a + b;
```

This does not compile as written.

Even though:

```text
10 + 20 = 30
```

and `30` fits inside the `byte` range.

Why?

For binary numeric operations such as this, Java applies binary numeric promotion.

The `byte` operands are promoted to `int`.

Conceptually:

```text
byte a ──┐
         ├──→ int operands → addition → int result
byte b ──┘
```

Therefore:

```text
a + b
```

has type:

```text
int
```

not `byte`.

An arbitrary `int` result is not implicitly narrowed to `byte`.

---

## 27. `byte`, `short`, and `char` in Arithmetic

In many arithmetic contexts, operands of type:

```text
byte
short
char
```

are promoted to at least:

```text
int
```

before the operation is performed.

This means:

```text
Small input types
≠
Small expression result type
```

Always reason about the expression's type, not only the variables' declared types.

---

# Constant Expression Nuance

## 28. Why Can `byte c = 10 + 20;` Compile?

Consider:

```java
byte c = 10 + 20;
```

This can compile.

At first, this may look inconsistent with:

```java
byte a = 10;
byte b = 20;

byte c = a + b;
```

which does not compile.

The key difference is the compile-time constant expression.

```text
10 + 20
```

can be evaluated by the compiler to:

```text
30
```

and `30` is representable as a `byte`.

Java permits certain narrowing conversions of constant expressions when their values are representable in the target type.

Compare:

```java
byte c = 10 + 20; // valid
```

with:

```java
byte a = 10;
byte b = 20;

byte c = a + b;   // compile-time error
```

The numeric result may appear the same, but the compile-time expression/type rules are different.

---

# Explicit Casting

## 29. Explicit Narrowing

We can explicitly cast:

```java
byte a = 10;
byte b = 20;

byte c = (byte) (a + b);
```

This compiles.

But an explicit cast should not be treated as:

> "Make the compiler accept the value safely."

A narrowing conversion can lose information.

Example:

```java
int value = 130;
byte result = (byte) value;
```

`130` cannot be represented in the range:

```text
-128 to 127
```

so the resulting `byte` value is not mathematically `130`.

Therefore:

> Never add a cast only to silence a compiler error without understanding the conversion.

---

# DSA Connection

## 30. Why Primitive Types Matter in DSA

Primitive type choices affect correctness.

Suppose a problem contains:

```text
n ≤ 100,000
value ≤ 100,000
```

A sum could reach roughly:

```text
100,000 × 100,000
= 10,000,000,000
```

That exceeds the maximum `int` value:

```text
2,147,483,647
```

Using:

```java
int sum;
```

could overflow.

A `long` may be required:

```java
long sum;
```

This is why DSA solutions must reason about constraints before selecting numeric types.

---

## 31. Example: Multiplication Overflow

There is another important detail.

Consider:

```java
int a = 100_000;
int b = 100_000;

long result = a * b;
```

It may appear that storing the result in a `long` solves the problem.

However:

```text
a * b
```

is evaluated using `int` arithmetic first because both operands are `int`.

Overflow can happen before the result is assigned to `long`.

Safer:

```java
long result = (long) a * b;
```

Now one operand is `long`, so numeric promotion causes the multiplication to occur using `long` arithmetic.

This is highly relevant in DSA.

---

## 32. Choosing Numeric Types in Problems

Before choosing `int` or `long`, ask:

```text
What is the maximum input value?

How many values may be combined?

Can addition overflow?

Can multiplication overflow?

What is the largest intermediate result?
```

Do not consider only the final expected answer.

Intermediate expressions can overflow too.

---

# Common Misconceptions

## 33. Primitive Means "Stored on the Stack"

Incorrect.

Primitive is a Java type-system concept.

Do not define primitive types based on one assumed physical memory location.

Exact runtime representation depends on context and JVM implementation.

---

## 34. Signed Integers Have Fewer Bit Patterns

Incorrect.

Eight bits always provide:

```text
2^8 = 256
```

bit patterns.

Signed interpretation changes how those patterns map to values.

---

## 35. Integer Overflow Throws an Exception Automatically

Incorrect for normal Java integer arithmetic.

Overflow normally wraps according to fixed-width integer semantics.

---

## 36. `float` Is the Default Decimal Type

Incorrect.

A floating-point literal such as:

```text
10.5
```

is `double` by default.

Use:

```text
10.5f
```

for a `float` literal.

---

## 37. `double` Stores Every Decimal Exactly

Incorrect.

Many decimal fractions cannot be represented exactly in finite binary floating-point.

---

## 38. One `char` Always Equals One Unicode Character

Incorrect.

A Java `char` represents one UTF-16 code unit.

Some Unicode code points require two `char` values.

---

## 39. `boolean` Uses 0 and 1 Like C

Incorrect at the Java language level.

Java boolean values are:

```text
true
false
```

Numeric values are not directly interchangeable with them.

---

## 40. Every Variable Automatically Receives a Default Value

Incorrect.

Context matters.

Fields and array components receive default initialization.

Local variables must satisfy definite-assignment rules before being read.

---

## 41. `byte + byte` Always Produces `byte`

Incorrect.

Numeric promotion can cause the expression to have type `int`.

---

## 42. Casting Makes Any Numeric Conversion Safe

Incorrect.

A cast can explicitly request a narrowing conversion, but information can be lost.

---

# Quick Reference

## Eight Primitive Types

```text
byte
short
int
long
float
double
char
boolean
```

## Integer Sizes

```text
byte  → 8-bit
short → 16-bit
int   → 32-bit
long  → 64-bit
```

## Signed Integer Range

```text
-2^(n-1)
to
2^(n-1) - 1
```

## Floating-Point

```text
float  → 32-bit IEEE 754
double → 64-bit IEEE 754
```

## Character

```text
char
→ 16-bit unsigned integral type
→ one UTF-16 code unit
```

## Boolean

```text
true
false
```

## Numeric Promotion Reminder

```text
byte / short / char
        ↓
often promoted to int
        ↓
arithmetic expression
```

---

# Self-Check

Before considering this topic complete, I should be able to answer:

1. What is a Java primitive type?
2. What are Java's eight primitive types?
3. Why can 8 bits represent 256 different patterns?
4. How can I derive the range of an `n`-bit signed integer?
5. Why is `byte` limited to `-128` through `127`?
6. What happens when an `int` exceeds `Integer.MAX_VALUE` in normal arithmetic?
7. Why does `float price = 10.5;` fail to compile?
8. Why can `0.1 + 0.2` differ slightly from mathematical `0.3`?
9. Why can exact `==` comparisons be problematic for floating-point calculations?
10. What does a Java `char` represent?
11. Why does `(int) 'A'` produce `65`?
12. Why does one Java `char` not always represent one complete Unicode character?
13. What values can a Java `boolean` hold?
14. Do local primitive variables receive usable automatic default values?
15. What are the defaults for primitive fields?
16. Why can `byte + byte` produce an `int` expression?
17. Why can `byte c = 10 + 20;` compile while `byte c = a + b;` may not?
18. Why should narrowing casts be used carefully?
19. How can an `int` multiplication overflow before assignment to `long`?
20. How do problem constraints help determine whether to use `int` or `long`?

---

# Key Takeaways

```text
Primitive Type
→ Built-in fundamental Java value type

Bits
→ Determine number of possible representations

Integer Range
→ Must be considered to avoid overflow

float / double
→ Binary floating-point; not exact decimal arithmetic

char
→ UTF-16 code unit, not guaranteed complete Unicode character

boolean
→ true or false, not 0 or 1

Local Variables
→ Must be definitely assigned before reading

Numeric Promotion
→ Expression type may differ from operand variable types

Casting
→ Explicit conversion, not a guarantee of safety
```

The most important DSA habit is:

> Do not choose a numeric type only because the input fits in it. Consider the largest value that every intermediate expression may produce.

---

## Next Topic

**03D — References & Objects**