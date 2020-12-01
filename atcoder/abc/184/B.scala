object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, X = in.nextInt
  val S = in.next

  println(S.foldLeft(X){
    case (sum, 'o') => sum + 1
    case (0,   'x') => 0
    case (sum, 'x') => sum - 1
  })
}
