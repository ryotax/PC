object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val S = in.next

  def count(at: Int, cg: Int, cur: Int, sum: Int): Int = {
    if (cur == N) sum
    else {
      val (newAt, newCg) = S.charAt(cur) match {
        case 'A' => (at + 1, cg)
        case 'T' => (at - 1, cg)
        case 'C' => (at, cg + 1)
        case 'G' => (at, cg - 1)
      }
      count(newAt, newCg, cur + 1, sum + (if (newAt == 0 && newCg == 0) 1 else 0))
    }
  }

  println((0 to N - 1).map{i => count(0, 0, i, 0)}.sum)
}
