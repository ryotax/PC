object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, M, X = in.nextInt
  case class Book(price: Int, skills: Array[Int])
  val Books = Array.fill(N)(Book(in.nextInt, Array.fill(M)(in.nextInt)))

  val result = (1 to (1 << N) - 1).map {i =>
    (0 until N).foldLeft((0, Array.fill(M)(0))){case ((amount, as), n) =>
      if ((i & (1 << n)) != 0) {
        val b = Books(n)
        (amount + b.price, as.zip(b.skills).map(t => t._1 + t._2))
      } else (amount, as)
    }
  }

  val min = result.filter(_._2.forall(_ >= X)) match {
    case l if l.isEmpty => -1
    case l => l.minBy(_._1)._1
  }
  println(min)
}
