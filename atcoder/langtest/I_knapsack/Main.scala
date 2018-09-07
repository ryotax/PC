object Main {
  case class Baggage(value: Int, weight: Int) { // 10^9 + 10^9 < 2^31 -1
    def add(other: Baggage) = Baggage(value + other.value, weight + other.weight)
  }

  def main(args: Array[String]) {
    val Array(n, capacity) = readLine.split(" ") map {_.toInt}

  }

  @scala.annotation.tailrec
  def dp(tbl: List[Baggage], n: Int): Int = n match {
    val b = toBaggage(readLine)

    add(b)
    tbl foreach {add(_.add(b))}
  }

  def toBaggage(line: String) = line.split(" ") match {case Array(v, w) => Baggage(v.toLong, w.toLong)}
}


