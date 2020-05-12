object Main extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt
  val as = Array.fill(n)(in.nextInt)
  val last = as.foldLeft(0){case (cur, act) => if (cur + 1 == act) act else cur}
  println(if (last == 0) -1 else n - last)
}
