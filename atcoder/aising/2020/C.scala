object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val result = new Array[Int](N + 1)
  
  for {
    x <- (1 to 100)
    y <- (1 to 100)
    z <- (1 to 100)
    f = x * x + y * y + z * z + x * y + y * z + z * x
    if f <= N
  } result(f) += 1

  println(result.tail.mkString("\n"))
}
