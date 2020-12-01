object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M, K = in.nextInt
  val As = List.fill(N)(in.nextLong)
  val Bs = List.fill(M)(in.nextLong)

  def takeRead(unread: List[Long], time: Long, cnt: Int, read: List[Long]): (List[Long], List[Long], Long, Int) = unread match {
    case Nil => (unread, read, time, cnt)
    case x :: xs =>
      if (time + x > K) (unread, read, time, cnt)
      else takeRead(xs, time + x, cnt + 1, x :: read)
  }

  def readBs(readAs: List[Long], unreadBs: List[Long], time: Long, cnt: Int, cntMax: Int): Int = readAs match {
    case Nil => cntMax
    case x :: xs =>
      val (newUnreadBs, _, newTime, newCnt) = takeRead(unreadBs, time - x, cnt - 1, Nil)
      readBs(xs, newUnreadBs, newTime, newCnt, cntMax max newCnt)
  }

  val (_, as, time, cnt) = takeRead(As, 0L, 0, Nil)
  println(readBs(0L :: as, Bs, time, cnt + 1, cnt))
}
