import scala.io.StdIn._
object Main extends App {
  readLine
  val arr = new Array[Int](13)
  arr(0) += 1
  readLine.split(" ").foreach(d => arr(d.toInt) += 1)

  val overlap = arr(0) > 1 || arr(12) > 1 || (1 until 12).exists(_ > 2)
  if (overlap) {
    println(0)
  } else {
  }

  def fixed: Array[Boolean] = {
    val result = new Array[Boolean](24)
    (0 to arr.size).foreach{ i => 
      arr(i) match {
        case 0 =>
        case 1 =>
          if (i == 0 || i == 12) result(i) = true
          else choises += i
        case _ =>
          result(i) = true
          result(24 - i) = true
      }
    }
  }

  
  def times(base: Int): List[List[Int]] =
    List(base) :: diffs.map(d => List((d + base) % 24, (24 - d + base) % 24))
  val ds: List[List[Int]] = List(0) :: readLine.split(" ").map(_.toInt).toSet[Int].map(d => List(d, 24 - d)).toList

  def minF(lhs: List[Int], rhs: List[Int]): Int =
   (for (l <- lhs; r <- rhs) yield Math.abs(l - r)).min

  @scala.annotation.tailrec
  def search(ls: List[List[Int]], min: Int): Int = {
    ls match {
      case Nil => min
      case x :: Nil => min
      case x :: xs => search(xs, Math.min(min, xs.map(minF(x, _)).min))
    }
  }

  println(search(ds, 100))
}


