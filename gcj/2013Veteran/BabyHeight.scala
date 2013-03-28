import scala.io.Source

val f = Source.fromFile("B.small")
val testData: List[String] = f.getLines
                              .toList
                              .tail

val regexp = """(\d+)'(\d+)"$""".r
var i = 0

testData.zipWithIndex.foreach {
  case (data, i) => {
    val (h, l) = calc(data)
    println(s"Case #${i + 1}: ${l} to ${h}")
  }
}


def toInch(s: String): Int = {
  s match {
    case regexp(feet, inch) => feet.toInt * 12 + inch.toInt
  }
}

def toFeetInch(inch: Double, alg: Double => Double): String = {
  // https://issues.scala-lang.org/browse/SI-6476
  s"""${(inch / 12).toInt}'${alg(inch % 12).toInt}\""""
}

def calc(data: String) = {
  data.split(" ") match {
    case Array(gender, mom, dad) => {
      val height = (toInch(mom) + toInch(dad) + (if (gender == "B") 5 else -5)).toDouble / 2
      (toFeetInch(height + 4, Math.floor), toFeetInch(height - 4, Math.ceil))
    }
  }
}
