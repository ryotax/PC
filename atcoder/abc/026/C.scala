import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  val n = readLine.toInt
  val staffs = new Array[Staff](n)
  staffs(0) = new Staff()
  (1 until n).foreach(self => {
    staffs(self) = new Staff()
    staffs(readLine.toInt - 1).subordinates += staffs(self)
  })
  println(staffs(0).sallary)
}

class Staff {
  val subordinates = new ArrayBuffer[Staff]
  def sallary: Int = {
    if (subordinates.isEmpty) 1
    else {
      val sallaries = subordinates.map(_.sallary)
      sallaries.max + sallaries.min + 1
    }
  }
}
