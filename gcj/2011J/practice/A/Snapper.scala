import scala.io.Source

val input = Source.fromFile("A-large-practice.in")
var n = 1
input.getLines.toList.tail.map(line => {
	val n_k = line.split(" ")
	println("Case #" + n + ": " + snapper(n_k(0).toInt, n_k(1).toInt))
	n += 1
})

def snapper(n: Int, k: Int) = {
	val multi = scala.math.pow(2, n).toInt
	val rem = k - (multi - 1)
	if (rem >= 0 && rem % multi == 0) "ON"
	else "OFF"
}
