object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val primes: Stream[Int] = 2 #:: (Stream.from(3, 2) filter {n =>
    primes takeWhile {_ <= Math.sqrt(n).toInt} forall {n % _ != 0}
  })
  val ps = primes.takeWhile(_ <= N).toArray
  val pNums = new Array[Int](ps.size)

  def divide(i: Int, n: Int): Unit = {
    if (i < ps.size) {
      if (n % ps(i) == 0) {
        pNums(i) += 1
        divide(i, n / ps(i))
      } else divide(i + 1, n)
    }
  }

  (2 to N).foreach(divide(0, _))

  def n(i: Int) = pNums.count(_ >= i - 1)

  println(
    n(5) * (n(5) - 1) / 2 * (n(3) - 2) +
    n(15) * (n(5) - 1) +
    n(25) * (n(3) - 1) +
    n(75))
}
