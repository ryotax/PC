object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, T, A = in.nextInt
  val Hs = Array.fill(N)(in.nextInt)
  println(Hs.map(x => math.abs(T - x * 0.006 - A)).zipWithIndex.minBy(_._1)._2 + 1)
}
