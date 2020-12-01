object Main extends App {
  val in = new java.util.Scanner(System.in)
  val Sx, Sy, Gx, Gy = in.nextDouble
  println(Sx + (Gx - Sx) / (Gy + Sy) * Sy)
}
