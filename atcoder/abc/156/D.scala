object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, A, B = in.nextInt
  val Mod = 1000000007


  def nCk(n: Int, k: Int): BigInt = {
    val numer = (n - k + 1 to n).foldLeft(1L)((z, i) => z * i % Mod)
    (2 to k).foldLeft(BigInt(numer))((z, i) => BigInt(i).modInverse(Mod) * z % Mod)
  }

  def powMod(base: Int, pow: Int): Int = {
    @scala.annotation.tailrec
    def powMod0(base: Long, pow: Int, mul: Long): Long = {
      if (pow == 1) base * mul % Mod
      else powMod0(base * base % Mod, pow / 2, mul * (if ((pow & 1) == 1) base else 1) % Mod)
    }
    powMod0(base, pow, 1).toInt
  }

  println((Mod.toLong * 2 + powMod(2, N) - nCk(N, A) - nCk(N, B) - 1) % Mod)
}

