object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextInt)
  println((2 to 1000).maxBy(i => As.count(_ % i == 0)))
}
