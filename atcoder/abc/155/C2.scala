import java.io._
import scala.collection.mutable.{Map => MMap}
object Main extends App {
  val in = new StdinReader
  val N = in.nextInt
  val map = MMap[String, Int]().withDefault(_ => 0)
  (1 to N).foreach{i =>
    val s = in.next
    map.put(s, map(s) + 1)
  }

  val list = map.toList.sortWith((l, r) => if (l._2 == r._2) l._1 < r._1 else l._2 > r._2)
  val max = list.head._2
  val out = new PrintWriter(new BufferedOutputStream(System.out))
  list.takeWhile(_._2 == max).foreach(t => out.println(t._1))
  out.flush()
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


