import scala.collection.mutable.ListBuffer

object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M, K = in.nextInt
  val uf = new UnionFind(N + 1)
  val friends = new Array[Int](N + 1)

  (1 to M).foreach {m =>
    val a, b = in.nextInt
    uf.union(a, b)
    friends(a) += 1
    friends(b) += 1
  }

  val blocks = Array.fill(N + 1)(new ListBuffer[Int])
  (1 to K).foreach {m =>
    val c, d = in.nextInt
    blocks(c) += d
    blocks(d) += c
  }

  val result = (1 to N).map {i =>
    uf.size(i) - friends(i) - blocks(i).filter(j => uf.find(i) == uf.find(j)).size - 1
  }

  println(result.mkString(" "))
}

class UnionFind(nodes: Int) {
  val parents = Array.tabulate(nodes)(identity)
  val sizes = Array.fill(nodes)(1)

  // @scala.annotation.tailrec
  /** @retrun (root, rank) */
  def findWithRank(x: Int, rank: Int = 0): (Int, Int) = {
    parents(x) match {
      case p if x == p => (p, rank)
      case p => {
        val (newRoot, newRank) = findWithRank(p, rank + 1)
        parents(x) = newRoot
        (newRoot, newRank)
      }
    }
  }

  def find(x: Int): Int = {
    parents(x) match {
      case p if x == p => p
      case p => {
        val newRoot = find(p)
        parents(x) = newRoot
        newRoot
      }
    }
  }

  def size(x: Int) = sizes(find(x))

  def union(x: Int, y: Int): Int = {
    val (xRoot, xRank) = findWithRank(x)
    val (yRoot, yRank) = findWithRank(y)
    val newRoot = if (xRank < yRank) yRoot else xRoot
    if (xRoot != yRoot) {
      parents(xRoot) = newRoot
      parents(yRoot) = newRoot
      sizes(newRoot) = sizes(xRoot) + sizes(yRoot)
    }
    parents(x) = newRoot
    parents(y) = newRoot
    newRoot
  }
}
