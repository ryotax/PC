object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S, T = in.next
  val A, B = in.nextInt
  val U = in.next
  println(s"${A - (if (S == U) 1 else 0)} ${B - (if (T == U) 1 else 0)} ")
}
