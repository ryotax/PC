object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextInt)
  println(As.zipWithIndex.count{case (n, i) => n % 2 == 1 && i % 2 == 0})
}
