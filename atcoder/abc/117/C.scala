object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n, m = in.nextInt
  val xs = Array.fill(m)(in.nextInt).sorted
  // val spaces = xs.sliding(2).map(s => s.last - s.head).toList
  val spaces = xs.zip(xs.tail).map(s => s._2 - s._1)
  println(spaces.sorted.dropRight(n - 1).sum)
}
