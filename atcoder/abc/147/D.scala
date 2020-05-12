import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val as = Array.fill(n)(sc.nextLong)
  val counts = new Array[Long](60)
  val Mod = 1000000007L

  for (a <- as; no <- 0 until 60) counts(no) += (if ((a & (1L << no)) != 0) 1 else 0)
  println(counts.zipWithIndex.foldLeft(0L){case (z, (c, i)) => (z + (c * (n - c) % Mod) * ((1L << i) % Mod)) % Mod})
}
