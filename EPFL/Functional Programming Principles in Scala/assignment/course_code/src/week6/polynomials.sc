import java.util.function.DoubleToLongFunction

class Poly(val terms0: Map[Int, Double]) {
  val terms = terms0 withDefaultValue 0.0
  /*
  def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    terms get exp match {
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp -> coeff
    }
  }
  */
  def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    val oldCoeff = terms(exp)
    terms + (exp -> (oldCoeff + coeff))
  }
  override def toString: String = {
    (for ((exp, coeff) <- terms.toList.sorted) yield coeff + "x^" + exp) mkString " + "
  }
}

val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
val p2 = new Poly(Map(0 -> 3, 3 -> 7.0))

p1 + p2