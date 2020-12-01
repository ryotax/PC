object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val As = Array.fill(N)(in.nextDouble)

  def cuts(orig: Double, max: Int): Double = (orig / max).ceil - 1

  def binSearch(min: Int, max: Int, cur: Int): Int = {
    if (min + 1 == max) max
    else {
      val totalCuts = As.map(cuts(_, cur)).sum
      if (totalCuts > K) binSearch(cur, max, (cur + max) / 2)
      else binSearch(min, cur, (min + cur) / 2)
    }
  }

  println(binSearch(0, 1_000_000_000, 500_000_000))
}
