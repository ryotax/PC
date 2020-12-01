import math.abs
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, C, D = in.nextInt

  println(
    if (abs(A - C) <= D || (abs(A - B) <= D && abs(B - C) <= D)) "Yes"
    else "No"
  )
}
