import scala.io.StdIn._
import java.io.PrintWriter
import java.util.Arrays
object Main extends App {
  val sr = new StdinReader
  val n, m = sr.nextInt
  case class City(id: Int, p: Int, year: Int, var no: Int = 0)
  val pys = (1 to m).map{i => City(i, sr.nextInt, sr.nextInt)}
  def numbering(cities: Seq[City]): Unit =
    cities.sortBy(_.year).zipWithIndex.foreach {case (c, no) => c.no = no + 1}
  val pyMap = pys.groupBy(_.p).values.foreach(numbering)
  val w = new PrintWriter(System.out)
  val f = new java.text.DecimalFormat("000000000000")
  pys.foreach {c => w.println(f.format(c.p * 1000000L + c.no)) }
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
