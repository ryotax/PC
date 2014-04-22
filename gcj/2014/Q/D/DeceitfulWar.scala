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
  var kenRemain = ken.toBuffer
  naomi count {n =>
    kenRemain indexWhere {_ < n} match {
      case -1 =>
        kenRemain.trimEnd(1)
        false
      case i =>
        kenRemain.remove(0)
        true
    }
  }
}

def honest(ken: Seq[Double], naomi: Seq[Double]): Int = {
  var kenRemain = ken.toBuffer
  naomi count {n =>
    kenRemain indexWhere {_ > n} match {
      case -1 =>
        kenRemain.remove(0)
        true
      case i =>
        kenRemain.remove(i)
        false
    }
  }
}
