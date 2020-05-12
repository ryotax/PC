import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val a, b = sc.nextInt
  println((a * 2 - 1) max (b * 2 - 1) max (a + b))
}
