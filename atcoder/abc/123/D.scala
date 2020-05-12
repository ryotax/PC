import java.util.Scanner
import java.util.Arrays
object Main extends App {
  val sc = new Scanner(System.in)
  val x, y, z, k = sc.nextInt
  val as = Array.fill(x)(sc.nextLong)
  val bs = Array.fill(y)(sc.nextLong)
  val cs = Array.fill(z)(sc.nextLong)

  def merge(la: Array[Long], ra: Array[Long]): Array[Long] = {
    val arr = for {
      l <- la
      r <- ra
    } yield l + r
    Arrays.sort(arr)
    arr
  }

  val result = merge(merge(as, bs).takeRight(3000), cs)
  println(result.takeRight(k).reverse.mkString("\n"))
}
