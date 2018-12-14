import scala.io.StdIn._
object Main extends App {
  val i = readLine.toInt
  println((111 to 999 by 111).find(_ >= i).get)
}

