object Main extends App {
  val in = new java.util.Scanner(System.in)
  val X = in.nextInt

  val primes: Stream[Int] = 2 #:: (Stream.from(3, 2) filter {n =>
    primes.takeWhile(_ <= Math.sqrt(n).toInt).forall(n % _ != 0)
  })

  println(primes.dropWhile(_ < X).head)
}
