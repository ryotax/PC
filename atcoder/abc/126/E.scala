import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n, m = sc.nextInt
  val uf = new UnionFind(n)
  (1 to m).foreach { i =>
    val x, y, _ = sc.nextInt - 1
    uf.union(x, y)
  }
  val (vs, trees) = (0 to n - 1).map(uf.find(_)._1).partition(_ == -1)
  println(vs.size + trees.groupBy(identity).size)
}

class UnionFind(size: Int) {
  val Undefined = -1
  val parents = Array.fill(size)(Undefined)

  /** @retrun (root, rank) */
  def find(x: Int, rank: Int = 0): (Int, Int) = {
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
    val newRoot = if (xRank < yRank) yRoot else xRoot
    if (xRoot != yRoot) {
      parents(xRoot) = newRoot
      parents(yRoot) = newRoot
    }
    parents(x) = newRoot
    parents(y) = newRoot
  }
}
