object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(N)(in.nextLong)
  println(As.foldLeft((0L, 0L)){case ((sum, pre), cur) => if (pre > cur) (sum + pre - cur, pre) else (sum, cur)}._1)
}
