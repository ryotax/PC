import scala.io.StdIn._
object Main extends App {
  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val s = readLine.map(_ == '0')
  val memo = new Array[Int](n + 1)

  def step(i: Int): Boolean = {
    if (i > n) true
    else if (!s(i)) step(i + 1)
    else {
      (m to 1 by -1).find{p => s(i - p)} match {
        case None => false
        case Some(p) =>
          memo(i) = p
          step(i + 1)
      }
    }
  }

  def collect(pos: Int, l: List[Int]): List[Int] = {
    if (pos == 0) l
    else {
      val i = memo(pos)
      collect(pos - i, i :: l)
    }
  }

  println(
    if (m >= n) n
    else {
      (1 to m).foreach {i =>
        if (s(i)) memo(i) = i
      }
      if (step(m + 1)) {
        collect(n, Nil).mkString(" ")
      } else -1
    }
  )
}
