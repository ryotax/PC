import scala.io.StdIn._
import scala.collection.mutable.Set => {MSet}
object Main extends App {
  val (n, k) = readLine.split(" ") map {_.toInt}
  val nums = readLine.split(" ") map {_.toInt}

  val arr = new Array[Int](k)
  nums foreach {
    case i if i < k => arr[i] += 1
    case _ => arr[k] += 1
  }

  val cardKinds = (1 to k) filter {arr[_] != 0}

  def dp(possibles: MSet[Int], l: List[Int]): MSet[Int] = {
    val nextPossibles = add(possibles, l.head)
    l match {
      case i :: remain => dp(nextPossibles, remain)
      case _ => nextPossibles
    }
  }

  def add(possibles: MSet[Int], i: Int): MSet[Int] = possibles foreach {possibles.put(_ + i)}
  def needs(possibles: MSet[Int], i: Int): Boolean = possibles exists {p => k - i <= p && p < k}
}

