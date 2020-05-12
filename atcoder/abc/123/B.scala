import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val ds = Array.fill(5)(sc.nextInt).sortBy(d => (d + 9) % 10)
  println(ds.head + ds.tail.map(d => (d + 9) / 10 * 10).sum)
}
