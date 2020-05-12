import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val hs = Array.fill(n)(sc.nextInt)
  val (max, count)  = hs.foldLeft(0, 0){case ((max, count), h) => if (max <= h) (h, count + 1) else (max, count)}
  println(count)
}
