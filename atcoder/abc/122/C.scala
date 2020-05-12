object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val n, q = sc.nextInt
  val ca = sc.next.toCharArray
  val acs = (0 until n - 1).scanLeft(0){(z, i) =>
    z + (if (ca(i) == 'A' && ca(i + 1) == 'C') 1 else 0)
  }
  println((1 to q).map{i =>
    val l, r = sc.nextInt
    acs(r - 1) - acs(l - 1)
  }.mkString("\n"))
}
