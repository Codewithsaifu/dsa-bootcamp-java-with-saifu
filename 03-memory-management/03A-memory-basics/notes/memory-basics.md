# Memory Basics

Memory is a fundamental part of program execution. A running program needs resources to maintain the data and state required while its instructions are being executed.

This note introduces memory from a Java and DSA perspective without assuming a fixed physical memory layout or going into JVM implementation details too early.

---

## 1. What Is Memory?

At a high level, memory provides storage that allows a running program to keep information available while it executes.

A program may need to maintain:

- input data,
- variable values,
- intermediate results,
- current program state,
- objects and arrays,
- information related to active computations.

A useful introductory mental model is:

```text
Program
   ↓
Required Data / State
   ↓
Processing
   ↓
Updated State / Result
```

Memory allows information needed by the computation to remain available throughout the relevant parts of execution.

> This is a conceptual model. It does not describe the exact physical location of every value in a real JVM implementation.

---

## 2. Why Does a Running Program Need Memory?

Consider:

```java
int score = 50;
score = score + 10;

System.out.println(score);
```

Before the second statement can calculate the new value of `score`, the current value must be available.

Conceptually:

```text
score → 50

        ↓

50 + 10

        ↓

score → 60
```

The program maintains state across its execution.

Without the ability to preserve relevant information, later instructions would not have the data they need to perform their work.

This gives us an important idea:

```text
Current State
     ↓
Processing
     ↓
Updated State
```

---

## 3. CPU and Memory Have Different Roles

The CPU and memory work together, but they should not be treated as the same thing.

### CPU

The processor executes instructions and performs operations such as:

- arithmetic,
- comparisons,
- control operations,
- data manipulation.

### Memory

Memory resources help keep the data and execution state required by a running program available.

A simplified model is:

```text
Required Data / State
        ↓
      CPU
        ↓
   Processing
        ↓
Result / Updated State
```

This model is intentionally simplified.

Modern processors also contain registers and caches, so it is inaccurate to assume that every value involved in every calculation must physically remain in RAM at every moment.

For Java and DSA learning, the important question is usually:

> What information must the program maintain?

rather than:

> At which exact physical RAM address is this value stored?

---

## 4. Persistent Storage vs Runtime State

A program stored on an SSD or other persistent storage is different from the state of that program while it is running.

For example:

```text
Main.java
```

may exist as a file on persistent storage even when the program is not executing.

When a program runs, it develops runtime state.

For example:

```text
score → 50
        ↓
calculation
        ↓
score → 60
```

The current value of `score` is relevant to that particular execution.

A useful distinction is:

```text
Persistent Storage
→ Keeps files/data across program executions

Runtime State
→ Information associated with the currently executing program
```

Operating systems, virtual memory, caches, and physical RAM make the complete picture more sophisticated. Those details are outside the scope of this introductory note.

---

## 5. Variables, Types, and Values

Consider:

```java
int age = 22;
```

There are three useful ideas here:

```text
int  → declared type
age  → variable name
22   → integer literal producing the assigned int value
```

At a beginner level, we can represent the current state as:

```text
age → 22
```

However:

```text
Variable ≠ Value
```

`age` is the variable, while `22` is the value currently assigned to it.

The declared type `int` determines the kind of values the variable is allowed to hold according to Java's type system.

---

## 6. Reassignment and Program State

Variables can receive new values during execution.

Example:

```java
int age = 22;
age = 23;
```

Conceptually:

```text
Initial state:

age → 22

After reassignment:

age → 23
```

The important language-level observation is that the current value of `age` is now `23`.

We should avoid making unnecessary claims such as:

> "`22` was physically deleted from one exact RAM address and replaced with `23`."

The Java language-level behavior does not require us to reason about the implementation in that way.

---

## 7. Primitive Assignment: A Preview

Consider:

```java
int a = 10;
int b = a;

a = 99;

System.out.println(b);
```

When:

```java
int b = a;
```

executes, the primitive value of `a` is used to initialize `b`.

Conceptually:

```text
After b = a:

a → 10
b → 10
```

Then:

```java
a = 99;
```

produces:

```text
a → 99
b → 10
```

Therefore:

```text
Output: 10
```

Changing `a` afterward does not automatically change `b`.

This is primitive value-copy behavior during assignment.

> This should not be confused with Java's "pass-by-value" rule. Pass-by-value specifically becomes relevant when values are passed as arguments to methods and will be studied separately.

---

## 8. What Is a Memory Address?

