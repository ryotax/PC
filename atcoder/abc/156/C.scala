object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Xs = Array.fill(N)(in.nextInt)
  val sumX = Xs.sum
  val sumSqX = Xs.map(x => x * x).sum
  val min = (1 to 100).map(p => -2 * p * sumX + p * p * N).min
  println(sumSqX + min)
}
