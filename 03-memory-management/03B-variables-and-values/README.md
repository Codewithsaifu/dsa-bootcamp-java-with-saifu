# 03B — Variables & Values

This module builds a precise understanding of Java variables, values, declared types, assignments, expressions, and primitive value copying.

The focus is on tracking program state correctly without assuming an exact physical memory layout.

## Learning Objectives

By the end of this module, I should be able to:

- distinguish a variable from its current value,
- identify a variable's declared type,
- explain declaration and initialization,
- distinguish assignment from reassignment,
- explain literals and expressions,
- understand local-variable definite assignment,
- explain primitive value copying,
- and manually track variable state during execution.

## Topics Covered

- Variables and values
- Declared types
- Declaration
- Initialization
- Assignment
- Reassignment
- Local variables and definite assignment
- Literals and expressions
- Primitive value copying
- Program-state tracking
- Common misconceptions

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

## Important Distinctions

```text
Variable ≠ Value

Declaration ≠ Initialization

Literal ≠ Every Value

Primitive Assignment ≠ Permanent Link

Assignment ≠ Method Argument Passing
```

## Primitive Assignment Example

```java
int a = 10;
int b = a;

a = 99;
```

Final state:

```text
a → 99
b → 10
```

When `b = a` executes, the primitive value is copied. Reassigning `a` later does not automatically modify `b`.

## Module Contents

### Detailed Notes

[`notes/variables-and-values.md`](notes/variables-and-values.md)

Detailed explanations of variables, values, types, declarations, initialization, assignment, literals, expressions, primitive copying, and state tracking.

### Visual Notes

[`notes/03b-1-variables-declaration-assignment.png`](notes/03b-1-variables-declaration-assignment.png)

Quick A4 notes covering variables, declared types, declaration, initialization, assignment, and reassignment.

[`notes/03b-2-literals-expressions-primitive-copy.png`](notes/03b-2-literals-expressions-primitive-copy.png)

Quick A4 notes covering literals, expressions, current state, and primitive value copying.

### Java Experiment

[`code/VariablesAndValues.java`](code/VariablesAndValues.java)

A small Java experiment demonstrating:

- declaration and assignment,
- reassignment,
- expression evaluation,
- primitive value copying,
- program-state changes.

### Quick Revision

[`revision/variables-and-values-revision.md`](revision/variables-and-values-revision.md)

Fast revision material containing key concepts, self-checks, and the actual prediction mistake discovered during learning.

## Learning Status

- [x] Learn
- [x] Understand Why
- [x] Concept Check
- [x] Predict
- [x] Dry Run
- [x] Java Experiment
- [x] Test
- [x] Explain in My Own Words
- [x] A4 Visual Notes
- [x] Detailed Documentation
- [x] Record Mistakes
- [x] Quick Revision
- [x] Git Review
- [x] Commit & Push

## Navigation

← Previous: [03A — Memory Basics](../03A-memory-basics/)

Next → **03C — Java Primitive Types**