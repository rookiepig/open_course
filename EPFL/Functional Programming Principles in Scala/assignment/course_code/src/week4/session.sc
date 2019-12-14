import java.util.NoSuchElementException

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def + (that: Nat): Nat = {
    if (that.isZero) this
    else this.successor + that.predecessor
  }
  def - (that: Nat): Nat = {
    if (that.isZero) this
    else this.predecessor - that.predecessor
  }

  override def toString: String = "1 + " + n
}


object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nothing = throw new NoSuchElementException("0 has no predecessor")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = {
    if (that.isZero) this
    else throw new NoSuchElementException("0 cannot minus pos Nat")
  }

  override def toString: String = "0"
}


val one = Zero.successor
val two = one.successor
val three = two.successor

one + two
two + one
two + two
two + three

two - one
three - one
three - two
two - two
one - two


class IntSet
class NonEmpty(v: Int, l: IntSet, r: IntSet) extends IntSet
object Empty extends IntSet


trait Expr
case class Number(v: Int) extends Expr
case class Sum(l: Expr, r: Expr) extends Expr
case class Var(x: String) extends Expr
case class Prod(l: Expr, r: Expr) extends Expr

def addPara(x: String): String = {
  "( " + x + " )"
}

def show(e: Expr): String = e match {
  case Number(v) => v.toString
  case Var(x) => x
  case Sum(l, r) => show(l) + " + " + show(r)
  case Prod(l, r) => {
    val lStr = if (l.isInstanceOf[Sum]) addPara(show(l)) else show(l)
    val rStr = if (r.isInstanceOf[Sum]) addPara(show(r)) else show(r)
    lStr + " * " + rStr
  }
}

show(Sum(Sum(Number(1), Number(2)), Number(3)))

show(Sum(Prod(Number(2), Var("x")), Var("y")))
show(Prod(Sum(Number(2), Var("x")), Var("y")))



def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}


def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}

isort(List(2, 5, 7, 3, 9))

