import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val as = Array.fill(n)(sc.nextLong)
  val abss = as.map(Math.abs)

  println(if (as.count(_ < 0) % 2 == 0) abss.sum else abss.sum - abss.min * 2)
}
