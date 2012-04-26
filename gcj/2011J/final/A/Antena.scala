import scala.io.Source

val input = Source.fromFile("A-large-practice.in")
// val l = input.getLines.toList.tail.zipWithIndex.withFilter(z => z._2 % 2 == 1).map(_._1)
val l = parse(input.getLines.toList.tail).map(sort).map(calcArea)

def parse(l: List[String]): List[List[Int]] = {
	l match {
	case n :: antenas :: remain =>
		antenas.split(" ").toList.map(_.toInt) :: parse(remain)
	case _ =>
		Nil
	}
}

def sort(l: List[Int]) = {
	val (lhs, rhs) = l.sorted.zipWithIndex.partition(_._2 % 2 == 1)
	lhs.map(_._1) ++ rhs.map(_._1).reverse
}

def calcArea(l: List[Int]) = {
	val angleSin = math.sin(math.Pi * 2 / l.size)
	l.zip(l.tail).foldLeft(l.last * l.head * angleSin / 2) ((sum, cur) =>
		sum + cur._1 * cur._2 * angleSin / 2
	) 
}

def format(l: List[Double]) = {
	var i = 1
	for (d <- l) {
		println("Case #" + i + ": " + d)
		i += 1
	}
}

format(l)
