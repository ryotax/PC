import scala.io.StdIn._
object Main extends App {
  val pattern = "([ox])\\1*".r
  val board: Array[Array[Char]] = (1 to 19).map(i => readLine.toCharArray).toArray
  val rotated: Array[Array[Char]] = rotateBoard(board)
  val blacks = board.map(_.count(_ == 'o')).sum
  val whites = board.map(_.count(_ == 'x')).sum

  def gte5String(line: String): List[String] = pattern.findAllIn(line).filter(_.size >= 5).toList
  def gte5(line: Array[Char]): List[String] = gte5String(new String(line))
  def diagonalChars(targetBoard: Array[Array[Char]], x: Int, y: Int, chars: List[Char]): Array[Char] = {
    if (x >= 19) diagonalChars(targetBoard, x - 1, y + 1, chars)
    else if (x < 0 || y >= 19) chars.toArray
    else diagonalChars(targetBoard, x - 1, y + 1, targetBoard(x)(y) :: chars)
  }

  val verticals = board.flatMap(gte5).toList
  val horizontals = rotated.flatMap(gte5).toList
  val diagonals =
    (0 until 36).flatMap{x => gte5(diagonalChars(board, x, 0, Nil)) ++  // TODO (4 until 32)で十分？
                              gte5(diagonalChars(rotated, x, 0, Nil))}.toList
  val all: List[String] = verticals ++ horizontals ++ diagonals
  val result = all match {
    case Nil => whites + 1 == blacks || whites == blacks
    case head :: Nil =>
      if (head.size > 9) false
      else if (head.head == 'o') whites + 1 == blacks
      else whites == blacks
    case _ => false
  }

  def rotateBoard(orig: Array[Array[Char]]): Array[Array[Char]] = {
    val ret: Array[Array[Char]] = Array.ofDim[Char](19, 19)
    for {x <- 0 to 18; y <- 0 to 18} ret(x)(y) = orig(18 - y)(x)
    ret
  }

  println(if (result) "YES" else "NO")
}


