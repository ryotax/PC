import scala.io.StdIn._
// import scala.collection.mutable.ListBuffer
import java.util.ArrayDeque

object Main extends App {
  val Array(h, w) = readLine.split(" ").map(_.toInt)
  val maze = Array.fill(h)(readLine.toCharArray)
  val reached = Array.fill(h, w)(-1)

  case class Pos(x: Int, y: Int)

  val start = (for {
    y <- (0 until h)
    x <- (0 until w)
    if maze(y)(x) == 's'
  } yield Pos(x, y)).head
  reached(start.y)(start.x) = 0

  // val deque = ListBuffer(start)
  val deque = new ArrayDeque[Pos]()
  deque.push(start)

  def nexts(p : Pos): Set[Pos] =
    Set(p.copy(x = p.x + 1), p.copy(x = p.x - 1), p.copy(y = p.y + 1), p.copy(y = p.y - 1))
      .filter(np => 0 <= np.x && np.x < w && 0 <= np.y && np.y < h)
  def run(): Unit = {
    while (!deque.isEmpty) {
      val p = deque.removeFirst()
      val from = reached(p.y)(p.x)
      nexts(p).foreach { np =>
        val to = reached(np.y)(np.x)
        maze(np.y)(np.x) match {
          case 'g' =>
            println("YES")
            return
          case '.' | 's' =>
            if (to == -1) {
              reached(np.y)(np.x) = from
              deque.addFirst(np)
            }
          case '#' =>
            if (to == -1) {
              reached(np.y)(np.x) = from + 1
              if (from + 1 <= 2) deque.addLast(np)
            }
        }
      }
    }
    println("NO")
  }
  run()
}
