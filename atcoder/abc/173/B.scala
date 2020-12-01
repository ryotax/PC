object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Ss = List.fill(N)(in.next)
  def formatCount(judge: String): String = s"$judge x ${Ss.count(_ == judge)}"
  println(List("AC", "WA", "TLE", "RE").map(formatCount).mkString("\n"))
}
