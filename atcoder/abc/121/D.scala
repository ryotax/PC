object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val a, b = sc.nextLong

  val firstBit = {
    val nums = b - a + 1
    val evens = if (a % 2 == 1) (nums + 1) / 2 else nums / 2
    evens % 2
  }
  val ans = (1 to 40).foldLeft(firstBit.toLong){(z, s) =>
    val aBits =
      if (((1L << s) & a) == 0) 0
      else (1L << (s + 1)) - (a & (-1L >>> (63 - s)))

    val bBits =
      if (((1L << s) & b) == 0) 0
      else (b & (-1L >>> (64 - s))) + 1

    if ((aBits + bBits) % 2 == 0) z else z + (1L << s)
  }

  println(ans)
}
