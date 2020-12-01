object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println(
    ((1 to N).map{i =>
      val a, b = in.nextLong
      (a + b) * (b - a + 1) / 2
    }).sum)
}
