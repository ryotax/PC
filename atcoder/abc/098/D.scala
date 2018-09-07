import scala.annotation.tailrec

object Main extends App {
  val n = io.StdIn.readInt
  val as = io.StdIn.readLine.split(" ").map{_.toInt}.zipWithIndex
  val targets = as.filter(a => a._1 != 0 || a._2 == 0)
  println(targets.toList)

  @tailrec
  def searchEnd(curIndex: Int, value: Int): (Int, Int) = {
    if (curIndex < targets.size) {
      val cur = targets(curIndex)
      val newValue = value ^ cur._1
      if (newValue == value + cur._1) searchEnd(curIndex + 1, newValue)
      else (curIndex, value)
    } else (curIndex, value)
  }

  def calsSum(start: Int, end: Int): Int = {
    val startIndex = targets(start)._2
    val endIndex = if (end == targets.size) n - 1 else targets(end)._2
    val toIndex = endIndex min (if (start + 1 == targets.size) n - 1 else targets(start + 1)._2)
    println(s"\t\t\t\t\t\t$startIndex, $toIndex, $endIndex")
    ((endIndex - startIndex + 1) + (endIndex - toIndex + 1)) * (toIndex - startIndex + 1) / 2
  }

  def count(start: Int, value: Int, sum: Int): Int = {
    if (start < targets.size) {
      println(s"\t\t$start, $value, $sum")
      val (end, newValue) = searchEnd(start, value)
      val curSum = calsSum(start, end)
      println(s"\t\t\t\t$end, $curSum")
      count(start + 1, newValue - targets(start)._1, sum + curSum)
    } else sum
  }

  println(count(0, 0, 0))
}
