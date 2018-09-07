object Connectivity {
  type BitMask = Int
  def mainTest(args: Array[String]) {
    val vertices = 7
    val edges = Seq((1, 2), (2, 3), (4, 5), (5, 6), (4, 7), (5, 2), (3, 7)) map {e => bitPos(e._1) | bitPos(e._2)}

    println(count(vertices, edges))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val vertices, n = sc.nextInt
    val edges = (1 to n) map {i => bitPos(sc.nextInt) | bitPos(sc.nextInt)}
    println(count(vertices, edges))
  }

  def count(vertices: Int, edges: Iterable[BitMask]) = {
    val allVertices = (1 << vertices) - 1
    (1 to ((1 << vertices) / 2 - 1)) count {vs =>
      val targetEdges = edges filter {e => Integer.bitCount(e & vs) == 1}
      isConnected(targetEdges, allVertices)
    }
  }

  def isConnected(es: Iterable[BitMask], vs: Int) = {
    var reached = 1

    def search(v: Int): Boolean = {
      val nexts = reachableVertices(es, v)
      val firstReached = ~(~nexts | reached) // (1100 => 0101) == 1000
      reached = reached | nexts
      if (reached == vs) true
      else {
        if (firstReached != 0) search(firstReached) else false
      }
    }

    search(reached)
  }

  def reachableVertices(es: Iterable[BitMask], v: BitMask) = {
    es.foldLeft(0){(z, e) => if (Integer.bitCount(e & v) == 1) z | ~(~e | v) else z}
  }

  def bitPos(n: Int) = 1 << (n - 1)
}
