import scala.io.Source

// val input = Source.fromFile("C-small-practice.in")
val input = Source.fromFile("C-large-practice.in")
// val input = Source.fromFile("sample.in")

val divisors:Stream[Int] = 10 #:: divisors.map(_ * 10)

val answers = input.getLines.toList.tail.map(line => {
		val ab = line.split(" ").map(_.toInt)
		count(ab(0), ab(1))
	})

answers.zipWithIndex.foreach(z => println("Case #" + (z._2 + 1) + ": " + z._1))

def count(a: Int, b: Int) = {
	val ret = (a to b).map(n => {
			val order = math.pow(10, n.toString.length).toInt
			val recycled = divisors.takeWhile(_ <= b)
						.map(d => (n % d) * (order / d) + (n / d))
						.toSet

			recycled.count(x => n < x && x <= b)
		}).sum
	// println(a + ", " + b + " done!")
	ret
}

