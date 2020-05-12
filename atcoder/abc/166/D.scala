import math._
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X = in.nextInt

  val (a, b) = (for {
    a <- -200L to 200L
    b <- -200L to 200L
    if (a*a*a*a*a - b*b*b*b*b == X)
  } yield (a, b)).head

  println(s"${a} ${b}")
}
