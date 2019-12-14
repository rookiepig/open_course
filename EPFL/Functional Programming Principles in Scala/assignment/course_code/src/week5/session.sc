def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

init(List(1))
init(List(1, 2, 3, 4))

def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => throw new IndexOutOfBoundsException
  case y :: ys => {
    if (n < 0) throw new IndexOutOfBoundsException
    else if (n == 0) ys
    else y :: removeAt(n - 1, ys)
  }
}

removeAt(2, List(1, 2, 3, 4, 5))
removeAt(0, List(1, 2, 3, 4, 5))
removeAt(4, List(1, 2, 3, 4, 5))

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case y :: ys => {
    if (y.isInstanceOf[List[Any]]) flatten(y.asInstanceOf[List[Any]]) ::: flatten(ys)
    else {
      y :: flatten(ys)
    }
  }
}

flatten(List(1, List(1, 2), List(1, List(1, 2))))

val pair = ("haha", 1)


def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(x: List[T], y: List[T]): List[T] = {
      (x, y) match {
        case (x, Nil) => x
        case (Nil, y) => y
        case (x1 :: xs, y1 :: ys) => {
          if (ord.lt(x1, y1)) x1 :: merge(xs, y)
          else y1 :: merge(x, ys)
        }
      }
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

val nums = List(2, -4, 1, 3, 7, -8)
msort(nums)

def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => List()
    case y :: ys => y * y :: squareList(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)

squareList(nums)
squareList2(nums)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => {
    val (fst, snd) = xs span (y => (y == x))
    fst :: pack(snd)
  }
}

val data = List("a", "a", "a", "b", "c", "c", "a")
pack(data)

def encode[T](xs: List[T]): List[(T, Int)] = {
  pack(xs) map (x => (x.head, x.length))
}
encode(List("a", "a", "a", "b", "c", "c", "a"))

1 :: 2 :: List(3)
(1 :: List(2)) :: List(3)