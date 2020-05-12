object Main extends App {
  val in = new java.util.Scanner(System.in)
  val K, A, B = in.nextInt

  def judge(k: Int): Boolean = {
    if (A <= k && k <= B) true
    else if (k > B) false
    else judge(k + K)
  }
  println(if(judge(K)) "OK" else "NG")
}
