
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val List(s, m, l) = List.fill(3)(in.nextInt).sorted
  val d = 2 * l - m - s
  println(d / 2 + (if (d % 2 == 0) 0 else 1))
}
