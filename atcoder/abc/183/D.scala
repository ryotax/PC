import scala.collection.mutable.PriorityQueue
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, W = in.nextInt
  case class User(s: Int, t: Int, p: Int)
  val us = List.fill(N)(User(in.nextInt, in.nextInt, in.nextInt)).sortBy(_.s)

  val inSupply = PriorityQueue[User]()(new Ordering[User] { def compare(l: User, r: User) = r.t - l.t })
  def loop(l: List[User], sum: Long): Boolean = l match {
    case Nil => true
    case x :: xs =>
      def dequeue(s: Long): Long =
        if (inSupply.headOption.fold(false)(_.t <= x.s)) {
          val dequed = inSupply.dequeue()
          dequeue(s - dequed.p)
        } else s
      
      val s = dequeue(sum)
      if (s + x.p > W) false
      else {
        inSupply += x
        loop(xs, s + x.p)
      }
  }

  println(if (loop(us, 0L)) "Yes" else "No")
}

