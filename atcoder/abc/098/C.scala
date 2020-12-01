object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  val S = "X" + in.next

  val cnts = (1 to N).scanLeft(S.count(_ == 'E')){(c, i) =>
    c + (if (S.charAt(i) == 'E') -1 else 0) + (if (S.charAt(i - 1) == 'W') 1 else 0)
  }
  println(cnts.min)
}
