import scala.io.StdIn._
import java.util.regex.Pattern
object Main extends App {
  val pattern = Pattern.compile("(dream|dreamer|erase|eraser)$")

  @scala.annotation.tailrec
  def removeTail(str: String): String = {
    val newStr = pattern.matcher(str).replaceFirst("")
    if (str == newStr) str else (removeTail(newStr))
  }
  println(if (removeTail(readLine) == "") "YES" else "NO")
}
