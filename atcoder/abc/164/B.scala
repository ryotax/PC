object Main extends App {
  val in = new java.util.Scanner(System.in)
  val tHp, tAt, aHp, aAt = in.nextInt
  println(if ((aHp + tAt - 1) / tAt <= (tHp + aAt - 1) / aAt) "Yes" else "No")
}
