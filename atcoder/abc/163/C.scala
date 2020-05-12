object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = new Array[Int](N)
  (1 until N).foreach{_ =>
    As(in.nextInt - 1) += 1
  }
  println(As.mkString("\n"))
}

