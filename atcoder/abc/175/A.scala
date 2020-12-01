object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  println(
    if (S == "RRR") 3
    else if (S.contains("RR")) 2
    else if (S.contains("R")) 1
    else 0
  )
}
