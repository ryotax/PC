import scala.io.Source

val f = Source.fromFile("D-small-practice.in")
var n = 1
doMain(f.getLines.toList.tail)

@scala.annotation.tailrec
def doMain(lines: List[String]): Unit = {
	if (lines.size == 0) return
	val params = lines.head.split(" ").map(_.toInt)
	val max = params(2)
	val origField = lines.tail.take(params(0)).init.tail.map(_.tail.init)
	val wRepeat = math.ceil(max.toDouble / origField.head.length).toInt
	val hRepeat = math.ceil(max.toDouble / origField.size).toInt
	val memo = scala.collection.mutable.Set[(Int, Int)]()
	println("Case #" + n + ": " + count(copiedStarts(widen(origField)), startPosition(origField)))
	n += 1

	def count(targets: Seq[(Int, Int)], start: (Int, Int)) = {
		targets.count(t => {
			if (start != t) {
				val diffX = t._2 - start._2
				val diffY = t._1 - start._1
				val GCM = gcm(math.abs(diffY), math.abs(diffX))
				val memoKey = (diffX / GCM, diffY / GCM)
				if (diffX * diffX + diffY * diffY <= max * max) {
					memo.add(memoKey)
				} else false
			} else false
		})
	}

	@scala.annotation.tailrec
	def gcm(l: Int, m: Int): Int = if (m == 0) l else gcm(m, l % m)

	def widen(field: List[String]): Seq[String] = {
		def widenWidth(field: List[String]) = {
			field map (u => {
				val rep: List[String] = Stream.continually(List(u.reverse, u)).flatten.take(wRepeat).toList
				(rep.reverse ::: u :: rep).mkString("")
			})
		}
		def widenHeight(field: List[String]) = {
			val rep = Stream.continually(List(field.reverse, field)).flatten.take(hRepeat).toList
			rep.reverse ::: field :: rep
		}
		widenHeight(widenWidth(field)).flatten
	}

	def startPosition(field: List[String]): (Int, Int) = {
		val hMin = hRepeat * field.size
		val wMin = wRepeat * field.head.length
		val r = field.indexWhere(_.contains("X"))
		val c = field(r).indexOf('X')
		(hMin + r, wMin + c)
	}

	def copiedStarts(field: Seq[String]): Seq[(Int, Int)] = {
		field.zipWithIndex.map(row => {
			row._1.zipWithIndex.map(col => {
				col._1 match {
					case 'X' => Option((row._2, col._2))
					case _ => None
				}
			}).flatten
		}).flatten
	}

	doMain(lines.drop(1 + params(0)))
}
