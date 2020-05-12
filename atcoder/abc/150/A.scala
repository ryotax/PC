object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K, X = in.nextInt
  println(if (K * 500 >= X) "Yes" else "No")
}

