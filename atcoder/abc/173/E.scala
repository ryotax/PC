object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val As = List.fill(N)(in.nextLong)
  val Mod = 1_000_000_007L

  val (negas, notNegas) = As.sorted.span(_ < 0)

  def print(s: List[Long]): Unit = {
    val a = s.foldLeft(1L){(p, i) => p * i % Mod}
    println(if (a < 0) Mod + a else a)
  }

  if (notNegas.isEmpty) print(negas.reverse.take(K))
  else {
    def take(ns: List[Long], ps: List[Long], k: Int): List[Long] = {
    }
  }
}
