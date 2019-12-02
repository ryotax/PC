import scala.io.StdIn._
import scala.collection.mutable.{HashMap, ArrayBuffer}
import java.io.PrintWriter
import java.text.DecimalFormat
import java.util.Arrays
object Main extends App {
  val f = new DecimalFormat("000000")
  val sr = new StdinReader
  val n, m = sr.nextInt
  val source = (1 to m).map{i => Array(sr.nextInt, sr.nextInt)}
  val map = new HashMap[Int, ArrayBuffer[Int]]
  source.foreach{case Array(p, y) => map.getOrElseUpdate(p, new ArrayBuffer[Int]) += y}
  val newMap = map.mapValues(_.sorted.toArray)
  val w = new PrintWriter(System.out)
  source.foreach {case Array(p, y) =>
    val i = Arrays.binarySearch(newMap(p), y) + 1
    w.print(f.format(p))
    w.println(f.format(i))
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
