object Main extends App {
  val in = new java.util.Scanner(System.in)
  val x = in.nextInt
  println(if (x < 0) 0 else x)
}
