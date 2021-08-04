# Basic Query Engine

---

## TODO

Cannot compare literals to fields because of the different column types. 

## Types
- Bool
- Varchar
- Numeric

## SQL Subset

## Terms
- Column
- Identifier
- Field
- Row
- Batch
- Expression
- LogicalPlan
- PhysicalPlan
- Schema

----

## Operations

### Standard Algebraic (Bag) Operations
- Selection
- Projection
- Join
- Renaming
- Union
- Difference
- Intersection

### Extended Operations
- Duplicate Elimination
- Aggregate Expressions
- Grouping
- Projection with Expressions
- Sorting
- Natural and Theta Outer Joins (Left/Right)

---

## Problems

- Type inference is hard. It's difficult for me to dynamically create and use generic operations in a statically typed language.
