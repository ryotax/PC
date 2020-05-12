object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val s = sc.next
  val n = s.size
  val kks = (2 to n - 2).map{i =>
    def eq(j: Int): Boolean = (0 until j).forall(k => ca(i + k) == ca(i + j + k))
    (1 to (n - 4) / 2).count(eq)
  }

  (
  val as = Array.fill(n)(sc.nextInt)
  println(((1 until n - 1).map{i =>
    (0 until i).count(l => as(l) < as(i)) * (i + 1 until n).count(r => as(r) < as(i)).toLong
  }).sum)
}
