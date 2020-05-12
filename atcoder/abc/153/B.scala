object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, N = in.nextInt
  val As = Array.fill(N)(in.nextInt)
  println(if (H <= As.sum) "Yes" else "No")
}
