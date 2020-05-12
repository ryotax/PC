import scala.io.StdIn._
import scala.collection.mutable.{ArrayBuffer, HashSet}
object Main extends App {
  val in = new StdinReader
  val n, m = in.nextInt
  val vs = Array.fill(n + 1)(new ArrayBuffer[Int]())
  (1 to m).foreach { i =>
    val u, v = in.nextInt
    vs(u) += v
  }
  val s, t = in.nextInt

  val arrived = new HashSet[Int]()

  def loop(cnt: Int, curs: Seq[Int]): Int = {
    val nexts = for {
      start <- curs
      hop <- vs(start)
      step <- vs(hop)
      jump <- vs(step)
      if !arrived.contains(jump)
    } yield {
      arrived += jump
      jump
    }

    if (nexts.contains(t)) cnt
    else if (nexts.isEmpty) -1
    else loop(cnt + 1, nexts)
  }

  println(loop(1, Seq(s)))
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

