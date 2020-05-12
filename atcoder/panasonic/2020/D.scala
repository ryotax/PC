object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt

  def next(s: String, max: Char): Unit = {
    if (s.size == N) println(s)
    else {
      ('a' to (max + 1).toChar).foreach {c =>
        next(s + c, max max c)
      }
    }
  }

  next("a", 'a')
}
