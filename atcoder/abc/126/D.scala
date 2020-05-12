import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val edges = Array.fill(n + 1)(new ArrayBuffer[(Int, Int)]())
  (1 until n).foreach { i =>
    val u, v, w = sc.nextInt
    edges(u) += ((v, w))
    edges(v) += ((u, w))
  }

  val result = new Array[Int](n + 1)

  def bfs(curs: List[(Int, Int, Int)]): Unit = {
    val nexts = curs.flatMap {case (pre, cur, w) =>
      result(cur) = w % 2
      edges(cur).collect{case (i, ww) if i != pre => (cur, i, (w + ww) % 2)}
    }
    if (nexts.nonEmpty) bfs(nexts)
  }

  bfs(List((0, 1, 0)))

  println(result.tail.mkString("\n"))
}
