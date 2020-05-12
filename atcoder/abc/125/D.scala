import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val as = Array.fill(n)(sc.nextInt)

  def dp(flipped: Long, notFlipped: Long, i: Int): Long = {
    if (i == n - 1) Math.max(flipped, notFlipped)
    else {
      dp(
        Math.max(flipped + 2 * as(i) - as(i + 1),
              notFlipped - 2 * as(i) - as(i + 1)),
        Math.max(flipped + as(i + 1),
              notFlipped + as(i + 1)),
        i + 1)
    }
  }

  println(dp(-(as(0) + as(1)), as(0) + as(1), 1))
}
