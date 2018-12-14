import scala.io.StdIn._
object Main extends App {
  case class Elem(num: Int, cnt: Int)
  readLine.toInt
  val vs = readLine.split(" ").map{_.toInt}
  val (evens, odds) = vs.zipWithIndex.partition(_._2 % 2 == 0)

  val (even1st, even2nd) = take2(count(evens), evens.size)
  val (odd1st, odd2nd) = take2(count(odds), odds.size)
  println(if (even1st.num != odd1st.num) even1st.cnt + odd1st.cnt
          else Math.min(even1st.cnt + odd2nd.cnt, even2nd.cnt + odd1st.cnt))

  def take2(arr: Array[Elem], fullSize: Int): (Elem, Elem) = 
    (arr(0), if (arr.size == 1) Elem(0, fullSize) else arr(1))

  def count(s_i: Array[(Int, Int)]): Array[Elem] = {
    val size = s_i.size
    s_i.map{_._1}
       .groupBy(identity)
       .map{case (num, nums) => Elem(num, size - nums.size)}
       .toArray
       .sortBy(_.cnt)
  }
}

