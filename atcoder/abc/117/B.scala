object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt
  val ls = Array.fill(n)(in.nextInt).sorted
  println(if (ls.last < ls.init.sum) "Yes" else "No")
}
