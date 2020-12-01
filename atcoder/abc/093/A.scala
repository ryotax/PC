object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next

  println(if (S.sorted == "abc") "Yes" else "No")
}
