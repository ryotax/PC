object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = List.fill(N)(in.nextInt)

  def op(ps: List[(Int, Int)], money: Long, stocks: Long): Long = ps match {
    case Nil => money
    case (now, next) :: xs =>
      if (now <= next) op(xs, money % now, stocks + money / now)
      else op(xs, money + stocks * now, 0)
  }

  println(op(As.zipAll(As.tail, 0, 0), 1000, 0))
}
