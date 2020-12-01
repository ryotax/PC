object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X = in.nextInt
  def maxExp(i: Int, cur: Int = 1): Int = if (i * cur <= X) maxExp(i, i * cur) else cur
  println(
    if (X < 4) 1
    else (2 to math.sqrt(X).toInt).map(maxExp(_)).max
  )
}