Physical and virtual memory systems use addressing mechanisms to identify memory locations.

At the Java language level, however, programmers normally do not manipulate ordinary Java variables through raw memory addresses.

For example:

```java
int age = 22;
```

A useful conceptual representation is:

```text
age → 22
```

It is generally not useful or reliable to reason as:

```text
age → fixed raw address 0x1234
```

and assume that this exact address is directly exposed and controllable through normal Java code.

The JVM, JIT compiler, operating system, and underlying hardware may influence how values are represented and where they exist during execution.

Java deliberately provides a higher-level programming model.

---

## 9. Why Physical Memory Diagrams Can Be Misleading

Beginner explanations often draw variables as boxes:

```text
┌─────────────┐
│ age = 22    │
└─────────────┘
```

This can be useful for understanding state.

The problem begins when the diagram is interpreted as an exact description of physical memory.

For example, these rules should not be blindly memorized:

```text
Primitive → always physically on the stack
Object    → always physically on the heap
Variable  → fixed RAM address
```

Such statements mix simplified learning models with JVM implementation details.

Throughout this repository, diagrams are used to explain Java behavior and algorithmic reasoning, not to claim an exact physical layout unless explicitly stated.

---

## 10. A Better Mental Model

For introductory Java and DSA reasoning, focus on relationships and state.

Instead of asking:

```text
At exactly which RAM address is this value?
```

first ask:

```text
What value does this variable currently represent?

What data must remain available?

Does an assignment copy a value?

Can multiple references access the same object?

What additional memory does this algorithm require?
```

These questions are much more useful when solving DSA problems.

---

## 11. Connection to DSA

Memory fundamentals become increasingly important as we study data structures and algorithms.

### Arrays

We will need to distinguish an array reference from the array object and its elements.

### Linked Lists

Nodes contain data and references that connect nodes together.

### Trees

References connect parent and child objects.

### Graphs

Different representations maintain vertices, edges, collections, and references.

### Recursion

Every active recursive call requires execution state, which contributes to space usage.

### Algorithms

We analyze whether an algorithm requires additional memory as the input grows.

For example:

```text
Fixed number of extra variables
→ O(1) auxiliary space

New array proportional to n
→ O(n) auxiliary space
```

These concepts will be studied in detail later.

---

## 12. Common Misconceptions

### Misconception 1

> A variable is simply the name of a fixed physical RAM address.

This is an unnecessarily low-level model for ordinary Java reasoning. The runtime may represent and optimize values in ways that do not match such a rigid picture.

### Misconception 2

> The CPU has no storage of its own.

Modern CPUs use registers and caches in addition to the broader memory hierarchy.

### Misconception 3

> Every value used by a program always exists in RAM during every operation.

This ignores registers, caches, runtime optimizations, and other implementation details.

### Misconception 4

> A variable and its value are the same thing.

They are different concepts.

For:

```java
int age = 22;
```

`age` is the variable and `22` is the literal/value involved in the assignment.

### Misconception 5

> Primitive assignment links two variables together.

It does not.

```java
int a = 10;
int b = a;
a = 99;
```

`b` remains `10`.

---

## 13. Quick Revision

```text
Memory
→ Helps maintain information required during program execution.

CPU
→ Executes instructions and performs operations.

Runtime
→ The period during which a program is executing.

Program State
→ Information representing the program's current execution situation.

Variable
→ A named variable/entity that holds a value.

Value
→ The data represented by a variable or expression.

Reassignment
→ Assigning a new value to an existing variable.

Primitive Assignment
→ The primitive value is copied during assignment.

Memory Address
→ An underlying addressing concept; ordinary Java programming does not expose variables as freely manipulable raw pointers.
```

---

## 14. Self-Check

Before considering this topic complete, I should be able to answer:

1. Why does a running program need memory?
2. What is the basic difference between CPU processing and memory?
3. What is runtime state?
4. How is a saved program file different from its running state?
5. In `int age = 22`, what do `int`, `age`, and `22` represent?
6. What happens conceptually during variable reassignment?
7. What happens when one primitive variable is assigned to another?
8. Why should I avoid treating a Java variable as a raw physical memory address?
9. Why can simplified memory diagrams be useful but also misleading?
10. How will memory concepts eventually connect to DSA space complexity?

---

## Key Takeaway

> A running program needs memory resources to maintain the data and state required during execution so that its instructions can process information and produce results.

For Java and DSA, start by reasoning about **values, state, relationships, and memory growth** rather than guessing exact physical memory locations.

---

**Next:** Variables & Values