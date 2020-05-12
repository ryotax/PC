import scala.collection.mutable.Queue
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K = in.nextInt
  val q = Queue((1L to 9L): _*)

  def next(): Long = {
    val i = q.dequeue
    val lastDigit = i % 10
    val m = i * 10 + lastDigit
    if (lastDigit != 0) q.enqueue(m - 1)
    q.enqueue(m)
    if (lastDigit != 9) q.enqueue(m + 1)
    i
  }

  (1 until K).foreach(_ => next())
  println(next())
}
