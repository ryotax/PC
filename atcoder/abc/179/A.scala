object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  println(S + (if (S.last == 's') "es" else "s"))
}

