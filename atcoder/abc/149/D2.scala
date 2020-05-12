object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, K, R, S, P = in.nextInt
  val T = in.next

  def win(h: Char): Int = h match {
    case 'r' => P
    case 's' => R
    case _ => S
  }

  def score(i: Int, sum: Int, pre: Char): Int = {
    if (i >= N) sum
    else T.charAt(i) match {
      case `pre` => score(i + K, sum, 'X')
      case h => score(i + K, sum + win(h), h)
    }
  }

  println((0 until K).map(i => score(i, 0, 'X')).sum)
}
