import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextLong
  val ts = Array.fill(5)(sc.nextLong)
  println(5 + (n - 1) / ts.min)
}
