import java.util.Scanner
object Main extends App {
  val in = new Scanner(System.in)
  val n = in.nextLong
  val divs: Stream[Long] = 10 #:: divs.map(_ * 5).takeWhile(_ <= 1000000000000000000L)
  println(if (n % 2 == 1) 0 else divs.map(n / _).sum)
}
