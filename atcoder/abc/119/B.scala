object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt
  println((1 to n).map {i =>
    val x = in.nextDouble
    if (in.next == "JPY") x
    else x * 380000
  }.sum)
}
