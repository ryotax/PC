object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next
  def isPalindrome(s: String) = s.reverse.zip(s).forall{case (l, r) => l == r}
  val result = isPalindrome(S) && isPalindrome(S.substring(0, (S.size - 1) / 2))
  println(if (result) "Yes" else "No")
}

