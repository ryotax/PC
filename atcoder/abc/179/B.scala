object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val doubles = Array.fill(N)(in.nextInt == in.nextInt)
  println(if (doubles.sliding(3).exists(_.forall(identity))) "Yes" else "No")
}
