object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val xs = Array.fill(N)(math.abs(in.nextLong))
  println(xs.sum)
  println(math.sqrt(xs.map(l => l * l).sum.toDouble))
  println(xs.max)
}
