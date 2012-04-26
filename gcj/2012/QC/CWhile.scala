import scala.io.Source

// val input = Source.fromFile("C-small-practice.in")
val input = Source.fromFile("C-large-practice.in")
// val input = Source.fromFile("sample.in")

val divisors:Stream[Int] = 10 #:: divisors.map(_ * 10)

val answers = input.getLines.toList.zipWithIndex.tail.par.map(line => {
		val ab = line._1.split(" ").map(_.toInt)
		(line._2, count(ab(0), ab(1)))
	})

answers.toList.sorted.foreach(z => println("Case #" + z._1 + ": " + z._2))

def count(a: Int, b: Int) = {
	var i = a
	var sum = 0;
	while (i <= b) {
		val order = math.pow(10, i.toString.length).toInt
		val memo = scala.collection.mutable.Set[Int]()
		sum += divisors.takeWhile(_ <= b)
						.count(d => {
							val n = (i % d) * (order / d) + (i / d)
							val ret = i < n && n <= b && !memo.contains(n)
							memo.add(n)
							ret
						})
		i += 1
	}
	// println(a + ", " + b + " done!")
	sum
}

