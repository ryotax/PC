import scala.io.Source
import scala.annotation.tailrec

val input = Source.fromFile("B-large-practice.in")
  .getLines
  .toList
  .tail
  .grouped(2)
  .zipWithIndex
  .foreach {
    case (List(mrn, vs), i) =>
      val Array(max, regain, num) = mrn.split(" ").map(_.toLong)
      println("Case #" + (i + 1) + ": " + calc(max, regain, vs.split(" ").map(_.toLong)))
  }

def calc(max: Long, regain: Long, vs: Array[Long]): Long = {
  @tailrec
  def calcRec(values: List[Long], currentEnergy: Long, gained: Long): Long = {
    values match {
      case head :: tail => 
        val consumed = Math.min(currentEnergy, consumeEnergy(head, tail, currentEnergy))
        calcRec(tail, Math.min(max, currentEnergy - consumed + regain), gained + consumed * head)
      case Nil => gained
    }
  }

  @tailrec
  def consumeEnergy(value: Long, remain: List[Long], currentEnergy: Long): Long = {
    remain match {
      case head :: tail =>
        if (head >= value) Math.max(0, currentEnergy + regain - max)
        else consumeEnergy(value, tail, currentEnergy + regain)
      case Nil => currentEnergy
    }
  }

  calcRec(vs.toList, max, 0)
}
