object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val cakes = Array.fill(N)(Array(in.nextLong, in.nextLong, in.nextLong))

  println(
    (0 until 8).map { mask =>
      cakes.map { c =>
        (0 to 2).map { i =>
          c(i) * (if ((mask & (1 << i)) == 0) 1 else -1)
        }.sum
      }.sorted.reverse.take(M).sum
    }.max
  )
}


