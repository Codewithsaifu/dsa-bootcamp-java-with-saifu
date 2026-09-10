# Variables & Values in Java

Variables and values are fundamental to understanding how a Java program maintains and changes its state during execution.

This note focuses on the Java language-level model rather than assuming an exact physical memory layout.

---

## 1. What Is a Variable?

A variable is a named variable/entity in a Java program that holds a value according to its declared type.

Example:

```java
int age = 22;
```

Breakdown:

```text
int → declared type
age → variable name / identifier
22  → integer literal used to produce the assigned value
```

Useful mental model:

```text
age → 22
```

This represents the current program state. It should not be interpreted as an exact physical RAM layout.

---

## 2. Variable vs Value

A variable and its current value are different concepts.

```java
int score = 50;
```

Here:

```text
score → variable
50    → current value
```

Later:

```java
score = 60;
```

Now:

```text
score → 60
```

The variable is still `score`; its current value changed.

Therefore:

```text
Variable ≠ Value
```

---

## 3. Declared Type

Every Java variable has a declared type.

```java
int count = 10;
```

Here:

```text
count → variable
int   → declared type
10    → assigned int value
```

The declared type constrains which values and operations are valid according to Java's type system.

For example:

```java
int count = 10;

count = 20;         // Valid
count = "twenty";   // Compile-time error
```

A `String` value is not assignment-compatible with an `int` variable.

### Important

It is too simplistic to say that the assigned value's type must always be exactly identical to the declared type.

Java supports certain assignment conversions.

The important rule is:

> The assigned expression must be assignment-compatible with the target variable's declared type.

---

## 4. Declaration

A declaration introduces a variable and specifies its type.

```java
int age;
```

Breakdown:

```text
int → declared type
age → variable name
```

For a local variable, declaration alone does not mean that the variable can immediately be read.

---

## 5. Initialization

Initialization establishes an initial value.

A common example is:

```java
int score = 100;
```

This statement declares `score` and provides an initializer.

Conceptually:

```text
Declaration
     +
Initial Value
```

So:

```java
int score = 100;
```

can be described as a declaration with initialization.

---

## 6. Assignment

Assignment gives a value to a variable.

```java
int age;
age = 22;
```

The first statement declares `age`.

The second statement assigns the value `22`.

After execution:

```text
age → 22
```

The operator:

```text
=
```

is the assignment operator.

---

## 7. Reassignment

A variable may later receive another value.

```java
int age = 22;

age = 23;
```

State:

```text
Before:

age → 22

After:

age → 23
```

Calling the later assignment a "reassignment" is useful when reasoning about state.

However, Java does not have a separate reassignment operator. It is still an assignment.

---

## 8. Declaration vs Initialization vs Assignment

Useful comparison:

```text
int age;
→ Declaration

age = 22;
→ Assignment

age = 23;
→ Assignment again
  (conceptually reassignment)

int score = 100;
→ Declaration with initialization
```

These terms are related but should not be treated as identical technical concepts.

---

## 9. Local Variables and Definite Assignment

Consider:

```java
int age;

System.out.println(age);
```

This does not compile.

A local variable must satisfy Java's definite-assignment rules before it is read.

A compiler may report something similar to:

```text
variable age might not have been initialized
```

This works:

```java
int age;
age = 22;

System.out.println(age);
```

because `age` has been assigned before it is read.

### Important

Do not generalize this into:

> Java never provides default values.

Fields and array elements have different initialization rules, which will be studied later.

---

## 10. What Is a Literal?

A literal is a representation written directly in source code that evaluates to a value.

Example:

```java
int x = 10;
```

Here:

```text
10 → integer literal
```

The literal `10` represents an integer value in the source code.

---

## 11. What Is an Expression?

An expression can be evaluated to produce a value.

```java
int x = 10;
int y = x + 5;
```

Here:

```text
10    → integer literal
5     → integer literal
x + 5 → expression
```

Evaluation:

```text
x + 5
= 10 + 5
= 15
```

So:

```text
Expression
    ↓
Evaluation
    ↓
Value
```

---

## 12. Literal vs Value

A literal is not the only way a program can obtain a value.

Consider:

```java
int result = 10 + 20;
```

The source contains:

```text
10 → literal
20 → literal
```

But:

```text
10 + 20
```

is an expression that evaluates to:

```text
30
```

The value `30` was produced even though `30` was not directly written as the result literal in the expression.

Values may come from:

- literals,
- expressions,
- calculations,
- method results,
- input,
- other runtime computations.

Therefore:

```text
Literal ≠ Every Value
```

---

## 13. Primitive Assignment and Value Copying

Consider:

```java
int a = 10;
int b = a;
```

When:

```java
int b = a;
```

executes, the primitive value of `a` is used to initialize `b`.

State:

