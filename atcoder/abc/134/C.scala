import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val as = Array.fill(n)(readInt)
  val sorted = as.sorted
  val max = sorted(n - 1)
  val second = sorted(n - 2)

  val pw = new java.io.PrintWriter(System.out)
  as.foreach {a => pw.println(if (a == max) second else max)}
  pw.flush()
}
