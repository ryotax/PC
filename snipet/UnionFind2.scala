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


// Test
val uf = new UnionFind(10)
def assert(b: Boolean): Unit = println(if (b) "OK" else throw new Exception)

assert(uf.size(0) == 1)
assert(uf.size(9) == 1)

uf.unite(0, 9)
assert(uf.same(0, 9))
assert(!uf.same(0, 8))
assert(uf.size(0) == 2)
assert(uf.size(9) == 2)

uf.unite(1, 8)
assert(uf.size(0) == 2)
assert(uf.size(1) == 2)

uf.unite(0, 1)
assert(uf.size(0) == 4)
assert(uf.size(1) == 4)
assert(uf.size(8) == 4)
assert(uf.size(9) == 4)
assert(uf.size(2) == 1)

uf.unite(8, 9)
assert(uf.same(0, 9))
assert(uf.same(0, 8))
assert(uf.size(0) == 4)
assert(uf.size(1) == 4)
assert(uf.size(8) == 4)
assert(uf.size(9) == 4)
assert(uf.size(2) == 1)
