import scala.io.Source

// val input = Source.fromFile("C-small-practice.in")
val input = Source.fromFile("C-large-practice.in")
// val input = Source.fromFile("sample.in")

val divisors:Stream[Int] = 10 #:: divisors.map(_ * 10)

val answers = input.getLines.toList.zipWithIndex.tail.par.map(line => {
		val ab = line._1.split(" ").map(_.toInt)
		(line._2, count(ab(0), ab(1), 0))
	})

answers.toList.sorted.foreach(z => println("Case #" + z._1 + ": " + z._2))

@scala.annotation.tailrec
def count(a: Int, b: Int, sum: Int): Int = {
	if (a <= b) {
		val order = math.pow(10, a.toString.length).toInt
		val memo = scala.collection.mutable.Set[Int]()
		val num = divisors.takeWhile(_ <= b)
						.count(d => {
							val n = (a % d) * (order / d) + (a / d)
							val ret = a < n && n <= b && !memo.contains(n)
							memo.add(n)
							ret
						})
		count(a + 1, b, sum + num)
	} else {
		sum
	}
}

