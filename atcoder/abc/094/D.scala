object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val as = Array.fill(N)(in.nextInt)

  val max = as.max
  val mid = max / 2.0
  println(s"$max ${as.filter(_ != max).minBy(a => math.abs(a - mid))}")
}
