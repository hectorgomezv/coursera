package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("(just an) example".toList)
    println(balance("((just an)) e(x(a)mple".toList))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceIter(chars: List[Char], openings: Int): Boolean = {
        if (chars.isEmpty && openings == 0) true
        else if (chars.isEmpty && openings != 0) false
        else if (chars.head == '(') balanceIter(chars.tail, openings + 1)
        else if (chars.head == ')') balanceIter(chars.tail, openings - 1)
        else balanceIter(chars.tail, openings)
      }
      balanceIter(chars, 0);
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
