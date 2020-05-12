object Main extends App {
  val in = new java.util.Scanner(System.in)
  val _, S = in.next
  println(S.split("ABC", -1).size - 1)
}
