object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextInt)

  val map = (0 until N)
    .map(i => i - As(i))
    .filter(_ > 0)
    .groupBy(identity)
    .view.mapValues(_.size.toLong).toMap
    .withDefaultValue(0L)

  println((0 until N).map(i => map(i + As(i))).sum)
}
