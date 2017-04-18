// import scala.io.StdIn._

def findPair(kids: Array[Int]): Array[(Int, Int)] = {
  val pairs = kids.zipWithIndex filter {(k, i) => i == kids[k]}
  (pairs map {(l, r) => (l min r, l max r)}).toSet.toArray
}

def findStar(kids: Array[Int], pairs: Array[(Int, Int)]) = {
  pairs map {(l, r) =>
    kids exists {_ == l} && kids exists {_ == r)
  }
}

val n = readInt
(1 to n) foreach {i =>
  readInt
  println(s"Case #${i}: ${exec(readLine.split(" ") map {_.toInt - 1})}")
}



