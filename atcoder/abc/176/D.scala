object Main extends App {
  case class Point(x: Int, y: Int) {
    def walks: List[Point] = List(
      Point(x + 1, y),
      Point(x - 1, y),
      Point(x, y + 1),
      Point(x, y - 1),
    )

    def warps: List[Point] = (for {
      x <- -2 to 2
      y <- -2 to 2
      if math.abs(x) + math.abs(y) > 1
    } yield(Point(x, y))).toList
  }

  val in = new java.util.Scanner(System.in)
  val H, W = in.nextInt
  val s = Point(in.nextInt + 1, in.nextInt + 1)
  val g = Point(in.nextInt + 1, in.nextInt + 1)

  val Wall = "#" * (W + 4)
  val maze = Wall :+ Wall :+ Array.fill(H)("##" + in.next + "##") +: Wall +: Wall

  def search(i: Int, ps: Queue[Point]): Int = {
    val nexts = new Queue[Point]
    while(ps.nonEmpty) {
      val p = ps.pop()
      val ws = p.walks
      if (ws.contains(g)) i
      else {
        ws.foreach {w =
          maze(w.x)(w.y) match {
            case "." =>
              maze(w.x)(w.y) = i
              ps.push(w)
            case _ => 
          }
        }
      }
    }
  }
}
