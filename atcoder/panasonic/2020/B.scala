object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, W = in.nextLong
  println(if (H == 1 || W == 1) 1 else (H * W  + 1) / 2)
}
