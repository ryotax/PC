import scala.io.Source
import scala.annotation.tailrec



val palindromes: Seq[Long] = (1L to 4000000L).filter(i => (palindrome(i) && palindrome(i * i))).map(i => i * i)

def palindrome(i: Long) = {
  val s = i.toString
  val (pre, post) = s.splitAt(s.size / 2)
  pre == post.reverse.take(pre.size)
}

var n = 1
val input = Source.fromFile("C-small-attempt.in")
                  .getLines
                  .toList
                  .tail
                  .foreach {line =>
                    val Array(from, to) = line.split(" ").map(_.toLong)
                    println("Case #" + n + ": " + count(from, to))
                    n+=1
                  }

def count(from: Long, to: Long) = {
  palindromes.dropWhile(_ < from)
             .takeWhile(_ <= to)
             .size
}
