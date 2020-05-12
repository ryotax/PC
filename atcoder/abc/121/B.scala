object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, m, c = sc.nextInt
  val bs = Array.fill(m)(sc.nextInt)
  val as = Array.fill[Int](n, m)(sc.nextInt)
  println(as.count(_.zip(bs).map(tpl => tpl._1 * tpl._2).sum + c > 0))
}
