object Main {

  def main(args: Array[String]) {
    readInt
    val ca = readLine.toCharArray
    for (i <- 0 until readInt) {
      val Array(i, last) = readLine.split(" ") map {_.toInt - 1}
      println(if (check(ca, i, last)) "Yes" else "No")
    }
  }

  def check(ca: Array[Char], i: Int, last: Int, bits: BigInt = BigInt(1)): Boolean = {
    val newBits = ca(i) match {
      case ')' => bits >> 1
      case '(' => bits << 1
      case '?' => bits << 1 | bits >> 1
    }
    // println(s"${bits.toString(2)} -> ${ca(i)} -> ${newBits.toString(2)}")

    if (newBits == 0) false
    else if (i == last) (newBits & 1) == 1
    else check(ca, i + 1, last, newBits)
  }
}
