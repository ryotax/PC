object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S, T = in.next
  println(S.zip(T).count{case (s, t) => s != t})
}
