import scala.io.StdIn._
object Main extends App {
  @scala.annotation.tailrec
  def next(diff: Int, maxValue: Int, num: Int, as: Seq[Int]): Int = {
    as match {
      case Nil => num
      case _ => 
        val targetValue = as.head
        val newDiff = maxValue - targetValue
        if (newDiff > diff) next(newDiff, maxValue, 1, as.tail) // must be (targetValue < maxValue)
        else if (newDiff == diff) next(diff, targetValue, num + 1, as.tail) // must be (targetValue > maxValue)
        else next(diff, targetValue max maxValue, num, as.tail)
    }
  }

  val n = readLine.split(" ").head map {_.toInt}
  val as = (readLine.split(" ") map {_.toInt}).toList.reverse

  println(next(0, as.head, 0, as.tail))
}
