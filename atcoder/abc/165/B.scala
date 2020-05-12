object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X = in.nextLong

  def calc(deposit: Long, y: Int): Int = {
    if (deposit >= X) y
    else calc((deposit * 1.01).toLong, y + 1)
  }

  println(calc(100, 0))
}
