object Main extends App {
  val in = new java.util.Scanner(System.in)
   val S, W = in.nextInt
  println(if (S <= W) "unsafe" else "safe")
}
