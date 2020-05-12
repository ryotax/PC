object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M = in.nextInt
  val As = Array.fill(N)(in.nextLong)
  val mods = As.scanLeft(0L)((z, i) => (z + i) % M)
  val sum = mods.groupBy(identity).map{ case (_, l) =>
    l.size * (l.size - 1) / 2
  }.sum
  println(sum)
}

