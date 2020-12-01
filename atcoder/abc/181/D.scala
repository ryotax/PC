object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next

  val able = 
    if (S.size <= 2) S.toInt % 8 == 0 || S.reverse.toInt % 8 == 0
    else (1 to 124)
          .map(i => f"${(i * 8)}%03d".toSeq)
          .filterNot(_.contains('0'))
          .exists(_.intersect(S).size == 3)

  println(if (able) "Yes" else "No")
}
