import scala.io.StdIn._
object Main extends App {
  readLine
  val hs = readLine.split(" ").map(_.toInt)
  val (maxCnt, curCnt, _) = hs.foldLeft((0, 0, 0)){case ((maxCnt, curCnt, preNum), curNum) =>
    if (curNum <= preNum) (maxCnt, curCnt + 1, curNum)
    else (Math.max(maxCnt, curCnt), 0, curNum)
  }
  println(Math.max(maxCnt, curCnt))
}
