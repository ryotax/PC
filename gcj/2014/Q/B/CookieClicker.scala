import java.util.Scanner

val sc = new Scanner(new java.io.File("B-small-attempt0.in"))

(1 to sc.nextInt) foreach {num =>
  val c, f, x = sc.nextDouble
  val farmCost = (c / 2) #:: (Stream.from(1) map {n => c / (f * n + 2)})
  val farmCost2 = farmCost.scanLeft(0.0){(z, n) => z + n}
  val cost = farmCost2.zipWithIndex map {tpl => tpl._1 + x / (2 + tpl._2 * f)}
  val min = (cost.zip(cost.tail) dropWhile {tpl => tpl._1 > tpl._2}).head._1
  println(s"Case #${num}: $min")
}
