import scala.io.StdIn._

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
