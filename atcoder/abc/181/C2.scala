object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  case class P(x: Int, y: Int)
  val ps = Array.fill(N)(P(in.nextInt, in.nextInt))

  def linear(p1: P, p2: P, p3: P): Boolean = (p1.y - p2.y) * (p2.x - p3.x) == (p1.x - p2.x) * (p2.y - p3.y)

  val exists = ps.combinations(3).exists {case Array(p1, p2, p3) => linear(p1, p2, p3)}
  println(if (exists) "Yes" else "No")
}
