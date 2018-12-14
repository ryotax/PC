import scala.io.StdIn._
import scala.collection.mutable.LinkedHashSet

object Main extends App {
  val s, t = readLine
  val sSet, tSet = new LinkedHashSet[Char]()
  sSet ++= s
  tSet ++= t
  val table = sSet.zipAll(tSet, ' ', ' ').toMap
  println(if (t == s.map(table)) "Yes" else "No")
}

