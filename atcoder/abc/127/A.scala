import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val a, b = sc.nextInt
  println(if (a >= 13) b else if (a >= 6) b / 2 else 0)
}
