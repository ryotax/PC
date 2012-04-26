import scala.io.Source


class TestCase(val nCard: Int, val pos: Int, sShuffles: Seq[String]) {
  val shuffles = sShuffles.map(s => {
    val a_b = s.split(" ").map(_.toInt)
    (a_b(0), a_b(1))
  })
}

@scala.annotation.tailrec
def parseInput(lines: List[String], seq: Seq[TestCase]): Seq[TestCase] = {
  if (lines.isEmpty) {
    seq
  } else {
    val m_c_w = lines.head.split(" ").map(_.toInt)
    val m = m_c_w(0)
    val c = m_c_w(1)
    val w = m_c_w(2)
    parseInput(lines.drop(c + 1), seq :+ new TestCase(m, w, lines.tail.take(c)))
  }
}

def count(test: TestCase) = {
  def rev(i: Int, n: Int, pos: Int) = {
    if (pos <= n) {
      pos + i - 1
    } else if (pos <= n + i - 1) {
      pos - n
    } else {
      pos
    }
  }

  test.shuffles.reverse.foldLeft (test.pos) {
    (pos, ope) => rev(ope._1, ope._2, pos)
  }
}

val input = Source.fromFile("A-large-practice.in")
try {
  var n = 1
  val tests = parseInput(input.getLines.toList.tail, Nil)
  tests.foreach(test => {
    println("Case #" + n + ": " + count(test))
    n += 1
  })
} finally {
  input.close
}
