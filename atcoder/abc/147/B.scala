import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val s = sc.next
  println(s.take(s.size / 2).zip(s.reverse).count(x => x._1 != x._2))
}
