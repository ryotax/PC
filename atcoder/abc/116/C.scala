object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Ks = Array.fill(N)(in.nextInt)

  val (sum, _) = Ks.foldLeft((0, 0)){case ((sum, pre), h) => if (pre < h) (sum + (h - pre), h) else (sum, h)}
  println(sum)
}
