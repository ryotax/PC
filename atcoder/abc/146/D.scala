import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  case class Edge(a: Int, b: Int) {
    var color = 0;
  }

  val n = readInt
  val nodes = Array.fill(n + 1)(new ArrayBuffer[Edge]())

  val edges = Array.fill(n - 1){
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    val e = Edge(a, b)
    nodes(a) += e
    nodes(b) += e
    e
  }

  println(nodes.foldLeft(0)((z, n) => Math.max(z, n.size)))

  def bfs(targets: Seq[Int]): Unit = {
    val nexts = targets.flatMap{ i => 
      val (p, c) = nodes(i).partition(_.color != 0)
      val counts: Seq[Int] = (1 to c.size + 1).filter(_ != p.headOption.fold(0)(_.color))
      c.zip(counts).map {case (edge, index) =>
        edge.color = index
        if (edge.a == i) edge.b else edge.a
      }
    }
    if (nexts.nonEmpty) bfs(nexts)
  }

  bfs(Seq(1))

  println(edges.map{_.color}.mkString("\n"))
}
