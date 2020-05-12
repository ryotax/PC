object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val As = Array.fill(N)(in.nextLong)

  println(As.map(java.lang.Long.lowestOneBit).distinct.size match {
    case 1 => As.reduceLeft(lcm) match {
        case 0 => 0
        case m => (M / (m / 2) + 1) / 2
      }
    case _ => 0
  })

  def lcm(l: Long, r: Long): Long = {
    val ret = (l * r / gcd(l, r))
    if (ret > M * 2) 0 else ret
  }

  def gcd(l: Long, r: Long): Long = if (l % r == 0) r else gcd(r, l % r)
}
