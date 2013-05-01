import scala.io.Source
import scala.annotation.tailrec
import scala.math.BigInt

val input = Source.fromFile("A-large.in").getLines
                                        .toList
                                        .tail
                                        .zipWithIndex
                                        .foreach {
                                          case (q, i) =>
                                            val s = q.split(" ")
                                            println("Case #" + (i + 1) + ": " + search(BigInt(s(0)), BigInt(s(1))))
                                        }


def search(r: BigInt, p: BigInt) = {
  @tailrec
  def binsearch(n: BigInt, max: BigInt, min: BigInt): BigInt = {
    area(r, n) match {
      case a if a <= p && area(r, n + 1) > p => n
      case a if a <= p => binsearch(n + (max - n) / 2, max, n)
      case a if a > p => binsearch(n - (n - min) / 2, n, min)
    }
  }

  binsearch(BigInt(scala.math.sqrt(p.doubleValue).longValue), p, 0)
}
  
def area(r: BigInt, n: BigInt) = n * (2 * r + 2 * n - 1)

