object Main {
  def main(args: Array[String]) {
    val cs = (Array.fill(readInt) {readInt}).sorted.reverse
    println((cs.zipWithIndex map {case (r, i) => r * r * (if (i % 2 == 0) 1 else -1)}).sum * Math.PI)
  }
}

