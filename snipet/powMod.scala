def powMod(base: Int, pow: Int, mod: Int): Int = {
  @scala.annotation.tailrec
  def powMod0(base: Long, pow: Int, mul: Long): Long = {
    if (pow == 1) base * mul % mod
    else powMod0(base * base % mod, pow / 2, mul * (if ((pow & 1) == 1) base else 1) % mod)
  }
  powMod0(base, pow, 1).toInt
}

val Mod = 1_000_000_007
println(powMod(5, 3, Mod))
println(powMod(5, 3, 10))
println(powMod(5, 30, Mod))
println(powMod(2, 29, Mod))
println(powMod(2, 29, 100))
println(1 << 29)
