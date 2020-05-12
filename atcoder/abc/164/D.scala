object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  val rems = new Array[Int](2019)
  rems(0) = 1
  (S.size - 1 to 0 by -1).foldLeft((0, 1)){case ((rem, rem10), i) =>
    val newRem = (rem10 * 10 * (S(i) - '0') % 2019 + rem) % 2019
    rems(newRem) += 1
    (newRem, rem10 * 10 % 2019)
  }
  println(rems.map(n => n * (n - 1) / 2).sum)
}


