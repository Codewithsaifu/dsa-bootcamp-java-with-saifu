# Memory Basics — Quick Revision

> Quick recall for `03A — Memory Basics`.

## Core Mental Model

```text
Running Program
      ↓
Required Data / State
      ↓
Processing
      ↓
Updated State / Result
```

## Key Points

- Memory resources help a running program maintain the data and state required during execution.
- CPU executes instructions and performs operations on data.
- Runtime state represents information associated with the program while it is executing.
- A variable and its current value are different concepts.
- Reassignment gives a variable a new current value.
- Primitive assignment copies the primitive value.
- For normal Java/DSA reasoning, avoid assuming exact physical RAM locations.

## Variable, Type & Value

```java
int age = 22;
```

```text
int → declared type
age → variable
22  → integer literal/value being assigned
```

Remember:

```text
Variable ≠ Value
```

## Primitive Assignment

```java
int a = 10;
int b = a;

a = 99;
```

Result:

```text
a → 99
b → 10
```

Why?

`b = a` copies the primitive value. Later reassigning `a` does not automatically change `b`.

## My Mistakes & Corrections

### Memory = RAM ❌

Better:

> RAM is an important part of the physical memory system, but the concept of memory is broader than only RAM.

### Memory only stores data ❌

Better:

> Memory resources help maintain data and execution-related state required by a running program.

### Variable = fixed physical RAM address ❌

Better mental model:

```text
age → 22
```

Do not assume a Java variable directly represents one fixed raw physical address.

### `int b = a` is pass-by-value ❌

Better:

> This is primitive assignment and value copying.

`Pass-by-value` will be discussed with method arguments.

## Quick Self-Check

- [ ] Why does a running program need memory?
- [ ] What is the basic difference between CPU and memory?
- [ ] What is runtime state?
- [ ] Variable and value mein kya difference hai?
- [ ] What happens during reassignment?
- [ ] Why does `b` stay `10` after `a` becomes `99`?
- [ ] Why should Java variables not be treated as raw pointers?

## One-Line Recall

> A running program needs memory resources to maintain the data and state required during execution.