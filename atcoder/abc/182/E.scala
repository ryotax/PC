object Main extends App {
  val in = new java.util.Scanner(System.in)
  val H, W, N, M = in.nextInt
  val Block = -1

  val matrix: Array[Array[Int]] = Array.fill(W + 2)(Block) +: Array.ofDim[Int](H, W + 2) :+ Array.fill(W + 2)(Block)
  (0 to H + 1).foreach{i =>
    matrix(i)(0) = Block
    matrix(i)(W + 1) = Block
  }

  val bulbs = Array.fill(N)(in.nextInt, in.nextInt)
  (1 to M).foreach {_ =>
    matrix(in.nextInt)(in.nextInt) = Block
  }

  def light(x: Int, y: Int, dx: Int, dy: Int, v: Int): Unit = {
    if (matrix(x + dx)(y + dy) != Block) {
      matrix(x + dx)(y + dy) = v
      light(x + dx, y + dy, dx, dy, v)
    }
  }

  bulbs.foreach {b =>
    if (matrix(b._1)(b._2) != 1) {
      matrix(b._1)(b._2) = 1
      light(b._1, b._2,  1, 0, 1)
      light(b._1, b._2, -1, 0, 1)
    }
  }

  bulbs.foreach {b =>
    if (matrix(b._1)(b._2) != 2) {
      matrix(b._1)(b._2) = 2
      light(b._1, b._2, 0,  1, 2)
      light(b._1, b._2, 0, -1, 2)
    }
  }

  println(matrix.map(_.count(_ > 0)).sum)
}

