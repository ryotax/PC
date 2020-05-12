object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S, T = in.next
  println(if (T.startsWith(S)) "Yes" else "No")
}
