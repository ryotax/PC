import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val ts = sc.next.map(_ - '0')
  println(Math.min(
    ts.indices.count(i => ts(i) == i % 2),
    ts.indices.count(i => ts(i) != i % 2)
  ))
  
}
