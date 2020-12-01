object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.next
  println(if (N.toSeq.map(_ - '0').sum % 9 == 0) "Yes" else "No")
}

