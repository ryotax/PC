object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val K = in.nextLong
  val As = Array.fill(N)(in.nextInt - 1)
  val visited = Array.fill(N)(0)

  def teleport(pos: Int, step: Int): Int = {
    val next = As(pos)
    if (step == K) next
    else if (visited(next) == 0) {
      visited(next) = step + 1
      teleport(next, step + 1)
    } else {
      val diff = step + 1 - visited(next)
      val remain = (K - step) % diff
      def find(p: Int, r: Int): Int = if (r == 0) As(p) else find(As(p), r - 1)
      find(pos, remain.toInt)
    }
  }

  println(teleport(0, 1) + 1)

}
