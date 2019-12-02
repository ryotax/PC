import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  val s, t = readLine
  val alphabetsBuffer: Array[ArrayBuffer[Int]] = Array.fill(26)(new ArrayBuffer[Int]())
  s.zipWithIndex.foreach {case (c, i) =>
    alphabetsBuffer(c - 'a') += i
  }
  val alphabets = alphabetsBuffer.map(_.toArray)

  def find(ab: Array[Int], gte: Int): Int = {
    def binSearch(from: Int, to: Int): Int = {
      val mid = (from + to) / 2
      if (mid == from) {
        if (ab(from) >= gte) from
        else if (ab(to) >= gte) to
        else -1
      } else {
        if (ab(mid) >= gte) binSearch(from, mid)
        else binSearch(mid, to)
      }
    }
    binSearch(0, ab.size - 1)
  }

  def count(i: Int, p: Long, cur: Int): Long = {
    if (s.size == i) p + l
    else {
      val c = s.charAt(i)
      find(alphabets(c - 'a'), cur) match {
        case -1 => -1
        case l => count(i + 1, p + 
    }
  }

  println(vs.tail.mkString(" "))
}

