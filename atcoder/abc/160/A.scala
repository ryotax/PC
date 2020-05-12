object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  val coffee = S.charAt(2) == S.charAt(3) && S.charAt(4) == S.charAt(5)
  println(if (coffee) "Yes" else "No")
}
