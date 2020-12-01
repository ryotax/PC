object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  def func(i: Int): Long = (i + N / i * i).toLong * (N / i) / 2
  println((1 to N).foldLeft(0L){_ + func(_)})
}
