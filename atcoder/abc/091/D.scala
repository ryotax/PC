import scala.io.StdIn._
object Main extends App {
  val sr = new StdinReader
  val m = sr.nextInt
  val a = Array.fill(m)(sr.nextInt)
  val b = Array.fill(m)(sr.nextInt)
  val as, bs = new Array[Int](28)
  for (i <- 0 until m; j <- 0 until 28) {
    as(j) = as(j) + ((a(i) >> j) & 1)
    bs(j) = bs(j) + ((b(i) >> j) & 1)
  }
println(as.deep)
println(bs.deep)
  def count(i: Int, carried: Int, cur: Int): Int = {
println(s"$i $carried $cur")
    if (i < 28) {
      // val bits = (as(i) + bs(i)) * m
      // val bits = (as(i) * (m - bs(i))) + (bs(i) * (m - as(i)))
      val bits = (as(i) + bs(i)) * m - 2 * as(i) * bs(i) + carried
println(bits)
      count(i + 1, as(i) * bs(i), cur + ((bits & 1) << i))
    } else {
      cur
    }
  }

  println(count(0, 0, 0))
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
