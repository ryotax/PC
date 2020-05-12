import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val as = Array.fill(5)(sc.nextInt)
  val k = sc.nextInt
  println(if (as.max - as.min <= k) "Yay!" else ":(")
}
