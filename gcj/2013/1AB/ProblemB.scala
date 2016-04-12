import scala.io.Source
import scala.annotation.tailrec

val input = Source.fromFile("B-small-practice.in")
  .getLines
  .toList

println(ProblemB.solve(input))

object ProblemB {

  def solve(inputs: List[String]): List[String] = {
    val Pattern = "(\\d+) (\\d+) (\\d+)".r
    // val cases = inputs.head.toInt

    (for (rows <- inputs.tail.grouped(2)) yield {
      rows(0) match {
        case Pattern(eS, rS, nS) => {
          val e = eS.toLong
          val r = rS.toLong
          val n = nS.toLong

          val vs = rows(1).split(" ").map(_.toLong).toList
          
          work(vs, 0, e, e, r).toString
        }
        case _ => throw new IllegalArgumentException("Unexpected input")
      }
    }).toList

  }
  
  def work(vs: List[Long], gain: Long, currentE: Long, maxE: Long, r: Long): Long = {
    vs match {
      case Nil => gain
      case head :: tail => {
        val eToUse = getEnergyToUse(head, tail, r, currentE, maxE, r)
        val newGain = gain + eToUse*head
        val newE = Math.min(maxE, currentE - eToUse + r)
        work(tail, newGain, newE, maxE, r)
      }
    }
  }
  
  def getEnergyToUse(value: Long, vs: List[Long], regained: Long, currentE: Long, maxE: Long, r: Long):Long = {
    vs match {
      case head :: tail => {
        if (regained >= maxE) currentE
        else {
          if (head > value) Math.max(currentE + regained - maxE, 0)
          else getEnergyToUse(value, tail, regained + r, currentE, maxE, r)
        }
      }
      case Nil => currentE
    }
  }
  
}
