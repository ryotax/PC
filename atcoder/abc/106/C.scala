import scala.io.StdIn._
object Main extends App {
  val s = readLine.toCharArray()
  val i = s.indexWhere(_ != '1')
  println(if (readLine.toLong <= i) '1' else if (i < 0) s(0) else s(i))
}
