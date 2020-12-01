object Main extends App {
  val in = new java.util.Scanner(System.in)
  val S = in.next

  val size = S.size min 3
  val able =
    S.toSeq.combinations(size).exists {c =>
      c.toSeq.permutations.exists{p =>
        p.mkString.toInt % 8 == 0
      }
    }

  println(if (able) "Yes" else "No")
}
