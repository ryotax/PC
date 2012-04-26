import scala.io.Source

// val input = Source.fromFile("C-small-practice.in")
val input = Source.fromFile("C-large-practice.in")
// val input = Source.fromFile("sample.in")
val memo = scala.collection.mutable.Map[Int, Set[Int]]()

val answers = input.getLines.toList.tail.map(line => {
		val ab = line.split(" ").map(_.toInt)
		count(ab(0), ab(1))
	})

answers.zipWithIndex.foreach(z => println("Case #" + (z._2 + 1) + ": " + z._1))

def count(a: Int, b: Int) = {
	val ret = (a to b).map(n => {
			val recycled =
				if (memo.contains(n)) {
					memo(n)
				} else {
					val s = n.toString
					val r = s.indices.tail
							.map(i => (s.substring(i) + s.substring(0, i)).toInt)
							.filter(_ <= 2000000)
							.toSet
					memo.put(n, r)
					r
				}

			recycled.count(x => n < x && x <= b)
		}).sum
	println(a + ", " + b + " done!")
	ret
}
