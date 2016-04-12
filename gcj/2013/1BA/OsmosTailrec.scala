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
        println("Case #" + (i + 1) + ": " + min(count(armins, others.sorted, 0, others.size)))
    }

def min(tuple: (Int, Int)) = tuple._1.min(tuple._2)

@tailrec
def count(size: Int, others: List[Int], nOperations: Int, possibleMin: Int): (Int, Int) = {
  if (size == 1) (others.size, possibleMin)
  else others match {
    case head :: tail =>
      if (size > head) count(size + head, tail, nOperations, possibleMin)
      else count(size * 2 - 1, others, nOperations + 1, possibleMin.min(nOperations + others.size))
    case Nil => (nOperations, possibleMin)
  }
}
