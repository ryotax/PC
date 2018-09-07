import scala.io.StdIn._
object Main extends App {
  val primeFactors = count(factorization(readLong)).toList
  println(search(primeFactors map {case (p, n) => products(p, n)}))

  @scala.annotation.tailrec
  def factorization(n: Long, cur: Long = 2, results: List[Long] = Nil): List[Long] = {
    if (cur * cur > n) {
      if (n == 1) results else n :: results
    } else {
      if (n % cur == 0) factorization(n / cur, cur, cur :: results)
      else factorization(n, cur + (if (cur == 2) 1 else 2), results)
    }
  }

  def count(primes: List[Long]): Map[Long, Int] = primes.groupBy(identity(_)) mapValues {_.size}
  def products(p: Long, n: Int): List[(Long, Long)] = ((0 to n) map {i => (pow(p, i), pow(p, n - i))}).toList
  def pow(p: Long, n: Int) = scala.math.pow(p, n).toLong
  def maxSize(lhs: Long, rhs: Long) = lhs.toString.size max rhs.toString.size

/*
  def search(lists: List[List[(Long, Long)]], cur: (Long, Long) = (1, 1)): List[(Long, Long)] = {
    lists match {
      case x :: Nil => x map {case (lhs, rhs) => (cur._1 * lhs, cur._2 * rhs)}
      case x :: xs => x flatMap {case (lhs, rhs) => search(xs, (cur._1 * lhs, cur._2 * rhs))}
      case Nil => List((0L, 0L))
    }
  }
*/
  def search(lists: List[List[(Long, Long)]], cur: (Long, Long) = (1, 1)): Long = {
    lists match {
      case x :: Nil => (x map {case (lhs, rhs) => maxSize(cur._1 * lhs, cur._2 * rhs)}).min
      case x :: xs => (x map {case (lhs, rhs) => search(xs, (cur._1 * lhs, cur._2 * rhs))}).min
      case Nil => 0L
    }
  }
}
