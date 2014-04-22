import java.util.Scanner
import java.io.File

val sc = new Scanner(new File("large.in"))

(1 to sc.nextInt) foreach {n =>
  val i = sc.nextInt
  val naomi = (Stream.tabulate(i) {x => sc.nextDouble}).sorted
  val ken = (Stream.tabulate(i) {x => sc.nextDouble}).sorted
  println(s"Case #$n: ${deceitful(ken, naomi)} ${honest(ken, naomi)}")
}


def deceitful(ken: Seq[Double], naomi: Seq[Double]): Int = {
  var result = 0
  var kenRemain = ken
  naomi foreach {n =>
    if (kenRemain.head < n) {
      result += 1
      kenRemain = kenRemain.tail
    } else {
      kenRemain = kenRemain.init
    }
  }
  return result
}

def honest(ken: Seq[Double], naomi: Seq[Double]): Int = {
  var result = 0
  var kenRemain = ken
  naomi foreach {n =>
    val (low, high) = kenRemain partition {k => k < n}
    if (high.isEmpty) {
      result += 1
      kenRemain = low.tail
    } else {
      kenRemain = low ++ high.tail
    }
  }
  return result
}
