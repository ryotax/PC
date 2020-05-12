object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Ps, Qs = Array.fill(N)(in.nextInt).mkString
  val ls = (1 to N).mkString.permutations.toList
  println(Math.abs(ls.indexOf(Ps) - ls.indexOf(Qs)))
}
