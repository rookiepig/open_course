# Week 1

A theory does not allow mutation!

## Substitution Model

reduce the expression to a value, applied to expressions 
as long as they do not have **side effects**.

## Evaluation Strategy

*call-by-value* v.s. *call-by-name*:
* call by value --> evaluates every argument only once
* call by name --> unused arguments are not evaluated

*call-by-value* termination implies *call-by-name*'s termination,
the reverse is not true.

Scala normally adopts *call-by-value*
**hint: using *=>* enforces *call-by-name* **

## val v.s. def
def is *by-name*
val is *by-value*
```scala
val y = square(2)
```
## Square Root
for recursive function, must specify the return type.

## Nested Function
put the function inside another function.

## Multiline Expression
1. using parentheses
2. ending line with operator

## Tail Recursion
Tail recursion can be wrote as iterative process.

