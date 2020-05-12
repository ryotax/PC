object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K = in.nextInt
  val snukes = Array.fill(N)(false)

  (1 to K).foreach { k =>
    (1 to in.nextInt).foreach(_ => snukes(in.nextInt - 1) = true)
  }
  println(snukes.count(!_))
}
