object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H = in.nextLong
  println((java.lang.Long.highestOneBit(H) << 1)  - 1)
}
