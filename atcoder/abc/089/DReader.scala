object Main extends App {
  val sr = new StdinReader
  val h, w, d = sr.nextInt
  val table: Map[Int, (Int, Int)] = (for {
        y <- 0 until h
        x <- 0 until w
      } yield sr.nextInt -> (x, y)).toMap

  val tbl = new Array[Int](h * w + 1)
  (1 to d).flatMap{dd =>
    ((dd + d) to (h * w) by d).map {p => 
      val lPos = table(p - d)
      val rPos = table(p)
      val mp = Math.abs(lPos._1 - rPos._1) + Math.abs(lPos._2 - rPos._2)
      tbl(p) = mp + tbl(p - d)
    }
  }

  println(
    (1 to sr.nextInt).map{i =>
      val l, r = sr.nextInt
      tbl(r) - tbl(l)
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
