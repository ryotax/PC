object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  case class Cake(x: Long, y: Long, z: Long)
  val cakes = Array.fill(N)(Cake(in.nextLong, in.nextLong, in.nextLong))

  def calc(f: Cake => Long): Long = cakes.map(f).sorted.reverse.take(M).sum

  println(
    calc(c =>  c.x + c.y + c.z) max
    calc(c =>  c.x + c.y - c.z) max
    calc(c =>  c.x - c.y + c.z) max
    calc(c =>  c.x - c.y - c.z) max
    calc(c => -c.x + c.y + c.z) max
    calc(c => -c.x + c.y - c.z) max
    calc(c => -c.x - c.y + c.z) max
    calc(c => -c.x - c.y - c.z)
  )
}

