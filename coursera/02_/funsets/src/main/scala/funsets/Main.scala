package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)

  val u = union(s1, s2)
  contains(u, 3)
  contains(u, 2)

  intersect(s1, s3)
  intersect(u, s3)
  val i = intersect(u, s1)

  println(contains(u, 2))
  println(contains(u, 3))
  println(contains(i, 2))

  println(forall(u, x => x > 0))
  println(exists(u, x => x == 1))
  printSet(u)
  val u2 = map(u, x => x * 4)
  printSet(u2)
}
