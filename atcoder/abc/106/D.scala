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
    r <- (1 to n)
  } {
    arr(l)(r) += arr(l - 1)(r) + arr(l)(r - 1) - arr(l - 1)(r - 1)
  }

  val ans = Array.ofDim[Int](n + 1, n + 1)
  for {
    l <- (1 to n)
    r <- (1 to n)
  } {
    ans(l)(r) = arr(r)(r) - arr(l - 1)(r) - arr(r)(l - 1) + arr(l - 1)(l - 1)
  }

  val w = new java.io.PrintWriter(System.out)
  (1 to q).foreach{i =>
    val l, r = sr.nextInt
    w.println(ans(l)(r))
  }
  w.flush
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
