object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println((1 to N).map(_ => Integer.numberOfTrailingZeros(in.nextInt)).sum)
}
