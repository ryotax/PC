import scala.io.StdIn
object Main extends App {
  val n = StdIn.readInt
  val as = (1 to n).map(i => StdIn.readLong).sorted.toArray
  def sum(begin: Int, end: Int) = (begin to end).map(i => as(i)).sum

  val m = n / 2
  println(if (n % 2 == 1) {
    (sum(m + 2, n - 1) * 2 + as(m + 1)) - (sum(0, m - 2) * 2 + as(m - 1)) +
    Math.max(as(m + 1) - as(m), as(m) - as(m - 1))
  } else {
    (sum(m + 1, n - 1) * 2 + as(m)) - (sum(0, m - 2) * 2 + as(m - 1))
  })
}
