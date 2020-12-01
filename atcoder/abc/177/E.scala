import scala.collection.mutable.{Set => MSet}
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = List.fill(N)(in.nextInt)

  val minPrimes = new Array[Int](1_000_001)
  (2 to 1_000_000).foreach {p =>
    if (minPrimes(p) == 0) {
      minPrimes(p) = p
      (p until 1_000_000 by p).foreach {i => if (minPrimes(i) == 0) minPrimes(i) = p}
    }
  }

  def pairwise(): Boolean = {
    val set = MSet[Int]()

    @scala.annotation.tailrec
    def check(as: List[Int]): Boolean = as match {
      case Nil => true
      case x :: xs =>
        checkFactors(x) && check(xs)
    }

    @scala.annotation.tailrec
    def checkFactors(v: Int, prev: Int = 0): Boolean = {
      v == 1 || {
        val p = minPrimes(v)
        (p == prev || set.add(p)) && checkFactors(v / p, p)
      }
    }

    check(As)
  }

  def setwise(): Boolean = {
    def gcd(l: Int, r: Int): Int = if (r == 0) l else gcd(r, (l % r))
    As.reduceLeft(gcd) == 1
  }

  println(
    if (pairwise()) "pairwise coprime"
    else if (setwise()) "setwise coprime"
    else "not coprime"
  )
}


