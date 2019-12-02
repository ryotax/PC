import scala.io.StdIn._
object Main extends App {
  val n = readInt
  val s = readLine

  println((1000 to 1999).count { i =>
    i.toString.takeRight(3).foldLeft(0){(z, c) =>
      val i = s.indexOf(c, z)
      if (i == -1) 100000 else i + 1
    } != 100000
  })
}
