import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  val sr = new StdinReader
  val n, q = sr.nextInt

  val edges: Array[ArrayBuffer[Int]] = Array.tabulate(n + 1)(_ => new ArrayBuffer[Int]())
  (1 to n - 1).foreach {i =>
    val a, b = sr.nextInt
    edges(a) += b
    edges(b) += a
  }

  val vs = new Array[Long](n + 1)
  (1 to q).foreach {i =>
    val p, x = sr.nextInt
    vs(p) += x
  }

  def check(checks: List[Int]): Unit = {
    if (checks.nonEmpty) {
      check(checks.flatMap { i =>
        edges(i).foreach {v =>
          vs(v) += vs(i)
          edges(v) -= i
        }
        edges(i)
      })
    }
  }
  check(List(1))

  println(vs.tail.mkString(" "))
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

