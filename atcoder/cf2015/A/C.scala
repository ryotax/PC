import scala.io.StdIn.readLine

object C {
  def main(args: Array[String]) {
val now = System.nanoTime
    val Array(n, t) = scala.io.StdIn.readLine.split(" ") map {_.toInt}
    val homeworks = (1 to n) map {i =>
      val arr = scala.io.StdIn.readLine.split(" ")
      Homework(arr(0).toInt, arr(1).toInt)
    }
println(System.nanoTime - now)

    println(exec(homeworks.sorted.toList, t))
println(System.nanoTime - now)
  }

  def exec(homeworks: Seq[Homework], remain: Int) = {
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
