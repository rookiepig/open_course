package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || r <= 1 || c >= r) {
      1
    } else {
      pascal(c, r- 1) + pascal(c - 1, r - 1)
    }
  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceExtra(chars: List[Char], left_par_count: Int): Boolean =
      if (chars.isEmpty) {
        if (left_par_count == 0) {
          return true
        } else {
          return false
        }
      } else {
        if (chars.head == '(') {
          balanceExtra(chars.tail, left_par_count + 1)
        } else if (chars.head == ')') {
          if (left_par_count == 0) {
            return false
          } else {
            return balanceExtra(chars.tail, left_par_count - 1)
          }
        } else {
          return balanceExtra(chars.tail, left_par_count)
        }
      }

    balanceExtra(chars, 0)
  }


  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeSorted(money: Int, coins: List[Int]): Int = {
      if (money == 0) {
        return 1
      } else {
        if (coins.isEmpty) {
          return 0
        } else {
          var count = 0
          if (money >= coins.head) {
            count += countChangeSorted(money - coins.head, coins)
          }
          return count + countChangeSorted(money, coins.tail)
        }
      }
    }
    return countChangeSorted(money, coins.sorted)
  }
}
