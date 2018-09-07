import scala.collection.immutable.BitSet
import scala.collection.mutable.{BitSet => MBitSet}

object Connectivity {
  def mainTest(args: Array[String]) {
    val vertices = 7
    val edges = Seq[(Int, Int)]((1, 2), (2, 3), (4, 5), (5, 6), (4, 7), (5, 2), (3, 7))

    println(count(vertices, edges))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val vertices, n = sc.nextInt
    val edges = (1 to n) map {i =>
      (sc.nextInt, sc.nextInt)
    }
    println(count(vertices, edges))
  }

  def count(vertices: Int, edges: Iterable[(Int, Int)]) = {
    val allVertices = BitSet.fromBitMask(Array(((1L << vertices) - 1) << 1))
    (1 to ((1 << vertices) / 2 - 1)) count {vs =>
      val leftVertices = BitSet.fromBitMask(Array(vs << 1)) 
      val targetEdges = edges filter {e => leftVertices.contains(e._1) ^ leftVertices.contains(e._2)}
      isConnected(targetEdges, allVertices)
    }
  }

  def isConnected(es: Iterable[(Int, Int)], vs: BitSet) = {
    val reached = new MBitSet

    def search(v: Int): Boolean = {
      val nexts = reachableVertices(es, v)
      val firstReached = nexts filter {v => !reached.contains(v)}
      firstReached foreach {v => reached += v}

      if (reached == vs) true
      else firstReached exists {search}
    }

    reached += 1
    search(1)
  }

  def reachableVertices(es: Iterable[(Int, Int)], v: Int) = {
    es collect {
      case e if e._1 == v => e._2
      case e if e._2 == v => e._1
    }
  }
}
