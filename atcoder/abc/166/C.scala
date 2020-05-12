import math._
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val Hs = Array.fill(N)(in.nextInt)
  val roots = Array.fill(M)((in.nextInt - 1, in.nextInt - 1))

  val lookouts = Array.fill(N)(true)
  roots.foreach{case (a, b) =>
    if (Hs(a) <= Hs(b)) lookouts(a) = false
    if (Hs(a) >= Hs(b)) lookouts(b) = false
  }
  println(lookouts.count(identity))
}
