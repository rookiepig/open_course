
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}


class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

def nth[T](n: Int, list: List[T]): T = {
  def iter(i: Int, list: List[T]): T = {
    if (list.isEmpty)
      throw new IndexOutOfBoundsException("index " + n + " out of list")
    else if (i == n)
      list.head
    else iter(i +1, list.tail)
  }
  iter(0, list)
}

val nil_list = new Nil[Int]

val list_1 = new Cons[Int](3, nil_list)
val list_2 = new Cons[Int](4, list_1)

nth(0, list_1)
nth(0, list_2)
nth(1, list_2)
nth(2, list_2)
