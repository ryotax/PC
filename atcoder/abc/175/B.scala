object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val Ls = Array.fill(N)(in.nextInt).sorted
  println((for {
    a <- 0 until Ls.size
    b <- a + 1 until Ls.size
    c <- b + 1 until Ls.size
    if (Ls(a) != Ls(b) && Ls(b) != Ls(c) && Ls(a) + Ls(b) > Ls(c))
  } yield 1).size)
}
