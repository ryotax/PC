import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n, k = sc.nextInt
  val s = sc.next
  println(s.updated(k -1, s.charAt(k - 1).toLower))
}
