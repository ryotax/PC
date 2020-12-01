object Main extends App {
  val in = new java.util.Scanner(System.in)
  val Array(a, b, c, d) = Array.fill(4)(in.nextInt).sorted
  println(if (a + d == b + c || a + b + c == d) "Yes" else "No")
}
