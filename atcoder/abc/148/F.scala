import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  val in = new Scanner(System.in)
  val n, u, v = in.nextInt
  val edges = Array.fill(n + 1)(new ArrayBuffer[Int]())
  (1 until n).foreach{n =>
    val a, b = in.nextInt
    edges(a) += b
    edges(b) += a
  }

  val ts = Array.fill(n + 1)(-1)
  val as = Array.fill(n + 1)(-1)

  def fill(ar: Array[Int], curs: Array[Int], step: Int): Unit = {
    if (curs.nonEmpty) {
      val nexts = for {
          i <- curs
          _ = ar(i) = step
          j <- edges(i)
          if (ar(j) == -1)
        } yield j
      fill(ar, nexts, step + 1)
    }
  }

  fill(ts, Array(u), 0)
  fill(as, Array(v), 0)
  println(ts.tail.zip(as.tail).filter{case (t, a) => t <= a}.map(_._2 - 1).max)
}
