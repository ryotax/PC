import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val as = readLine.split(" ").map(_.toInt)

  val tbl = Array.fill(3)(-1)
  println(as.foldLeft(1L){ (z, a) =>
    tbl.indexWhere(_ == a - 1) match {
      case -1 => 0
      case i => 
        val ret = z * tbl.count(_ == a - 1) % 1000000007
        tbl(i) += 1
        ret
    }
  })
}
