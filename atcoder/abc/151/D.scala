object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, W = in.nextInt
  val Maze = Array.fill(H)(in.next.toCharArray)

  println((for {
    y <- 0 until H
    x <- 0 until W
  } yield max(P(x, y))).max)

  case class P(x: Int, y: Int) {
    def nexts(maze: Array[Array[Char]]): List[P] = 
      List(P(x + 1, y), P(x - 1, y), P(x, y + 1), P(x, y - 1))
        .filter(p => 0 <= p.x && p.x < W && 0 <= p.y && p.y < H && maze(y)(x) == '.')
  }

  def max(s: P): Int = {
    val maze = Maze.map(_.clone)

    def step(curs: List[P], n: Int): Int = {
      if (curs.isEmpty) n - 2
      else {
        val nexts = curs.flatMap(_.nexts(maze)).distinct
        curs.foreach(p => maze(p.y)(p.x) = '#')
        step(nexts, n + 1)
      }
    }

    step(List(s), 0)
  }
}
