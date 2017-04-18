val numCases = readLine().toInt

for (i <- 1 to numCases) {
  val line = readLine().split(" ").map(_.toInt)
  val initialSize = line(0)
  val motes = readLine().split(" ").map(_.toInt)

  println("Case #" + i + ": " + solve(initialSize, motes.toList.sorted))
}

def solve(size: Int, motes: List[Int]): Long = motes match {
  case Nil => 0
  case h::t =>
    if (size == 1) return motes.size
    if (h < size) solve(size + h, t)
    else {
      var insert = 0
      var newSize = size
      while (newSize <= h) {
        newSize = newSize * 2 - 1
        insert += 1
      }
      (motes.size.toLong).min(insert + solve(newSize + h, t))
    }
}

