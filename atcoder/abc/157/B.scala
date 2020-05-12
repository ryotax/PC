object Main extends App {
  val in = new java.util.Scanner(System.in)
  val A = Array.fill(9)(in.nextInt)
  val N = in.nextInt

  (1 to N).foreach {i =>
    val b = in.nextInt
    A.indexWhere(_ == b) match {
      case -1 =>
      case n => A(n) = 0
    }
  }

  val bingos: Seq[Seq[Int]] =
    Seq(0, 4, 8) :: Seq(2, 4, 6) :: (0 to 2).flatMap { i =>
      Seq((0 to 2).map(j => j + i * 3), (0 to 2).map(j => j * 3 + i))
    }.toList

  println(if (bingos.exists(_.forall(A(_) == 0))) "Yes" else "No")
}
