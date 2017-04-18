def odds(l: Long) = (l & 1L) == 1
def positions(k: Long, c: Int): Seq[Long] = {
  val kc = BigInt(k).pow(c - 1).toLong
  (1L to k) withFilter {odds} map {i => kc * (i - 1) + 2 * i}
}


def exec(k: Int, c: Int, s: Int): String = {
  if (s * 2 < k) "IMPOSSIBLE"
  else positions(k, c).mkString(" ")
}

val n = readInt
(1 to n) foreach {i =>
  val Array(k, c, s) = readLine.split(" ") map {_.toInt}
  println(s"Case #${i}: ${exec(k, c, s)}")
}


GGG GGGGGGGGG GGGGGGGGGGGGGGGGGGGGGGGGGGG
GGL GGGGGGGGL GGGGGGGGGGGGGGGGGGGGGGGGGGL
GLG GGGGLGGGG GGGGGGGGGGGGGLGGGGGGGGGGGGG
LGG LGGGGGGGG LGGGGGGGGGGGGGGGGGGGGGGGGGG
GLL GGGGLLGLL GGGGGGGGGGGGGLLGLLGGGGLLGLL
LGL LGLGGGLGL LGLGGGLGLGGGGGGGGGLGLGGGLGL
LLG LLGLLGGGG LLGLLGGGGLLGLLGGGGGGGGGGGGG
LLL LLLLLLLLL LLLLLLLLLLLLLLLLLLLLLLLLLLL
 
