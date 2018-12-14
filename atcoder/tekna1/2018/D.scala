object Main extends App {
  val N = scala.io.StdIn.readInt

  getSkew(1, Nil) match {
    case Nil => println("No")
    case skew => print(calc(skew))
  }

  def calc(skew: List[Int]): List[List[Int]] = {
    val n = skew.size
    val line = 1 :: skew.init.map(_ + 1)
    skew :: (0 until n).toList.map{i =>
      Stream.from(line(i)).take(i) ++: line.drop(i).map(_ + i)
    }
  }

  def print(list: List[List[Int]]): Unit = {
    println("Yes")
    println(list.size)
    list.foreach(l => println((l.size :: l).mkString(" ")))
  }

  @scala.annotation.tailrec
  def getSkew(n: Int, skew: List[Int]): List[Int] = sum(n) match {
    case N => (N :: skew).reverse
    case s if s < N => getSkew(n + 1, s :: skew)
    case _ => Nil
  }

  def sum(n: Int): Int = (n + 1) * n / 2
}


/*
1
23
456
789a
bcdef

n * (1 + n) / 2 = x
n + n * n = 2x
n^2 + n - 2x = 0
*/
