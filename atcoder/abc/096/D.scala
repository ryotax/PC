object Main extends App {
  val primes: Stream[Int] = 2 #:: (Stream.from(3, 2) filter {n =>
    primes takeWhile {_ <= Math.sqrt(n).toInt} forall {n % _ != 0}
  })
  println(primes.filter(_ % 5 == 1).take(io.StdIn.readLine.toInt).mkString(" "))
}
