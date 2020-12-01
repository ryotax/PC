object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  println(700 + 100 * S.count(_ == 'o'))
}

