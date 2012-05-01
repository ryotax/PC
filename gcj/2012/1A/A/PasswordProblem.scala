import scala.io.Source

val problems = scala.collection.mutable.ListBuffer.empty[(Int, Int, Seq[Double])]
parseProblems(Source.fromFile("A-large-practice.in").getLines.toList.tail)

problems.zipWithIndex.par.map(z => (z._2, resolve(z._1._1, z._1._2, z._1._3))).toList
			.sortBy(_._1)
			.foreach(z => println("Case #" + (z._1 + 1) + ": " + z._2))

@scala.annotation.tailrec
def parseProblems(lines: Seq[String]): Unit = {
	if (lines.isEmpty) {
		return
	}

	val a_b = lines.head.split(" ").map(_.toInt)
	val p = lines.tail.head.split(" ").map(_.toDouble).toList.scanLeft(1.0)((t, c) => t * c)
	problems += ((a_b(0), a_b(1), p))
	parseProblems(lines.tail.tail)
}


def resolve(a: Int, b: Int, p: Seq[Double]): Double = {
	def calc(i: Int): Double = {
		val nBs = a - i
		val nRetype = b - i

		p(i) * (nBs + nRetype + 1) + (1 - p(i)) * (nBs + nRetype + 1 + b + 1)
	}

	@scala.annotation.tailrec
	def calcAll(i: Int, minExp: Double): Double = {
		if (i > a) {
			minExp
		} else {
			calcAll(i + 1, math.min(minExp, calc(i)))
		}
	}

	calcAll(0, 1 + b + 1)
}
