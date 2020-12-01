object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Cs = in.next

  val rs = Cs.count(_ == 'R')

  val (_, _, min) = (0 until N).foldLeft((0, rs, rs)){case ((ws, rs, min), i) =>
    if (Cs(i) == 'R') (ws, rs - 1, math.min(min, math.max(ws, rs - 1)))
    else (ws + 1, rs, math.min(min, math.max(ws + 1, rs)))
  }

  println(min)
}
