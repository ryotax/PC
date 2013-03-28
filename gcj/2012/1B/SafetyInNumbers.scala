import scala.io.Source

val f = Source.fromFile("A-large-practice.in")
val testData: List[String] = f.getLines
                              .toList
                              .tail

testData.zipWithIndex.foreach {
  case (data, i) => {
    println(s"Case #${i + 1}: ${calc(data.split(" ").map(_.toInt).toList.tail).mkString(" ")}")
  }
}

def calc(points: List[Int]): List[Double] = {
  val sum = points.sum + 0.0

  val min = points.sorted
                  .reverse
                  .tails
                  .collectFirst {
                    case l if (sum + l.sum) / l.size >= l.head => l.head + 0.0
                  }.getOrElse(0.0)

  val thre = (points.filter(_ <= min).sum + sum) / points.filter(_ <= min).size

  points.map {
    case p if p > thre => 0
    case p => (thre - p) / sum * 100
  }
}
