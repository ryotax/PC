object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextLong

  val set = scala.collection.mutable.Set[Long]()
  (1 to 1_000_000).foreach {i =>
     if (N % i == 0) {
       set.add(i)
       set.add(N / i)
     }
  }
  println(set.toList.sorted.mkString("\n"))
}
