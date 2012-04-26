import scala.io.Source

val input = Source.fromFile("input.txt")
try {
	var n = 1
	input.getLines.toList.tail.map(line => {
		val a_b_p = line.split(" ")
		println("Case #" + n + ": " + count(a_b_p(0).toLong, a_b_p(1).toLong, a_b_p(2).toLong))
		n += 1
	})
} finally {
	input.close
}

def odds(n: Long): Stream[Long] = n #:: odds(n + 2)
lazy val primes: Stream[Long] = 2 #:: odds(3).filter(n => primes.takeWhile(_ <= math.sqrt(n)).forall(p => n % p != 0))
println(primes.take(100).toList)

def count(from: Long, to: Long, min: Long) = {
	val ps = primes.dropWhile(_ < min).takeWhile(p => p * p <= to / 2)
}
