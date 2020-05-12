object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val accepted = Array.fill(N)(0)
  val (ac, pe) = (1 to M).foldLeft((0, 0)){case ((ac, pe), i) =>
    val p = in.nextInt - 1
    val s = in.next

    (accepted(p), s) match {
      case (-1, _) => (ac, pe)
      case (n, "AC") =>
        accepted(p) = -1
        (ac + 1, pe + n)
      case (_, _) =>
        accepted(p) += 1
        (ac, pe)
    }
  }

  println(s"$ac $pe")
}
