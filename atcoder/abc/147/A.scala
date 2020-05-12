import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val a1, a2, a3 = sc.nextInt
  println(if (a1 + a2 + a3 >= 22) "bust" else "win")
}
