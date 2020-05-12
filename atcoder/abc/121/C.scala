object Main extends App {
  val sc = new java.util.Scanner(System.in)
  case class Shop(price: Int, limit: Int)

  val n, m = sc.nextInt
  val shops = Array.fill(n)(Shop(sc.nextInt, sc.nextInt)).sortBy(_.price)

  println(shops.foldLeft((0L, m.toLong)){case ((a, rem), s) =>
    val buy = Math.min(rem, s.limit)
    (a + buy * s.price, rem - buy) 
  }._1)
}
