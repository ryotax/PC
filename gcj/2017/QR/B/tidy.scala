import scala.io.StdIn._

def count(n: String): Long = {
  @scala.annotation.tailrec
  def exec(nums: Array[Char], pos: Int): Long = {
    if (pos == nums.size - 1) {
      new String(nums.reverse).toLong
    } else {
      if (nums(pos) < nums(pos + 1)) {
        (0 to pos) foreach {i => nums(i) = '9'}
        nums(pos + 1) = (nums(pos + 1) - 1).toChar
      }
      exec(nums, pos + 1)
    }
  }

  exec(n.reverse.toArray, 0)
}

val n = readInt
(1 to n) foreach {i =>
  println(s"Case #${i}: ${count(readLine)}")
}

