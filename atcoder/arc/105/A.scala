object Main extends App {
  val in = new java.util.Scanner(System.in)
  val l = Array.fill(4)(in.nextDouble)
  println(if ((1 to 2).exists(i => l.combinations(i).exists(_.sum == l.sum / 2))) "Yes" else "No")
}
