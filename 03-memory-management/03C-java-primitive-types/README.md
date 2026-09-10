# 03C — Java Primitive Types

This module explores Java's eight primitive types, their value ranges, numeric behavior, floating-point precision, character representation, default initialization rules, and numeric promotion.

The focus is not only on memorizing primitive types, but on understanding the Java rules that affect correctness in real programs and DSA problems.

## Learning Objectives

By the end of this module, I should be able to:

- name and classify all eight Java primitive types,
- derive signed integer ranges from bit widths,
- explain integer overflow,
- distinguish `float` and `double`,
- explain why binary floating-point cannot represent every decimal exactly,
- explain the basic behavior of Java `char`,
- understand Java `boolean`,
- distinguish local-variable rules from default initialization of fields,
- explain basic numeric promotion,
- understand constant-expression narrowing,
- and identify possible numeric overflow in DSA problems.

## Java's 8 Primitive Types

```text
Primitive Types
│
├── Integral
│   ├── byte
│   ├── short
│   ├── int
│   ├── long
│   └── char
│
├── Floating-Point
│   ├── float
│   └── double
│
└── Boolean
    └── boolean
```

## Topics Covered

- Primitive types
- Primitive vs reference types
- `byte`, `short`, `int`, and `long`
- Bits and possible patterns
- Signed integer ranges
- Two's-complement range reasoning
- Integer overflow
- `float` and `double`
- Floating-point representation and precision
- Floating-point comparison
- `char` and UTF-16 code units
- `boolean`
- Default initialization
- Local-variable definite assignment
- Numeric promotion
- Constant expressions
- Explicit narrowing casts
- Intermediate overflow in DSA

## Core Integer Mental Model

For an `n`-bit signed integer:

```text
Total Bit Patterns
= 2^n

Minimum
= -2^(n - 1)

Maximum
= 2^(n - 1) - 1
```

Example:

```text
byte
→ 8 bits
→ 256 bit patterns
→ -128 to 127
```

## Important Java Behaviors

### Integer Overflow

```java
int value = Integer.MAX_VALUE;
value++;
```

Conceptually:

```text
2,147,483,647
       ↓ +1
-2,147,483,648
```

Normal Java integer overflow does not automatically throw an exception.

### Floating-Point Precision

```java
double result = 0.1 + 0.2;
```

A typical value is:

```text
0.30000000000000004
```

Binary floating-point should not be treated as exact decimal arithmetic.

### Numeric Promotion

```java
byte a = 10;
byte b = 20;

int sum = a + b;
```

The expression `a + b` has type `int` after binary numeric promotion.

### DSA Overflow

```java
int x = 100_000;
int y = 100_000;

long result = (long) x * y;
```

Casting before multiplication ensures the multiplication is performed using `long` arithmetic.

## Important Distinctions

```text
Primitive Type ≠ Reference Type

Integer Range ≠ Number of Positive Values Only

float ≠ Exact Decimal Arithmetic

char ≠ Guaranteed Complete Unicode Character

boolean ≠ 0 / 1

Local Variable Defaults ≠ Field Defaults

byte + byte ≠ Necessarily byte

Explicit Cast ≠ Guaranteed Safe Conversion

Final Variable Type ≠ Expression Evaluation Type
```

## Module Contents

### Detailed Notes

[`notes/java-primitive-types.md`](notes/java-primitive-types.md)

Detailed explanations of Java primitive types, ranges, overflow, floating-point behavior, `char`, `boolean`, default values, numeric promotion, casting, and DSA implications.

### Visual Notes

[`notes/03c-1-primitive-types-integer-family.png`](notes/03c-1-primitive-types-integer-family.png)

A4 quick notes covering primitive types, integer types, bit patterns, signed ranges, and overflow.

[`notes/03c-2-floating-point-char-boolean.png`](notes/03c-2-floating-point-char-boolean.png)

A4 quick notes covering `float`, `double`, floating-point precision, `char`, Unicode basics, and `boolean`.

[`notes/03c-3-default-values-numeric-promotion.png`](notes/03c-3-default-values-numeric-promotion.png)

A4 quick notes covering default initialization, local-variable rules, numeric promotion, constant expressions, and casting.

### Java Experiment

[`code/PrimitiveTypes.java`](code/PrimitiveTypes.java)

A focused Java experiment demonstrating:

- primitive values,
- integer overflow,
- floating-point behavior,
- `char` numeric behavior,
- `boolean`,
- field default values,
- numeric promotion,
- constant-expression narrowing,
- safe `long` multiplication.

### Quick Revision

[`revision/primitive-types-revision.md`](revision/primitive-types-revision.md)

Fast revision material containing key rules, common misconceptions, self-check questions, and actual mistakes discovered during prediction.

## Actual Learning Mistakes

Two useful mistakes were identified during this module:

1. The exact printed result of `0.1 + 0.2` was predicted incorrectly.
2. `100,000 × 100,000` was initially calculated as `1,000,000,000` instead of `10,000,000,000`.

These reinforce two habits:

```text
Do not assume exact floating-point representation.

Calculate maximum DSA values carefully before choosing a numeric type.
```

## DSA Connection

Primitive types directly affect algorithm correctness.

Before choosing `int` or `long`, consider:

```text
Maximum Input
      ↓
Maximum Number of Operations / Combined Values
      ↓
Maximum Intermediate Result
      ↓
Required Numeric Type
```

The final variable type alone is not enough.

For example:

```java
long result = a * b;
```

can still overflow before assignment if `a * b` is evaluated using `int` arithmetic.

## Learning Status

- [x] Learn
- [x] Understand Why
- [x] Concept Check
- [x] Predict
- [x] Dry Run
- [x] Java Experiment
- [x] Test
- [x] Analyze Important Numeric Behavior
- [x] Explain in My Own Words
- [x] A4 Visual Notes
- [x] Detailed Documentation
- [x] Record Mistakes
- [x] Quick Revision
- [x] Git Review
- [x] Commit & Push

## Navigation

← Previous: [03B — Variables & Values](../03B-variables-and-values/)

Next → **03D — References & Objects**