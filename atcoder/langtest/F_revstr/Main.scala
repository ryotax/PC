object Main {
  def main(args: Array[String]) {
    println(rev(readLine, readInt))

    @scala.annotation.tailrec
    def rev(s: String, n: Int): String = n match {
        case 0 => s
        case _ => {
          val Array(from, to) = readLine.split(" ") map {_.toInt}
          rev(s.substring(0, from - 1) + s.substring(from - 1, to).reverse + s.substring(to), n - 1)
        }
    }
  }
}

