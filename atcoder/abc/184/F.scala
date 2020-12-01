object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, T = in.nextInt
  val As = Array.fill(N)(in.nextInt)

  println(As.foldLeft(scala.collection.mutable.HashSet(0)){(set, a) =>
    val next = set.clone
    set.foreach {t =>
      if (t + a <= T) next.add(t + a)
    }
    next
  }.max)
}
