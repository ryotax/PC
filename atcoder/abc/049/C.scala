import scala.io.StdIn._
object Main extends App {
  val result = Seq("eraser","erase","dreamer","dream").foldLeft(readLine){(str, word) => str.replaceAll(word, "")}
  println(if (result.isEmpty) "YES" else "NO")
}
