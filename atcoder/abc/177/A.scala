object Main extends App {
  val in = new java.util.Scanner(System.in)
  val D, T, S = in.nextInt
  println(if (T * S >= D) "Yes" else "No")
}
