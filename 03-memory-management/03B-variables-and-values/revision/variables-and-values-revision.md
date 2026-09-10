# Variables & Values — Quick Revision

> Fast recall for `03B — Variables & Values`.

## Core Mental Model

```text
Variable
├── Name
├── Declared Type
└── Current Value
```

Example:

```java
int age = 22;
```

```text
int → declared type
age → variable
22  → integer literal / assigned value
```

Remember:

```text
Variable ≠ Value
```

---

## Declaration

```java
int age;
```

Introduces a variable with its declared type.

```text
int → type
age → variable name
```

---

## Initialization

```java
int score = 100;
```

Declaration with an initial value.

```text
score → 100
```

---

## Assignment

```java
int age;
age = 22;
```

`age = 22` assigns a value to the already declared variable.

---

## Reassignment

```java
age = 23;
```

Conceptually:

```text
age → 22
        ↓
age → 23
```

`reassignment` is a useful descriptive term. The operation still uses Java's assignment operator.

---

## Local Variable Rule

This does not compile:

```java
int age;
System.out.println(age);
```

Why?

A local variable must be definitely assigned before it is read.

Remember:

```text
Local variable
→ No automatic default initialization for reading before assignment
```

Fields and array elements follow different initialization rules.

---

## Literal vs Expression vs Value

```java
int x = 10;
int y = x + 5;
```

```text
10    → integer literal
5     → integer literal
x + 5 → expression
15    → value produced by evaluation
```

Mental model:

```text
Expression
    ↓
Evaluation
    ↓
Value
```

Not every value must appear directly as a literal in source code.

---

## Primitive Assignment

```java
int a = 10;
int b = a;
```

After assignment:

```text
a → 10
b → 10
```

Then:

```java
a = 99;
```

Result:

```text
a → 99
b → 10
```

Why?

```text
b = a
  ↓
Primitive value copied
```

The variables are not permanently linked.

---

## Dry-Run Rule

For:

```java
int x = 5;
int y = x;

x = x + 10;
y = y + x;
```

Track state after every statement:

```text
Line 1:
x → 5
y → not declared

Line 2:
x → 5
y → 5

Line 3:
x → 15
y → 5

Line 4:
x → 15
y → 20
```

Rule:

> After every important statement, track the current values.

---

# My Actual Mistake

During prediction, I predicted:

```text
a → 10
b → 99
```

for:

```java
int a = 10;
int b = a;

a = 99;
```

## Why It Was Wrong

I incorrectly treated `a` and `b` as if they remained linked after primitive assignment.

## Correct Mental Model

At:

```java
int b = a;
```

the current primitive value is copied.

```text
Before:

a → 10

After b = a:

a → 10
b → 10

After a = 99:

a → 99
b → 10
```

## Prevention Rule

> For primitive assignment, first copy the current value, then track each variable independently.

---

## Important Terminology

Do not confuse:

```text
int b = a;
```

with method argument passing.

This is:

```text
Assignment
+
Primitive value copying
```

Not:

```text
Method pass-by-value
```

Java method argument passing will be studied separately.

---

## Common Mistakes

```text
Variable = Value                              ✗

Variable = guaranteed fixed RAM address      ✗

Every local variable automatically gets 0    ✗

Literal = every possible value                ✗

Primitive assignment permanently links
two variables                                 ✗

Primitive assignment = method pass-by-value  ✗
```

---

## 30-Second Recall

```text
Declaration
→ Introduce variable

Initialization
→ Establish initial value

Assignment
→ Assign a value

Reassignment
→ Assign another value

Literal
→ Written representation in source code

Expression
→ Evaluates to a value

Primitive Assignment
→ Copies the primitive value

Current State
→ Current values at a point in execution
```

---

## Self-Check

- [ ] Variable aur value mein difference explain kar sakta hoon?
- [ ] Declaration vs initialization explain kar sakta hoon?
- [ ] Assignment vs reassignment explain kar sakta hoon?
- [ ] Unassigned local variable ko read kyun nahi kar sakte?
- [ ] Literal aur expression mein difference clear hai?
- [ ] Primitive assignment mein kya copy hota hai?
- [ ] `a` change hone ke baad `b` unchanged kyun reh sakta hai?
- [ ] Code ko statement-by-statement dry-run kar sakta hoon?

---

## One-Line Recall

> A Java variable has a declared type and a current value; primitive assignment copies the primitive value, so later reassignment of one variable does not automatically change another.