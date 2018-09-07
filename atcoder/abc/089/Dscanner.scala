import java.util.Scanner

// ほぼ標準入力から問題を読み取るだけの時間を計測する
object Main extends App {
  val scanner = new Scanner(System.in)
  val h, w, d = scanner.nextInt
  /*
  val table: Map[Int, (Int, Int)] = (for {
        y <- 0 until h
        x <- 0 until w
      } yield scanner.nextInt -> (x, y)).toMap
  */
  val table: Seq[Int] = for {
        y <- 0 until h
        x <- 0 until w
      } yield scanner.nextInt

  /*
  (1 to scanner.nextInt).foreach{i =>
    val l, r = Integer.parseInt(scanner.next)
    println(((l to r by d).sliding(2).map{l =>
      val lPos = table(l.head)
      val rPos = table(l.last)
      Math.abs(lPos._1 - rPos._1) + Math.abs(lPos._2 - rPos._2)
    }).sum)
  }
  */
  (1 to scanner.nextInt).foreach{i =>
    val l, r = Integer.parseInt(scanner.next)
    println(l)
  }
}

