import scala.io.Source
import scala.annotation.tailrec
import scala.math.BigInt

val input = Source.fromFile("A-large.in")
    .getLines
    .toList
    .tail
    .grouped(2)
    .zipWithIndex
    .foreach {
      case (q, i) =>
        val armins = q(0).split(" ")(0).toInt
        val others = q(1).split(" ").map(_.toInt).toList
        println("Case #" + (i + 1) + ": " + count(armins, others.sorted, 0))
    }

def count(size: Int, others: List[Int], nOperations: Int): Int = {
  if (size == 1) others.size
  else others match {
    case head :: tail =>
      if (size > head) count(size + head, tail, nOperations)
      else scala.math.min(nOperations + others.size, count(size * 2 - 1, others, nOperations + 1))
    case Nil => nOperations
  }
}
