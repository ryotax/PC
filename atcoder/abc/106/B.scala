object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt

  println(
    if (N < 105) 0 // 3 * 5 * 7
    else if (N < 135) 1 // 3 * 3 * 3 * 5
    else if (N < 165) 2 // 3 * 5 * 11
    else if (N < 189) 3 // 3 * 3 * 3 * 7
    else if (N < 195) 4 // 3 * 5 * 13
    else 5
  )
}
