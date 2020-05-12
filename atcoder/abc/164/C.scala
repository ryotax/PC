import collection.mutable.HashSet
object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  println(Array.fill(N)(in.next).distinct.size)
}