```text
a → 10
b → 10
```

Now:

```java
a = 99;
```

State becomes:

```text
a → 99
b → 10
```

`b` does not automatically become `99`.

Why?

Because the primitive value was copied during assignment.

The two variables were not permanently linked.

---

## 14. Assignment Is Not Method Argument Passing

This:

```java
int b = a;
```

is an assignment.

It demonstrates primitive value copying.

It should not be described as method argument "pass-by-value."

Compare:

```text
b = a
→ Assignment

change(a)
→ Method argument passing
```

Java's pass-by-value behavior will be studied later in:

**03G — Java Method Arguments**

---

## 15. Tracking Program State

Consider:

```java
int x = 5;
int y = x;

x = x + 10;
y = y + x;
```

### Line 1

```java
int x = 5;
```

State:

```text
x → 5
y → not declared
```

### Line 2

```java
int y = x;
```

State:

```text
x → 5
y → 5
```

### Line 3

```java
x = x + 10;
```

Evaluation:

```text
5 + 10 = 15
```

State:

```text
x → 15
y → 5
```

### Line 4

```java
y = y + x;
```

Evaluation:

```text
5 + 15 = 20
```

Final state:

```text
x → 15
y → 20
```

A useful dry-run habit is:

> After each important statement, write down the current values of relevant variables.

---

## 16. Why This Matters for DSA

State tracking is fundamental to algorithm dry runs.

Later, DSA problems will frequently use variables such as:

```text
i
j
left
right
mid
sum
count
max
current
previous
```

Their values change while an algorithm executes.

For example:

```text
sum → 0
      ↓
sum → 4
      ↓
sum → 9
      ↓
sum → 15
```

Correctly tracking those changes helps with:

- loop dry runs,
- array traversal,
- binary search,
- two pointers,
- sliding window,
- recursion,
- debugging,
- complexity reasoning.

---

## 17. Correct Mental Model

For Java and DSA reasoning, think of a variable using:

```text
Variable
├── Name
├── Declared Type
└── Current Value
```

Example:

```java
int score = 50;
```

```text
Name          → score
Declared Type → int
Current Value → 50
```

After:

```java
score = 60;
```

```text
Name          → score
Declared Type → int
Current Value → 60
```

---

## 18. Avoid Overly Physical Memory Models

It is common to hear:

> A variable is simply the name of a fixed RAM location.

That may be used as a beginner analogy, but it should not be treated as an exact description of Java execution.

For ordinary Java and DSA reasoning, prefer:

```text
age → 22
```

instead of inventing:

```text
age → 0x1234
```

The JVM, JIT compiler, and underlying system may affect how values are represented during execution.

Focus first on Java's observable behavior and program state.

---

## 19. Common Misconceptions

### Variable = Value ❌

Better:

```text
Variable → holds a current value
```

They are different concepts.

### Every Local Variable Automatically Gets a Default Value ❌

Local variables must satisfy definite-assignment rules before being read.

### Declaration and Initialization Are Always the Same ❌

```java
int age;
```

is different from:

```java
int age = 22;
```

### Literal = Every Value ❌

Expressions can also produce values.

### Primitive Assignment Links Variables Together ❌

```java
int a = 10;
int b = a;

a = 99;
```

results in:

```text
a → 99
b → 10
```

### Primitive Assignment = Method Pass-by-Value ❌

Primitive assignment and method argument passing are different contexts.

---

## 20. Quick Revision

```text
Variable
→ Named program entity that holds a value

Declared Type
→ Constrains valid values/operations according to Java's type system

Value
→ Data produced or represented during execution

Declaration
→ Introduces a variable

Initialization
→ Establishes an initial value

Assignment
→ Assigns a value to a variable

Reassignment
→ Descriptive term for assigning another value later

Literal
→ Source-code representation that evaluates to a value

Expression
→ Evaluates to produce a value

Primitive Assignment
→ Copies the primitive value

Current State
→ Current values/information at a point in execution
```

---

## 21. Self-Check

- [ ] Can I explain variable vs value?
- [ ] Can I identify the declared type of a variable?
- [ ] Can I distinguish declaration and initialization?
- [ ] Can I explain assignment and reassignment?
- [ ] Can I explain why an unassigned local variable cannot simply be read as `0`?
- [ ] Can I distinguish a literal from an expression?
- [ ] Can I explain how an expression produces a value?
- [ ] Can I explain primitive value copying?
- [ ] Can I explain why changing `a` does not automatically change `b` after `b = a`?
- [ ] Can I manually track program state statement by statement?

---

## Key Takeaway

> A Java variable has a declared type and a current value. During execution, assignments and expressions can change program state, and accurately tracking those changes is a fundamental skill for Java and DSA.

---

## Next Topic

**03C — Java Primitive Types**