object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val As = List.fill(N)(in.nextLong).sorted.reverse

  println(As.head + {
    val l = As.tail.take((N - 1)  / 2)
    if (N % 2 == 0) l.sum * 2
    else l.sum * 2 - l.last
  })
}
