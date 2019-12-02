import scala.io.StdIn._
import scala.collection.mutable.{HashMap, ArrayBuffer}
import java.io.PrintWriter
import java.text.DecimalFormat
import java.util.Arrays
object Main extends App {
  val f = new DecimalFormat("000000")
  val sr = new StdinReader
  val n, m = sr.nextInt
  val input: Seq[Py] = (1 to m).map(i => Py(i, sr.nextInt, sr.nextInt))
  def yearToLocalIndex(s: Seq[Py]): Seq[Pi] = {
    s.sortBy(_.y).zipWithIndex.map{case (py, i) => Pi(py.globalIndex, py.p, i)}
  }
  val map = input.groupBy(_.p).mapValues(yearToLocalIndex)
  val result: Seq[Pi] = map.values.flatten.toArray.sortBy(_.globalIndex)
  val w = new PrintWriter(System.out)
  result.foreach {pi =>
    w.print(f.format(pi.p))
    w.println(f.format(pi.localIndex))
  }
  w.flush
}

case class Py(globalIndex: Int, p: Int, y: Int)
case class Pi(globalIndex: Int, p: Int, localIndex: Int)

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
}
