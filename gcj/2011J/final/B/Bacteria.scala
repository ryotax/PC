import scala.io.Source

val l = Source.fromFile("sample.in").getLines.toList.tail

def parse(l: List[String]) = {
	l.map(s => {
		val sa = s.split(" ").map(_.toInt)
		new Input(sa(0), sa(1), sa(2))
	})
}

def calc(i: Input) = {
	val after1h = i.nInit * i.nInit
	println(after1h)
	if (i.nH == 1) {
		after1h % i.r
	} else {
		Stream.continually(after1h).take(after1h).reduceLeft((rem, cur) => (rem * cur) % i.r)
	}
}

case class Input(nInit: Int, nH: Int, r: Int)

println(parse(l).map(calc))
