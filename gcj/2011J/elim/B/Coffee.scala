import scala.io.Source

class TestCase(val k: Long, sCoffies: Seq[String]) {
  val coffees = sCoffies.map(s => {
    val c_t_s = s.split(" ").map(_.toLong)
    new Coffee(c_t_s(0), c_t_s(1), c_t_s(2))
  })
}

class Coffee(var n: Long, val limit: Long, val satisfied: Long)

@scala.annotation.tailrec
def parseInput(lines: List[String], seq: Seq[TestCase]): Seq[TestCase] = {
  if (lines.isEmpty) {
    seq
  } else {
    val n_k = lines.head.split(" ").map(_.toLong)
    val n = n_k(0).toInt
    val k = n_k(1)
    parseInput(lines.drop(n + 1), seq :+ new TestCase(k, lines.tail.take(n)))
  }
}

@scala.annotation.tailrec
def maxSatisfied(sum: Long, limit: Long, coffees: Seq[Coffee]): Long = {
  if (limit == 0) {
    sum
  } else {
    val consumable = coffees.filter(c => c.limit >= limit && c.n > 0)
    if (consumable.isEmpty) {
      val nextCandidates = coffees.filter(_.n > 0)
      val nextLimit = (0L +: nextCandidates.map(_.limit)).max // 0L is dummy for Nil
      maxSatisfied(sum, nextLimit, coffees)
    } else {
      val consumed = consumable.maxBy(_.satisfied)
      val nextCandidates = coffees.filter(c => c.ne(consumed)
                                    && c.n > 0
                                    && c.satisfied > consumed.satisfied)
      val nextCoffee = (new Coffee(0L, 0L, 0L) +: nextCandidates).maxBy(_.limit) // new Coffee is dummy for Nil
      val consumedAmount = math.min(consumed.n, limit - nextCoffee.limit)
      consumed.n -= consumedAmount
      maxSatisfied(sum + consumed.satisfied * consumedAmount, limit - consumedAmount, coffees)
    }
  }
}

val input = Source.fromFile("B-large-practice.in")
try {
  var n = 1
  val tests = parseInput(input.getLines.toList.tail, Nil)
  tests.foreach(test => {
    println("Case #" + n + ": " + maxSatisfied(0, test.k.toLong, test.coffees))
    n += 1
  })
} finally {
  input.close
}
