import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n, k = sc.nextInt
  val s = sc.next
  val sizes = {
    var ss = s.split("((?!1)(?<=1)|(?!0)(?<=0))").map(_.size)
    if (s.head == '0') ss = 0 +: ss
    if (s.last == '0') ss = ss :+ 0
    ss
  }

  def search(max: Int, pre: Int, i: Int): Int = {
    if (i + k * 2 > sizes.size) max
    else {
      val cur = pre - sizes(i - 2) - sizes(i - 1) + sizes(i + k * 2 - 1) + sizes(i + k * 2)
      search(Math.max(max, cur), cur, i + 2)
    }
  }
  val first = sizes.take(k * 2 + 1).sum
  println(search(first, first, 2))
}
