import scala.io.Source

val problems = scala.collection.mutable.ListBuffer.empty[Seq[Level]]
// parseProblems(Source.fromFile("sample.in").getLines.toList.tail)
// parseProblems(Source.fromFile("B-small-practice.in").getLines.toList.tail)
parseProblems(Source.fromFile("B-large-practice.in").getLines.toList.tail)

problems.zipWithIndex.par.map(z => (z._2, resolve(0, 0, z._1))).toList
			.sortBy(_._1)
			.foreach(z => println("Case #" + (z._1 + 1) + ": " + z._2.getOrElse("Too Bad")))


def parseProblems(lines: Seq[String]): Unit = {
	if (lines.isEmpty) return
	val n = lines.head.toInt
	val (current, nexts) = lines.tail.splitAt(n)
	problems += current.map(c => {
		val r1_r2 = c.split(" ").map(_.toInt)
		new Level(r1_r2(0), r1_r2(1))
	})
	parseProblems(nexts)
}

def resolve(count: Int, stars: Int, levels: Seq[Level]): Option[Int] = {
	// System.out.println(count + ":" + stars + ":" + levels)
	if (levels.isEmpty) {
		Option(count)
	} else {
		val (cleared, not) = levels.partition(l => l.star2R <= stars)
		if (cleared.isEmpty) {
			val candidate = levels.filter(l => !l.clear1 && l.star1R <= stars)
						.sortBy(_.star2R).lastOption
			candidate match {
				case Some(l) => {
					l.clear
					resolve(count + 1, stars + 1, levels)
					}
				case _ => None
			}
		} else resolve(count + cleared.size, stars + cleared.map(_.stars).sum, not)
	}
}

class Level(val star1R: Int, val star2R: Int) {
	var clear1 = false

	def clear {
		clear1 = true
	}

	def stars: Int = {
		if (clear1) 1
		else 2
	}

	override def toString() = {
		star1R + ":" + star2R + ":" + clear1
	}
}
