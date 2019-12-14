import scala.annotation.tailrec

def abs(x:Double) = if (x < 0) -x else x


def isGoodEnough(guess: Double, x: Double) = {
  abs(guess * guess - x) / x < 0.000001
}

def improve(guess: Double, x: Double) = (guess + x / guess) / 2

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)


def sqrt(x: Double) = sqrtIter(1.0, x)

sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)

def factorial(n: Int) = {
  @tailrec
  def tail_fact(n: Int, cum: Int): Int = {
    if (n == 0)
      cum
    else
      tail_fact(n - 1, n * cum)
  }
  tail_fact(n, 1)
}

factorial(4)