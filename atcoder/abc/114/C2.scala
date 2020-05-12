import scala.collection.mutable.ArrayBuffer
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val (size, n) = {
    val n = in.next
    (n.size, n.toInt)
  }

  val candidates = ArrayBuffer[String]()
  def dfs(s: String): Unit = {
    Array("3", "5", "7").foreach{d =>
      val next = d + s
      if (next.size <= size) {
        candidates += next
        dfs(next)
      }
    }
  }

  dfs("")
  println(candidates.filter(c => c.toInt <= n && c.distinct.size == 3).size)
}
