import scala.io.Source

val f = Source.fromFile("A.small")
val testData: List[String] = f.getLines
                              .toList
                              .tail
                              .zipWithIndex
                              .filter(_._2 % 2 == 1)
                              .map(_._1)

var i = 0
testData.foreach {data =>
  i += 1
  println(s"Case #${i}: ${calc(data)}")
}

def calc(data: String) = {
  data.split(" ")
      .map(_.toDouble)
      .tails
      .map(_.take(2))
      .takeWhile(_.size == 2)
      .foldLeft (0.0d) {
        case (0.0d, Array(left, center)) => left // first
        case (left, Array(center, right)) => Math.min((left + right) / 2, center) // other
      }
}
