import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val s = sc.next
  val (l, r) = s.splitAt(2)
  def mon(i: Int): Boolean = 1 <= i && i <= 12
  println((mon(l.toInt), mon(r.toInt)) match {
    case (true, true) => "AMBIGUOUS"
    case (true, false) => "MMYY"
    case (false, true) => "YYMM"
    case (false, false) => "NA"
  })
}
