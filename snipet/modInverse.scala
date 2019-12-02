val Mod = 1000000007

// BigIntにmodInverseが用意されてるのでそれを利用する
{
  def nCk(n: Int, k: Int): BigInt = {
    val numer = (n - k + 1 to n).foldLeft(1L)((z, i) => z * i % Mod)
    (2 to k).foldLeft(BigInt(numer))((z, i) => BigInt(i).modInverse(Mod) * z % Mod)
  }

  println((50 to 100).map(i => nCk(i, i / 2)))
}

// Nの最大値があまり大きくなく、繰り返し計算を求められる場合、先に計算しておく
{
  val N = 2000
  val invs = new Array[Long](N + 1)
  invs(1) = 1
  (2 to N).foreach {i =>
    invs(i) = Mod - (Mod / i) * invs((Mod % i).toInt) % Mod
  }

  def nCk(n: Int, k: Int): Long = {
    val numer = (n - k + 1 to n).foldLeft(1L)((z, i) => z * i % Mod)
    (2 to k).foldLeft(numer)((z, i) => invs(i) * z % Mod)
  }

  println((50 to 100).map(i => nCk(i, i / 2)))
}
