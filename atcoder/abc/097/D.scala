object Main extends App {
  val reader = new StdinReader
  val n, m = reader.nextInt
  val pn = -1 +: Array.fill(n)(reader.nextInt)
  val uf = new UnionFind(n + 1)
  (1 to m).foreach{i =>
    val x, y = reader.nextInt
    uf.union(x, y)
  }
  println(pn.zipWithIndex.tail.count{case (pi, i) =>
    if (i == pi) true
    else uf.find(i)._1 == uf.find(pi)._1
  })

}

// libraries--------------------------------------------------------
class UnionFind(size: Int) {
  val Undefined = -1
  val parents = Array.fill(size)(Undefined)

  // @scala.annotation.tailrec
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
    val newRoot = if (xRank > yRank) yRoot else xRoot
    if (xRoot != yRoot) {
      parents(xRoot) = newRoot
      parents(yRoot) = newRoot
    }
    parents(x) = newRoot
    parents(y) = newRoot
  }
}

class StdinReader {
  val is = System.in
  val buffer = new Array[Byte](1024 * 1024)
  var size = 0
  var pos = 0

  private def readByte: Byte = {
    if (pos >= size) {
      pos = 0;
      size = is.read(buffer);
    }
    if (size < 0) -1
    else {
      val ret = buffer(pos)
      pos += 1
      ret
    }
  }

  // support single byte char only
  def next: String = {
    @scala.annotation.tailrec
    def r(sb: StringBuilder, reading: Boolean): String = {
      readByte match {
        case b if ('!' <= b && b <= '~') => r(sb.append(b.asInstanceOf[Char]), true)
        case _ => if (reading) sb.toString else r(sb, false)
      }
    }
    r(new StringBuilder, false)
  }

  def nextInt: Int = {
    @scala.annotation.tailrec
    def r(i: Int, reading: Boolean): Int = {
      readByte match {
        case '-' => r(i * -1, true)
        case b if '0' <= b && b <= '9' => r(i * 10 + (b - '0'), true)
        case _ => if (reading) i else r(i, false)
      }
    }
    r(0, false)
  }
}

