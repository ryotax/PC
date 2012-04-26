import scala.io.Source

val input = Source.fromFile("C-large-practice.in")
try {
	val l = input.getLines.toList.tail.foldLeft((List[(String, String)](), None: Option[String])) (
		(result, line) => {
			result._2 match {
				case Some(prev) => (result._1 :+ (prev, line), None)
				case None => (result._1, Some(line))
			}
		})._1

	var n = 1
	l.map(rkn_g => {
		println("Case #" + n + ": " + count(rkn_g._1, rkn_g._2))
		n += 1
	})
} finally {
	input.close
}

def sum(gs: Seq[Seq[Group]]) = gs.flatten.foldLeft (0L) ((sum, cur) => sum + cur.num)

def count(rkn: String, g: String): Long = {
	val r_k_n = rkn.split(" ")
	val gs = g.split(" ")
	val nRun = r_k_n(0).toInt
	val capacity = r_k_n(1).toInt

	val (rided, loopStart, nLoopUnit, sales) = findLoop(capacity, gs.map(i => new Group(i.toLong)))

	val nLoop = (nRun - loopStart) / nLoopUnit
	val nRemain = nRun - nLoopUnit * nLoop
	sum(rided.take(nRemain.toInt)) + nLoop * sales
}

def findLoop(capacity: Int, gs: Seq[Group]): (Seq[Seq[Group]], Long, Long, Long) = {
	@scala.annotation.tailrec
	def loopUnit(rided: Seq[Seq[Group]], waited: Seq[Group]): (Seq[Seq[Group]], Long, Long, Long) = {
		var c = 0L
		val first = waited.head
		val (riding, waiting): (Seq[Group], Seq[Group]) = waited.span(g => {
			c += g.num
			c <= capacity && (c == g.num || g != first)
		})

		val index = rided.indexOf(riding)
		if (index == -1) {
			loopUnit(rided :+ riding, waiting)
		} else {
			val loopStart = index
			val nLoopUnit = rided.size - index
			val sales = sum(rided.drop(index))
			(rided, loopStart, nLoopUnit, sales)
		}
	}

	loopUnit(Nil, Stream.continually(gs).flatten)
}

class Group(val num: Long) {override def toString = num.toString}
