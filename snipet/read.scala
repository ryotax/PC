val sc = new java.util.Scanner(new java.io.File("2013-1BA.in"))

sc.next // discard first line

while (sc.hasNext) {
  val v, num = sc.nextInt
  val arr = Array.tabulate(num)(_ => sc.nextInt())
  println(s"$v $num")
  println(arr.mkString(" "))
}
