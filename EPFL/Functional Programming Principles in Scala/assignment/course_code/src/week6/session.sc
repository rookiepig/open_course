val xs = Array(1, 2, 3, 44)


(1 to 3) flatMap (x => ((1 to 5) map (y => (x, y))))

def isPrime(n: Int): Boolean = {
  (2 until n) forall (x => (n % x) != 0)
}

isPrime(3)
isPrime(6)
isPrime(13)

val n = 7

(1 until n) flatMap  (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

def queens(n: Int): Set[List[Int]] = {
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens
    queensWithRow forall {
      case (r, c) => col != c && math.abs(col - c) != row - r
    }
  }
  def placeQueens(k: Int): Set[List[Int]] = {
    if (k == 0) Set(List())
    else
      for {
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      } yield col :: queens
  }
  placeQueens(n)
}

def show(queens: List[Int]): String = {
  val lines =
    for (col <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString

  "\n" + (lines mkString "\n")
}

//(queens(8) take 3 map show) mkString "\n"

