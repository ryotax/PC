case class Digit(key: Char, str: String, num: String)
val Digits = List(
  Digit('Z', "ZERO", "0"),
  Digit('W', "TWO", "2"),
  Digit('U', "FOUR", "4"),
  Digit('X', "SIX", "6"),
  Digit('G', "EIGHT", "8"),

  Digit('O', "ONE", "1"),
  Digit('H', "THREE", "3"),
  Digit('F', "FIVE", "5"),
  Digit('S', "SEVEN", "7"),

  Digit('I', "NINE", "9"))

def toNum0(s: String, d: Digit) = {
  val n = s.count(_ == d.key)
  (s.diff(d.str * n), d.num * n)
}

@scala.annotation.tailrec
def toNum(digits: List[Digit], str: String, num: String = ""): String = {
  digits match {
    case Nil => num.sorted
    case x :: xs => 
      val (remain, n) = toNum0(str, x)
      toNum(xs, remain, num + n)
  }
}

(1 to readInt) foreach {i => println(s"Case #${i}: ${toNum(Digits, readLine)}")}
