object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  println(S.sliding(3).map(_.toInt).map(i => Math.abs(i - 753)).min)
}
