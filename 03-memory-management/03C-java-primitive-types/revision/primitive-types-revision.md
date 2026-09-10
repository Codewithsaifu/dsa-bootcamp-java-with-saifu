# Java Primitive Types — Quick Revision

> Fast recall for `03C — Java Primitive Types`.

---

## 1. Java's 8 Primitive Types

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

Useful grouping:

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

> `char` is an integral type in Java, although it is often discussed separately because it represents UTF-16 code units.

---

## 2. Integer Sizes

```text
byte  → 8-bit signed
short → 16-bit signed
int   → 32-bit signed
long  → 64-bit signed
```

For `n` bits:

```text
Total bit patterns = 2^n
```

Signed integer range:

```text
Minimum = -2^(n - 1)
Maximum =  2^(n - 1) - 1
```

---

## 3. Important Integer Ranges

```text
byte
→ -128 to 127

short
→ -32,768 to 32,767

int
→ -2,147,483,648
   to
   2,147,483,647

long
→ -2^63
   to
   2^63 - 1
```

Remember:

```text
Understand the formula
>
Memorize huge numbers
```

---

## 4. Why Is `byte` -128 to 127?

8 bits provide:

```text
2^8 = 256
```

possible patterns.

They map to:

```text
128 negative values
+ 1 zero
+ 127 positive values
---------------------
= 256 values
```

Therefore:

```text
-128 to 127
```

---

## 5. Integer Overflow

```java
int value = Integer.MAX_VALUE;
value++;
```

Result:

```text
2147483647
      ↓ +1
-2147483648
```

Remember:

```text
Normal Java integer overflow
→ wraps around
→ no automatic exception
```

For explicit overflow checking, Java provides methods such as:

```java
Math.addExact()
```

---

## 6. float vs double

```text
float  → 32-bit floating-point
double → 64-bit floating-point
```

Default floating-point literal:

```java
10.5
```

is:

```text
double
```

Therefore:

```java
float price = 10.5;   // ❌
float price = 10.5f;  // ✅
double price = 10.5;  // ✅
```

---

## 7. Floating-Point Precision

```java
double result = 0.1 + 0.2;
```

Typical value:

```text
0.30000000000000004
```

Why?

Many decimal fractions cannot be represented exactly using finite binary floating-point.

Remember:

```text
Binary Floating-Point
≠
Exact Decimal Arithmetic
```

---

## 8. Floating-Point Equality

This may be:

```java
0.1 + 0.2 == 0.3
```

```text
false
```

For many numerical problems, a tolerance-based comparison may be appropriate:

```java
Math.abs(a - b) < epsilon
```

`epsilon` must be chosen according to the problem.

---

## 9. char

Java `char`:

```text
16-bit unsigned integral type
→ one UTF-16 code unit
```

Example:

```java
char ch = 'A';
```

```text
'A'
→ U+0041
→ numeric value 65
```

Therefore:

```java
(int) ch
```

produces:

```text
65
```

And:

```java
ch++;
```

changes:

```text
65 → 66
'A' → 'B'
```

Important:

```text
char ≠ guaranteed complete Unicode character
```

Some Unicode code points require two UTF-16 code units.

---

## 10. boolean

Valid values:

```text
true
false
```

Valid:

```java
boolean ready = true;
```

Invalid:

```java
boolean flag = 1;
```

Remember:

```text
boolean ≠ int
```

Java does not directly treat:

```text
1 → true
0 → false
```

as boolean assignment rules.

---

## 11. Default Values — Context Matters

### Local Variable

```java
int score;

System.out.println(score);
```

❌ Compile-time error

Reason:

A local variable must be definitely assigned before it is read.

### Fields

```java
class Demo {
    int count;
    boolean active;
}
```

Defaults:

```text
count  → 0
active → false
```

Remember:

```text
Local Variable
→ definite assignment required

Fields / Array Elements
→ default initialization
```

Do not memorize:

```text
"Every Java variable gets a default value." ❌
```

---

## 12. Primitive Default Values

Where default initialization applies:

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

---

## 13. Numeric Promotion

Consider:

```java
byte a = 10;
byte b = 20;
```

Expression:

```java
a + b
```

has type:

```text
int
```

Conceptually:

