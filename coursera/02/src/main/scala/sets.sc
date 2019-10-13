type Set = Int => Boolean

// 2.1

def contains(s: Set, x: Int): Boolean = s(x)

def singletonSet(member: Int): Set = x => (x == member)

def union(s: Set, t: Set): Set =
  x => (contains(s, x) || contains(t, x))

def intersect(s: Set, t: Set): Set =
  x => (contains(s, x) && contains(t, x))

def diff(s: Set, t: Set): Set =
  x => (contains(s, x) && !contains(t, x))

def filter(s: Set, p: Int => Boolean): Set =
  x => p(x)

// 2.2

val min = -1000
val max = 1000
def limitFn(x: Int): Boolean = x >= max

def forall(s: Set, p: Int => Boolean): Boolean = {
  @scala.annotation.tailrec
  def inForall(s: Set, p: Int => Boolean, x: Int): Boolean =
    if (contains(s, x) && !p(x)) false
    else (limitFn(x) || inForall(s, p, x + 1))

  inForall(s, p, min)
}

def exists(s: Set, p: Int => Boolean): Boolean = {
  @scala.annotation.tailrec
  def inExists(s: Set, p: Int => Boolean, x: Int): Boolean =
    if (contains(s, x) && p(x)) true
    else (!limitFn(x) && inExists(s, p, x + 1))

  inExists(s, p, min)
}

def map(s: Set, fn: Int => Boolean): Boolean = {
  def inMap(s: Set, fn: Int => Boolean, x: Int): Boolean =
    if (contains(s, x)) fn(x)
    else (limitFn(x) || inMap(s, fn, x + 1))

  inMap(s, fn, min)
}



//val s1 = singletonSet(1)
//val s2 = singletonSet(2)
//val s3 = singletonSet(3)
//
//val u = union(s1, s2)
//contains(u, 3)
//contains(u, 2)
//
//intersect(s1, s3)
//intersect(u, s3)
//val i = intersect(u, s1)
//
//contains(u, 2)
//contains(u, 3)
//contains(i, 2)
//
//forall(u, x => x > 0)
//exists(u, x => x == 1)

