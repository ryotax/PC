import scala.collection.mutable.{HashSet => MSet}
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.nextInt
  val set = new MSet[Int]()

  def next(i: Int, count: Int): Int =
    if (set.add(i)) next(if (i % 2 == 0) i / 2 else i * 3 + 1, count + 1)
    else count

  println(next(S, 1))
}
