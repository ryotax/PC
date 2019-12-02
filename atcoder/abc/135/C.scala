import scala.io.StdIn._
object Main extends App {
  readInt
  val as = readLine.split(" ").map(_.toLong)
  val bs = 0L +: readLine.split(" ").map(_.toLong)

  val (_, sum) = as.zip(bs).foldRight((0L, 0L)){case ((a, b), (pre, sum)) =>
    if (a < pre) (b, sum + a)
    else if (a - pre < b) (b - (a - pre), sum + a)
    else (0L, sum + pre + b)
  }

  println(sum)
}
