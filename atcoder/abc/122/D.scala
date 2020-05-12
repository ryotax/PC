object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val Mod = 1000000007L
  val A = 0
  val C = 1
  val G = 2
  val T = 3
  val dp = Array.ofDim[Long](n + 1, 4, 4, 4)
  dp(0)(T)(T)(T) = 1

  def valid(p3: Int, p2: Int, p1: Int, cur: Int): Boolean = (p3, p2, p1, cur) match {
    case (_, A, G, C) |
         (_, G, A, C) |
         (_, A, C, G) |
         (A, _, G, C) |
         (A, G, _, C) => false
    case _ => true
  }

  for {
    i <- (1 to n)
    p3 <- (A to T)
    p2 <- (A to T)
    p1 <- (A to T)
    cur <- (A to T)
    if (valid(p3, p2, p1, cur))
  } {
    dp(i)(p2)(p1)(cur) = (dp(i)(p2)(p1)(cur) + dp(i - 1)(p3)(p2)(p1)) % Mod
  }
  println(dp(n).flatten.flatten.sum % Mod)
}
