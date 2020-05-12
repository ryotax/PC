object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Ps = Array.fill(N)(in.nextInt).sorted
  println(Ps.init.sum + Ps.last / 2)
}
