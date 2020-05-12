import scala.collection.mutable.ListBuffer
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  val Q = in.nextInt
  val pattern = "2 (.) (.)".r
  val (s, rev) = (1 to Q).foldLeft((ListBuffer(S: _*), false)){case ((s, rev), i) =>
    in.nextInt match {
      case 1 => (s, !rev)
      case _ =>
        val f = in.nextInt
        val c = in.next.charAt(0)
        // val next = if ((f == 1 && !rev) || (f == 2 && rev)) s.prepend(c) else s.append(c)
        if ((f == 1 && !rev) || (f == 2 && rev)) s.prepend(c) else s.append(c)
        (s, rev)
    }
  }

  println((if (rev) s.reverse else s).mkString)
}
