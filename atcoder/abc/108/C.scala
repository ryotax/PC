object Main extends App {
  val Array(n, k) = scala.io.StdIn.readLine.split(" ").map{_.toLong}
  def cube(l: Long) = l * l * l
  println(cube(n / k) + (if ((k & 1) == 1) 0 else cube((n + k / 2) / k)))
}
