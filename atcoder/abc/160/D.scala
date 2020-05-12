import scala.math._
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, X, Y = in.nextInt
  val counts = Array.fill(N + 1)(0)
  for {
    s <- 1 to N - 1
    e <- s + 1 to N
  } counts(min(e - s, abs(X - s) + abs(Y - e) + 1)) += 1

  println(counts.tail.init.mkString("\n"))
}
