object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val a, b, k = sc.nextInt
  println((100 to 1 by -1).filter(i => a % i == 0 && b % i == 0)(k - 1))
}
