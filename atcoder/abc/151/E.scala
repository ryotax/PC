object Main extends App {
  val Mod = 1000000007L
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val As = in.nextInt.split(" ").map(_.toInt).sorted
  val modulo = new Modulo(N, Mod)
  val sums = for {
    l <- 0 to N - K
    r <- (l + K - 1) to N - 1
  } yield {
    val f = As(r) - As(l)
    f * modulo.nCr(r - l - 1, K - 2) % Mod
  }

  println(sums.foldLeft(0L)((z, s) => (z + s) % Mod))
}

class Modulo(n: Int, mod: Long) {
  private val invs = new Array[Long](n + 1)
  invs(1) = 1
  (2 to n).foreach {i =>
    invs(i) = mod - (mod / i) * invs((mod % i).toInt) % mod
  }

  private val factorials = new Array[Long](n + 1)
  factorials(0) = 1
  (1 to n).foreach{i =>
    factorials(i) = factorials(i - 1) * i % mod
  }

  private val invFactorials = new Array[Long](n + 1)


  def nCr(n: Int, r: Int): Long = {
    val numer = (n - r + 1 to n).foldLeft(1L)((z, i) => z * i % mod)
    (2 to r).foldLeft(numer)((z, i) => invs(i) * z % mod)
  }
}

