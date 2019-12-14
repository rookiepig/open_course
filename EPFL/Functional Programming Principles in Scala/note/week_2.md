# Week 2

## Function parameter

use *=>* operator

## Anonymous Functions

example:
```scala
(x: Int) => x * x * x
(x: Int, y: Int) => x + y
```
## Currying


### Multiple Parameter List

useful syntax sugar for high order function
```scala
def sum(f: Int => Int)(a: Int, b: Int): Int = xxx
```

by repeated using multiple parameter list, we have:
```scala
def f(args_1)...(args_n-1)(args_n) = E
```
is equivalent to:
```scala
def f = (args_1 => (args_2 => .. (args_n => E)))
```
This is *currying*

The essense of **high order functions** is to combine abstraction to
create new abstrations

## Scala Syntax

### Extended Backus-Naur Form (EBNF)
* **|** denotes an alternative
* **[...]** denotes an optional (0 or 1)
* **{...}** denotes a repetition (0 or more)

## Class

Scala class is Java class, so the private, overide, final are the same as Java.

The function  *require(condition, message)* like assertion, add restrictions on class member variables.

### require() v.s. assert()
* require() -- check the precondition
* assert()  -- check some status

### Primary Constructor

```scala
class XXX {
    def this() ...
}
```
* takes the parameter of the class
* executes all statements in the class body

### Operators

There are two ways:

* Infix Notation
```scala
r.add(s) --> r add s
```

* Operator Overloading like c++, for unary operator, add prefix *unary_*, like:
```scale
def unary_- : () = ....
```


