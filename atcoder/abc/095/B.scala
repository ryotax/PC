object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, X= in.nextInt
  val ms = Array.fill(N)(in.nextInt)

  println((X - ms.sum) / ms.min + ms.size)
}