```text
byte
  ↓
int

byte
  ↓
int

int + int
    ↓
   int
```

Therefore:

```java
byte c = a + b; // ❌
```

does not compile as written.

---

## 14. Constant Expression Nuance

This can compile:

```java
byte c = 10 + 20;
```

because:

```text
10 + 20
→ compile-time constant expression
→ 30
→ representable as byte
```

But:

```java
byte a = 10;
byte b = 20;

byte c = a + b;
```

does not compile because `a + b` has type `int`.

Important:

```text
Same mathematical result
≠
Same Java type rules
```

---

## 15. Explicit Cast

Possible:

```java
byte c = (byte) (a + b);
```

But:

```text
Explicit Cast
≠
Guaranteed Safe Conversion
```

If the value is outside the target range, information can be lost.

Never cast only to silence the compiler.

---

## 16. Multiplication Overflow in DSA

Important example:

```java
int x = 100_000;
int y = 100_000;

long result = x * y;
```

Problem:

```text
x * y
```

is evaluated as `int` arithmetic first.

The mathematical result:

```text
100,000 × 100,000
= 10,000,000,000
```

does not fit in `int`.

Safer:

```java
long result = (long) x * y;
```

Now:

```text
(long) x * y
→ long arithmetic
→ 10,000,000,000
```

DSA rule:

> Check intermediate values, not only the final variable type.

---

# My Actual Mistakes

## Mistake 1 — Floating-Point Output

I predicted:

```text
0.300000000000004
```

Actual:

```text
0.30000000000000004
```

### Lesson

Do not try to infer the exact printed binary floating-point approximation from ordinary decimal intuition.

Core concept:

```text
0.1 + 0.2
≠ exactly mathematical 0.3
```

---

## Mistake 2 — Multiplication Calculation

I predicted:

```text
100,000 × 100,000
= 1,000,000,000
```

Correct:

```text
100,000
= 10^5

10^5 × 10^5
= 10^10
= 10,000,000,000
```

### Prevention Rule

When checking DSA constraints:

```text
Convert large values to powers of ten
        ↓
Calculate maximum intermediate result
        ↓
Compare with type range
```

Example:

```text
n ≤ 10^5
value ≤ 10^5

Maximum product:
10^5 × 10^5
= 10^10

int max ≈ 2.1 × 10^9

Therefore:
int may overflow
→ consider long
```

---

# Common Mistakes

```text
Primitive = always physically stored on Stack       ❌

Signed type has fewer bit patterns                  ❌

Integer overflow automatically throws exception     ❌

10.5 is a float literal                             ❌

double stores every decimal exactly                 ❌

char always equals one complete Unicode character   ❌

boolean accepts 0 and 1                             ❌

Every Java variable gets a default value            ❌

byte + byte always gives byte                       ❌

Explicit cast is always safe                        ❌

Storing into long prevents earlier int overflow     ❌
```

---

# 30-Second Recall

```text
8 Primitives
→ byte, short, int, long
→ float, double
→ char
→ boolean

Signed Range
→ -2^(n-1) to 2^(n-1)-1

Integer Overflow
→ wraps in normal arithmetic

10.5
→ double

10.5f
→ float

char
→ UTF-16 code unit

boolean
→ true / false

Local Variable
→ definitely assign before reading

byte + byte
→ commonly int expression

DSA
→ check maximum intermediate values
```

---

# Self-Check

- [ ] Can I name all 8 Java primitive types?
- [ ] Can I derive a signed integer range from the number of bits?
- [ ] Can I explain why `byte` ranges from -128 to 127?
- [ ] Can I explain integer overflow?
- [ ] Do I know why `10.5f` needs `f`?
- [ ] Can I explain the `0.1 + 0.2` issue?
- [ ] Do I know what a Java `char` represents?
- [ ] Can I explain why `boolean flag = 1` is invalid?
- [ ] Can I distinguish local-variable rules from field defaults?
- [ ] Can I explain why `byte + byte` may produce an `int`?
- [ ] Can I explain the constant-expression exception?
- [ ] Can I identify possible intermediate overflow in a DSA problem?

---

# One-Line Recall

> Primitive types have precise Java language rules for ranges, representation, promotion, and arithmetic; correct DSA code must reason about both value ranges and intermediate expression types.