object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A, B, K = in.nextInt

  println(((A to B).take(K) ++ (A to B).takeRight(K)).toSet.toList.sorted.mkString("\n"))
}
