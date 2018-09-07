class UnionFind(size: Int) {
  val Undefined = -1
  val parents = Array.fill(size)(Undefined)

  // @scala.annotation.tailrec
  /** @retrun (root, rank) */
  def find(x: Int, rank: Int = 0): (Int, Int) = {
    println(s"$x, $rank")
    parents(x) match {
      case Undefined => parents(x) = x; (x, rank)
      case p if x == p => (p, rank)
      case p => {
        val (newRoot, newRank) = find(p, rank + 1)
        parents(x) = newRoot
        (newRoot, newRank)
      }
    }
  }

  def union(x: Int, y: Int): Unit = {
    val (xRoot, xRank) = find(x)
    val (yRoot, yRank) = find(y)
    val newRoot = if (xRank > yRank) yRoot else xRoot
    if (xRoot != yRoot) {
      parents(xRoot) = newRoot
      parents(yRoot) = newRoot
    }
    parents(x) = newRoot
    parents(y) = newRoot
    println(parents.toList)
  }
}
