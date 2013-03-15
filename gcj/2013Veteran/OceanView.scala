import scala.io.Source

val f = Source.fromFile("C-large-practice.in")
val testData: List[String] = f.getLines
                              .toList
                              .tail
                              .zipWithIndex
                              .filter(_._2 % 2 == 1)
                              .map(_._1)

var i = 0

testData.zipWithIndex.foreach {
  case (data, i) => {
    println(s"Case #${i + 1}: ${calc(data)}")
  }
}


def calc(data: String) = {
  val houses = data.split(" ").map(_.toInt)
  var memo = new Array[Int](1001)

  houses.foreach(h => {
    memo(h) = memo.take(h).max + 1
  })

  houses.size - memo.max
}

