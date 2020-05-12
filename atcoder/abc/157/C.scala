object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val sc = (1 to M).map(_ => (in.nextInt, in.nextInt)).distinct.groupBy(_._1).mapValues(_.map(_._2))

  def proc(pos: Int, num: Int): Int = {
    if (pos > N) num
    else {
      sc.get(pos) match {
        case None => proc(pos + 1, num * 10 + (if (N > 1 && pos == 1) 1 else 0))
        case Some(l) =>
          if (l.size > 1 || (N > 1 && l.head == 0 && pos == 1)) -1
          else proc(pos + 1, num * 10 + l.head)
      }
    }
  }

  println(proc(1, 0))
}
