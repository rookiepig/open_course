val a = "abacabcd" groupBy  (ch => ch.toLower)

(a map ({case (ch, str) => (ch, str.length)})).toList.sorted

type Occurrences = List[(Char, Int)]
def combinations(occurrences: Occurrences): List[Occurrences] = occurrences match {
  case Nil => List(List())
  case x :: xs => {
    val (ch, n) = x
    combinations(xs) flatMap (occ => (0 to n map (i => if (i == 0) occ else (ch, i) :: occ)).toList)
  }
}

combinations(List(('a', 2), ('b', 2)))

def subtract(x: Occurrences, y: Occurrences): Occurrences = {
  val yMap = y.toMap withDefaultValue 0
  x map {
    case (ch, n) => (ch, n - yMap(ch))
  } filter {
    case (_, n) => n > 0
  }
}

subtract(List(('a', 2), ('b', 3)), List(('a', 2), ('b', 3)))

for (i <- List(1, 2, 3)) yield {List(List(i))}.flatten

val x = List(List(1), List(2), List(3))
val y = List(List(4), List(5), List(6))
x.flatten
x ++ y

combinations(List(('a', 2), ('b', 2)))
combinations(List(('a', 2), ('c', 2)))