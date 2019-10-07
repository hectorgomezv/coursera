package example

object Session extends App {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs((guess * guess) - x) < 0.001

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2

  def sqrt(x: Double): Double = sqrtIter(1.0, x)

  println(sqrt(2))

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n -1)

    loop(1, n)
  }

  println(factorial(4))
}
