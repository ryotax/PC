object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n, m = in.nextInt
  val as = Array.fill(m)(in.nextInt)
  case class Match(num: Int, sticks: Int)
  val matches = Array(0,2,5,5,4,5,6,3,7,6).zipWithIndex.map{case (s, i) => Match(i, s)}
  val availables = as.map(matches).sortBy(_.num).reverse

  val digits = {
    val availableSticks = availables.map(_.sticks).distinct
    val ret = Array.fill(n + 1)(-1)
    ret(0) = 0

    for {
      i <- 1 to n
      s <- availableSticks
      if i >= s
    } ret(i) = Math.max(ret(i), ret(i - s) + 1)

    ret
  }

  def search(i: Int, d: Int, result: List[Int]): List[Int] = {
    if (d == 0) result.reverse
    else {
      val cond: Int => Boolean = s => i >= s && digits(i - s) == d - 1
      val target = availables.find(m => cond(m.sticks)).get
      search(i - target.sticks, d - 1, target.num :: result)
    }
  }

  println(search(n, digits(n), Nil).mkString)
}
