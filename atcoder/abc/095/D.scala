object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val C = in.nextLong

  case class Sushi(pos: Long, cal: Long)
  val Xs = Array.fill(N)(Sushi(in.nextLong, in.nextLong))
  val posMaxs = Array.fill(N + 1)(0L)
  val posRevMaxs = Array.fill(N + 1)(0L)
  val negMaxs = Array.fill(N + 1)(0L)
  val negRevMaxs = Array.fill(N + 1)(0L)

  def posLoop(i: Int, cals: Long): Unit = {
    if (i <= N) {
      val s = Xs(i - 1)
      posMaxs(i) = posMaxs(i - 1) max (cals + s.cal - s.pos)
      posRevMaxs(i) = posRevMaxs(i - 1) max (cals + s.cal - s.pos * 2)
      posLoop(i + 1, cals + s.cal)
    }
  }

  def negLoop(i: Int, cals: Long): Unit = {
    if (i <= N) {
      val s = Xs(N - i)
      negMaxs(i) = negMaxs(i - 1) max (cals + s.cal - (C - s.pos))
      negRevMaxs(i) = negRevMaxs(i - 1) max (cals + s.cal - (C - s.pos) * 2)
      negLoop(i + 1, cals + s.cal)
    }
  }
  posLoop(1, 0)
  negLoop(1, 0)

  println(posMaxs.max max
          negMaxs.max max
          posRevMaxs.zip(negMaxs.reverse).map{case (l, r) => l + r}.max max
          negRevMaxs.zip(posMaxs.reverse).map{case (l, r) => l + r}.max)
}

