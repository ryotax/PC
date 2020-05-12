object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = Array.fill(in.nextInt)

  val primes: List[Int] = ???
  def primeFactors(i: Int, ps: List[Int], factors: List[Int] = Nil): Map[Int, Int] = {
    if (i == 1) factors.groupBy(identity).mapValues(_.size)
    else if (i % ps.head == 0) primeFactors(i / ps.head, ps, ps.head :: factors)
    else primeFactors(i, ps.tail, factors)
  }
  val lcm = new MMap[Int, Int]().withDefault(0)

  val asFactors = As.map(primeFactors(_, primes))
  asFactors.foreach {case (n, count) => lcm.update(n, lcm.(n) max count)}
  asFactors.foldLeft(0L){(z, map) =>

}
