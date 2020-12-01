object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  case class P(x: Int, y: Int) {
    val z = x + y
    val w = x - y
  }
  val ps = Array.fill(N)(P(in.nextInt, in.nextInt))
  val orderZ = ps.map(_.z).sorted
  val orderW = ps.map(_.w).sorted
  println(math.max(orderZ.last - orderZ.head, orderW.last - orderW.head))
}
