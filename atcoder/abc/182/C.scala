object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.next
  val map = N.toSeq.groupBy(_ % 3).view.mapValues(_.size).toMap.withDefaultValue(0)

  println((N.toLong % 3) match {
    case 0 => 0
    case 1 =>
      if (map(1) >= 1 && N.size >= 2) 1
      else if (map(2) >= 2 && N.size >= 3) 2
      else -1
    case 2 =>
      if (map(2) >= 1 && N.size >= 2) 1
      else if (map(1) >= 2 && N.size >= 3) 2
      else -1
  })
}
