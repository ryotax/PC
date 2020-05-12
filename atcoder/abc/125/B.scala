import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val vs = Array.fill(n)(sc.nextInt)
  val cs = Array.fill(n)(sc.nextInt)
  println(vs.zip(cs).collect{case (v, c) if v > c => v -c}.sum)
}
