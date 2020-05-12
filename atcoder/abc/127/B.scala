import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val r, d, x = sc.nextInt
  println(((1 to 10).scanLeft(x)((z, _) => r * z - d)).tail.mkString("\n"))
}
