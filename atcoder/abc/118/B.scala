object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n, m = in.nextInt
  val ks = Array.fill(n)(Array.fill(in.nextInt)(in.nextInt))
  println(ks.reduceLeft((z, k) => z.intersect(k)).size)
}
