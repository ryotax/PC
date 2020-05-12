import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n, m = sc.nextInt
  val gates: Array[(Int, Int)] = Array.fill(m)((sc.nextInt, sc.nextInt))
  val (l, r) = gates.foldLeft((0, Int.MaxValue)){case ((maxL, minR), (l, r)) => (maxL max l, minR min r)}
  println(if (r < l) 0 else r - l + 1)
}
