object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val result = (1 to N).forall{i =>
    val a = in.nextInt
    a % 2 == 1 || a % 3 == 0 || a % 5 == 0
  }
  println(if (result) "APPROVED" else "DENIED")
}
