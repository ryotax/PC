import scala.math.sqrt
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C = in.nextLong
  val b = (C - A - B) match {
    case n if n < 0 => false
    case n => 4 * A * B < n * n
  }
  println(if (b) "Yes" else "No")
}
