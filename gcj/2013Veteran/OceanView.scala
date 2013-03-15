import scala.io.Source

val f = Source.fromFile("C-large-practice.in")
val testData: List[String] = f.getLines
                              .toList
                              .tail
                              .zipWithIndex
                              .filter(_._2 % 2 == 1)
                              .map(_._1)

testData.zipWithIndex.foreach {
  case (data, i) => {
    println(s"Case #${i + 1}: ${calcOneline(data.split(" ").map(_.toInt))}")
  }
}


def calc(houses: Array[Int]) = {
  var memo = new Array[Int](1001)

  houses.foreach(h => {
    memo(h) = memo.take(h).max + 1
  })

  houses.size - memo.max
}

def calcOneline(houses: Array[Int]) = {
  houses.size - (houses.foldLeft(new Array[Int](1001)) {(z, n) => z.updated(n, z.take(n).max + 1)}).max
}

