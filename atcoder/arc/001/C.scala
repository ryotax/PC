object Main extends App {
  val in = new java.util.Scanner(System.in)
  val OrigBoard = Array.fill(8)(in.next.toCharArray)

  def existsQ(y: Int) = Board(y).contains('Q')

  val board = OrigBoard.map(_.clone)
  def exec(y: Int, board: Array[Array[Char]]): Unit = {
    if (y > 8) {
      check(board)
    } else {
      if (existsQ(y)) exec(y + 1)
      else {
        for {
          x <- 1 to 8
        } 
      }
  }

  for {
    y <- (1 to 8) if notExists(y)
    x <- (1 to 8) if 
  } yield 
}

