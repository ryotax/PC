object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = BigInt(in.nextLong)
  val Max = BigInt(1_000_000_000_000_000_000L)

  val tMax = LazyList.from(1).takeWhile(e => BigInt(3).pow(e) <= Max).last
  val fMax = LazyList.from(1).takeWhile(e => BigInt(5).pow(e) <= Max).last

  val tf = for {
    te <- (1 to tMax)
    t = BigInt(3).pow(te)
    fe <- (1 to fMax)
    f = BigInt(5).pow(fe)
    if t + f == N
  } yield (te, fe)

  println(if (tf.isEmpty) -1 else s"${tf.head._1} ${tf.head._2}")
}
