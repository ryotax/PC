object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt
  val s, t = in.next
  println(s.zip(t).flatMap(st => Array(st._1, st._2)).mkString)
}
