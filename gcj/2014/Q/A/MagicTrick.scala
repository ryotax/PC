import java.util.Scanner

val sc = new Scanner(new java.io.File("A-small-attempt0.in"))

(1 to sc.nextInt) foreach {num =>
  val row1 = readRow(sc, sc.nextInt)
  val row2 = readRow(sc, sc.nextInt)
  val result = row1.intersect(row2) match {
    case Array() => "Volunteer cheated!"
    case Array(n) => n.toString
    case _ => "Bad magician!"
  }
  println(s"Case #${num}: $result")
}

def readRow(sc: Scanner, row: Int) = {
  val arr = Array.tabulate(4, 4){(x, y) => sc.nextInt()}
  arr(row - 1)
}
