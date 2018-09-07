object Main {
  def main(args: Array[String]) {
    val Array(num, minimum, maximum) = readLine.split(" ") map {_.toInt}
    println(
      move(0, num) match {
        case 0 => "0"
        case pos if pos > 0 => s"East $pos"
        case pos => s"West ${pos * -1}"
      })

    @scala.annotation.tailrec
    def move(pos: Int, n: Int): Int = n match {
        case 0 => pos
        case _ => {
          val Array(dir, sD) = readLine.split(" ")
          val d = (sD.toInt min maximum max minimum) * (if (dir == "East") 1 else -1)
          move(pos + d, n - 1)
        }
    }
  }
}


