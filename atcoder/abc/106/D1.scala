import scala.io.StdIn._
object Main extends App {
  val sr = new StdinReader
  val n, m, q = sr.nextInt

  val arr = Array.ofDim[Int](n + 1, n + 1)
  (1 to m).foreach{i =>
    val l, r = sr.nextInt
    arr(l)(r) += 1
  }

  for {
    l <- (1 to n)
    r <- (2 to n)
  } {
    arr(l)(r) = arr(l)(r - 1) + arr(l)(r)
  }

  (1 to q).foreach{i =>
    val l, r = sr.nextInt
    println((l to r).map{i => arr(i)(r) - arr(i)(l - 1)}.sum)
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
