import scala.io.Source
import scala.annotation.tailrec

val input = Source.fromFile("A-small.in").getLines
                                         .toList
                                         .tail

exec(1, input)

def calc(ps: List[Passenger]): Int = {
  val noSwap = ps.fare.sum

  ps map {_.to} sorted
  ps sortBy {_.from}

  val entryStack = Stack()
  val exitList = Stack()
  ps foreach {p =>
    exitStack.add(
  }
}

case class Passenger(from: Long, to: Long, n: Long) {
  def fare: BigInt = BigInt(fare(N, to - from)) * n
}

def fare(nStations: Long, d: Long) = nStations * d - d * (d - 1) / 2
