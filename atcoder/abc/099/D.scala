object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, C = in.nextInt
  val Dxy = Array.fill(C)(Array.fill(C)(in.nextInt))
  val grid: Array[List[Int]] = Array.fill(3)(Nil)

  for {
    r <- 0 until N
    c <- 0 until N
  } {
    grid((r + c) % 3) = in.nextInt :: grid((r + c) % 3)
  }

  val gridColorChanges: Array[Array[Int]] = {
    grid.map { colors =>
      val colorSizes: List[(Int, Int)] = colors.groupBy(i => i - 1).view.mapValues(_.size).toList
      (0 until C).map(to => colorSizes.map{case (from, size) => Dxy(from)(to) * size}.sum).toArray
    }
  }

  val min = (for {
    p0 <- 0 until C
    p1 <- 0 until C
    if p0 != p1
    p2 <- 0 until C
    if p0 != p2 && p1 != p2
  } yield {
    gridColorChanges(0)(p0) + gridColorChanges(1)(p1) + gridColorChanges(2)(p2)
  }).min
  println(min)
}
