import scala.io.StdIn._
object Main extends App {
  case class Food(time: Int, taste: Int)
  val Array(n, maxT) = readLine.split(" ").map(_.toInt)
  val allFoods = List.tabulate(n) {i =>
    val Array(a, b) = readLine.split(" ")
    Food(a.toInt, b.toInt)
  }.sortBy(_.time)

  def dp(foods: List[Food], pre: Array[Int]): Int = foods match {
    case Nil => pre(maxT)
    case f :: fs => 
      val tbl = pre.clone
      (0 until maxT).foreach { t =>
        if (t + f.time < maxT) {
          tbl(t + f.time) = Math.max(pre(t + f.time), pre(t) + f.taste)
        }
      }
      tbl(maxT) = Math.max(pre(maxT), pre(maxT - 1) + f.taste)
      dp(fs, tbl)
  }

  println(dp(allFoods, new Array[Int](maxT + 1)))
}
