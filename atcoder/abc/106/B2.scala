object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt

  println((1 to N by 2).count{n => (1 to n).count(n % _ == 0) == 8})
}
