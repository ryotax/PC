import scala.io.StdIn._
object Main extends App {
  val s, t = readLine
  println(if ((1 until s.length).forall{i => s.indexOf(s.charAt(i)) == t.indexOf(t.charAt(i))}) "Yes" else "No")
}

