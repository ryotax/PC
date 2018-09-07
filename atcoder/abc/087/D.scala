import scala.collection.mutable.ListBuffer
import scala.util.Try
object Main extends App {
  val sr = new StdinReader
  val n, m = sr.nextInt
  val conditions = Array.fill(n + 1)(new ListBuffer[(Int, Int)])
  (1 to m).foreach{i => 
    val l, r, d = sr.nextInt
    conditions(l) += ((r, d))
    conditions(r) += ((l, -d))
  }

  val checked = Array.fill(n + 1)(Int.MaxValue)

  case class Check(index: Int, position: Int)

  @scala.annotation.tailrec
  def check(cs: List[Check]): Unit = {
    val checks = new ListBuffer[Check]
    if (cs.nonEmpty) {
      cs.foreach{c =>
        if (checked(c.index) == Int.MaxValue) {
          checked(c.index) = c.position
          checks ++= conditions(c.index).map{case (to, d) => Check(to, c.position + d)}
        } else if (checked(c.index) != c.position) {
          throw new Exception
        }
      }
      check(checks.toList)
    }
  }

  val result = try{
    (1 to n).foreach{i => if (checked(i) == Int.MaxValue) check(List(Check(i, 0)))}
    true
  } catch {
    case e: Throwable => e.printStackTrace;false
  }
  println(if (result) "Yes" else "No")
}

class StdinReader {
  val buffer = new Array[Byte](1024 * 1024)
  var size = 0
  var pos = 0

  private def readByte: Byte = {
    if (pos >= size) {
      pos = 0;
      size = System.in.read(buffer);
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
