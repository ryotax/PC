object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S, T = in.next
  println(
    ((0 to (S.size - T.size)).map {i =>
      S.substring(i, i + T.size).zip(T).count{case (l, r) => l != r}
    }).min
  )
}
