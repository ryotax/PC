object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val uf = new UnionFind(N + 1)
  (1 to M).foreach(_ => uf.unite(in.nextInt, in.nextInt))
  println(uf.sizes.max)
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
  def same(x: Int, y: Int) = find(x) == find(y)

  def unite(x: Int, y: Int): Int = {
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
