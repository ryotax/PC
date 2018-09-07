import scala.io.StdIn.readLine

object C2 {
  val Self = 0
  val Copy = 1
  def main(args: Array[String]) {
    val Array(n, t) = scala.io.StdIn.readLine.split(" ") map {_.toInt}
    var allSelf = 0
    var allCopy = 0
    val homeworks = (1 to n) map {i =>
      val hw = scala.io.StdIn.readLine.split(" ") map {_.toInt}
      allSelf += hw(Self)
      allCopy += hw(Copy)
    }

    if (allCopy > remain) -1 // 全部copyしても終わらない

    println(exec(homeworks sortBy {hw => hw(Copy) - hw(Self)}))
  }

  def exec(homeworks: Seq[Array[Int]], remain: Int) = {
    if ((homeworks map {_.copy}).sum > remain) -1 // 全部copyしても終わらない
    else {
      @scala.annotation.tailrec
      def doCopy(hws:Seq[Homework], remain: Int): Seq[Homework] = {
        if (remain <= 0) hws // これ以上copyする必要がない
        else doCopy(hws.tail, remain - hws.head.diff)
      }
      homeworks.size - doCopy(homeworks, (homeworks map {_.self}).sum - remain).size
    }
  }

  case class Homework(self: Int, copy: Int) extends Ordered[Homework]{
    val diff = self - copy
    override def compare(that: Homework): Int = that.diff - diff
  }
}
