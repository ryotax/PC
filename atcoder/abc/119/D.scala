object Main extends App {
  val in = new StdinReader
  val a, b, q = in.nextInt
  val Max = 10000000000L
  val ss = (-2 * Max) +: Array.fill(a)(in.nextLong) :+ (3 * Max)
  val ts = (-2 * Max) +: Array.fill(b)(in.nextLong) :+ (3 * Max)
  val xs = Array.fill(q)(in.nextLong)

  def search(a: Array[Long], l: Int, r: Int, x: Long): (Long, Long) = {
    val m = (l + r) / 2
    if (x < a(m)) search(a, l, m, x)
    else if (x >= a(m + 1)) search(a, m, r, x)
    else (x - a(m), a(m + 1) - x)
  }

  println(xs.map{x =>
    val (sl, sr) = search(ss, 0, ss.size, x)
    val (tl, tr) = search(ts, 0, ts.size, x)
    Array(
      sl max tl,
      sr max tr,
      sl * 2 + tr,
      tl * 2 + sr,
      sl + tr * 2,
      tl + sr * 2).min
  }.mkString("\n"))
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

  def nextLong: Long = {
    @scala.annotation.tailrec
    def r(i: Long, reading: Boolean): Long = {
      readByte match {
        case '-' => r(i * -1, true)
        case b if '0' <= b && b <= '9' => r(i * 10 + (b - '0'), true)
        case _ => if (reading) i else r(i, false)
      }
    }
    r(0L, false)
  }
}

