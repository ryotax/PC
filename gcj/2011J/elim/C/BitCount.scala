import scala.io.Source

val input = Source.fromFile("C-large-practice.in")
try {
	var n = 1
	input.getLines.toList.tail.map(line => {
		println("Case #" + n + ": " + bitCount(line.toLong))
		n += 1
	})
} finally {
	input.close
}

def bitCount(n: Long):Int = {
	var cur = n
	var count = 0
	var firstZero = true

	while (cur != 0) {
		count += ((firstZero, cur & 1) match {
					case (true, 0) =>
						firstZero = false
						2
					case (false, 0) =>
						1
					case (true, 1) =>
						1
					case (false, 1) =>
						if ((cur >> 1) == 0) 0 else 2
				})
		cur = cur >> 1
	}

	count
}
