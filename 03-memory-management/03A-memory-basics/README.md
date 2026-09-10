# 03A — Memory Basics

A foundational introduction to memory from a Java and DSA perspective.

This module focuses on understanding why a running program needs memory, how program state changes during execution, and how to reason about variables and values without making unnecessary assumptions about physical memory layout.

## Learning Objectives

By the end of this module, I should be able to:

- explain why a running program needs memory,
- describe the basic relationship between data, state, processing, and results,
- distinguish the roles of CPU and memory at a conceptual level,
- explain runtime state,
- distinguish a variable from its current value,
- explain reassignment,
- predict primitive value-copy behavior,
- and avoid treating Java variables as raw physical memory addresses.

## Topics Covered

- Memory fundamentals
- Why programs need memory
- Runtime state
- CPU vs memory
- Persistent storage vs running state
- Variables, types, and values
- Reassignment
- Primitive assignment — introductory preview
- Memory addresses — conceptual introduction
- Common beginner misconceptions

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

The focus is on understanding what information a program needs to maintain rather than guessing the exact physical location of every value.

## Example

```java
int score = 50;
score = score + 10;
```

Conceptually:

```text
score → 50
        ↓
      + 10
        ↓
score → 60
```

The current value is used during processing, and the program state is then updated.

## Module Contents

### Detailed Notes

[`notes/memory-basics.md`](notes/memory-basics.md)

Detailed explanation of memory basics, runtime state, variables, values, reassignment, and important memory-model precautions.

### Visual Notes

[`notes/memory-basics.png`](notes/memory-basics.png)

A4 visual notes for quick concept recall.

### Java Experiment

[`code/MemoryBasics.java`](code/MemoryBasics.java)

A small Java experiment demonstrating:

- runtime state changes,
- reassignment,
- variable values,
- primitive value copying.

### Quick Revision

[`revision/memory-basics-revision.md`](revision/memory-basics-revision.md)

Short revision material containing the core mental model, key takeaways, self-check questions, and mistakes identified during learning.

## Important Distinctions

```text
Variable ≠ Value

Saved Program File ≠ Running Program State

Primitive Assignment ≠ Method Argument Passing

Java Variable ≠ Raw C/C++ Pointer
```

Simplified memory diagrams are useful for reasoning, but they should not automatically be interpreted as exact JVM or physical-memory layouts.

## Learning Status

- [x] Learn
- [x] Understand Why
- [x] Concept Check
- [x] Predict
- [x] Dry Run
- [x] Java Experiment
- [x] Test
- [x] Explain in My Own Words
- [x] Document
- [x] Record Mistakes
- [x] Quick Revision
- [x] Git Review
- [x] Commit & Push

## Next

Continue to:

**03B — Variables & Values**