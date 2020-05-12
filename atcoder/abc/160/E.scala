import scala.math._
object Main extends App {
  val in = new java.util.Scanner(System.in)

  val Array(x, y, _, _, _) = in.nextLine.split(" ").map(_.toInt)
  val As, Bs, Cs = in.nextLine.split(" ").map(_.toLong)
  println((As.sorted.takeRight(x) ++ Bs.sorted.takeRight(y) ++ Cs).sorted.takeRight(x + y).sum)
}
