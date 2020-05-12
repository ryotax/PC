object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m = sc.nextInt
  val bs = Array.fill(m)((sc.nextInt - 1, sc.nextInt - 1)).reverse
  val uf = new UnionFind(n)

  val result = bs.scanLeft(n.toLong * (n - 1) / 2){(z, b) =>
    if (uf.find(b._1) != uf.find(b._2)) {
      val inconvenience = uf.size(b._1).toLong * uf.size(b._2)
      uf.union(b._1, b._2)
      z - inconvenience
    } else z
  }.reverse.tail

  println(result.mkString("\n"))
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
