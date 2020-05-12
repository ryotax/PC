object Main extends App {
  val sc = new java.util.Scanner(System.in)
  val s = sc.next
  println((s.count(_ == '0') min s.count(_ == '1')) * 2)
}
