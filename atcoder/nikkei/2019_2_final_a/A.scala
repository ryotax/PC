object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt
  val as = Array.fill(n)(sc.nextInt)
  println(((1 until n - 1).map{i =>
    (0 until i).count(l => as(l) < as(i)) * (i + 1 until n).count(r => as(r) < as(i)).toLong
  }).sum)
}
