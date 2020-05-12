object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  println(if (S.distinct.size == 1) "No" else "Yes")
}
