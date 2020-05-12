object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.next.map(_ - '0').toList

  implicit class ComparableIntList(val l: List[Int]) extends AnyVal {
    def <=(o: List[Int]): Boolean = {
      if (l.size < o.size) true
      else if (l.size > o.size) false
      else l.zip(o).find(t => t._1 != t._2).fold(true)(t => t._1 <= t._2)
    }
  }

  def valid(l: List[Int]): Boolean = List(3, 5, 7).forall(n => l.contains(n))

  def dfs(l: List[Int], fixed: Boolean): Int = {
    Array(3, 5, 7).map{i =>
      val next = i :: l
      if (next <= N) {
        if (fixed || valid(next)) 1 + dfs(next, fixed)
        else dfs(next, false)
      } else 0
    }.sum
  }

  println(dfs(Nil, false))
}
