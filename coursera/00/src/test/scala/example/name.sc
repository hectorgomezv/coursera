def abs(x: Double) = if (x < 0) -x else x

def isGoodEnough(guess: Double, x: Double): Boolean =
  abs((guess * guess) - x) < x / 1000

def improve(guess: Double, x: Double): Double =
  (guess + x / guess) / 2

def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def sqrt(x: Double): Double = sqrtIter(1.0, x)

sqrt(0.001)
sqrt(1e-20)
sqrt(1e20)
sqrt(1e50)