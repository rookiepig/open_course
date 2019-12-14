def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

sum(x => x * x * x)(1, 2)

def product(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) * acc)
  }
  loop(a, 1)
}

def mapReduce(map: Int => Int, reduce: (Int, Int) => Int, init: Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, reduce(map(a), acc))
  }
  loop(a, init)
}

def productOp(f: Int => Int)(a: Int, b: Int): Int = {
  mapReduce(f, (x, y) => x * y, 1)(a, b)
}
def sumOp(f: Int => Int)(a: Int, b: Int): Int = {
  mapReduce(f, (x, y) => x + y, 0)(a, b)
}

product(x => x)(1, 4)
sum(x => x)(1, 4)


productOp(x => x)(1, 4)
sumOp(x => x)(1, 4)
