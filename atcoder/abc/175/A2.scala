object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  println(S.split("S", -1).map(_.size).max)
}
