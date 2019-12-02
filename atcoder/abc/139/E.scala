import scala.collection.mutable.{Set => MSet, ArrayBuffer}
import scala.io.StdIn._

object Main extends App {
  val n = readInt
  val players = ArrayBuffer.fill(n)(readLine.split(" ").map(_.toInt - 1).toList)
  val validPlayers = MSet((0 until n): _*)

  @scala.annotation.tailrec
  def playDay(days: Int, toCheck: MSet[Int]): Int = {
    val nextCheck = MSet[Int]()
    var noPlay = true
    val played = new Array[Boolean](n)
    toCheck.foreach { p =>
      if (players(p).nonEmpty) {
        val oppo = players(p).head
        def play(i: Int): Unit = {
          players(i) = players(i).tail
          played(i) = true
          nextCheck += i
          if (players(i).isEmpty) validPlayers -= i
        }
        if (players(oppo).head == p && !played(p) && !played(oppo)) {
          play(p)
          play(oppo)
          noPlay = false
        }
      }
    }
    if (noPlay) {
      if (players.exists(_.nonEmpty)) -1 else days
    } else playDay(days + 1, nextCheck)
  }

  println(playDay(0, MSet((0 until n): _*)))
}
