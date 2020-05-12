object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K = in.nextInt
  val seq = Array(1,1,1,2,1,2,1,5,2,2,1,5,1,2,1,14,1,5,1,5,2,2,1,15,2,2,5,4,1,4,1,51)
  println(seq(K - 1))
}
