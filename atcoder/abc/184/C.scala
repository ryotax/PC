object Main extends App {
  val in = new java.util.Scanner(System.in)
  val r1, c1, r2, c2 = in.nextInt

  def reachable(r: Int, c:Int): Boolean =
    r + c == r2 + c2 ||
    r - c == r2 - c2 ||
    math.abs(r - r2) + math.abs(c - c2) <= 3

  def approachable(r: Int, c: Int): Boolean =
    math.abs(r + c - (r2 + c2)) <= 3 ||
    math.abs(r - c - (r2 - c2)) <= 3 ||
    math.abs(r - r2) + math.abs(c - c2) <= 6

  def sameBishopRoute(r: Int, c: Int): Boolean = math.abs(r - c) % 2 == math.abs(r2 - c2) % 2

  println(
    if (r1 == r2 && c1 == c2) 0
    else if (reachable(r1, c1)) 1
    else if (approachable(r1, c1)) 2
    else if (sameBishopRoute(r1, c1)) 2
    else 3)
}
