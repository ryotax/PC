import java.util.Scanner
object Main extends App {
  val sc = new Scanner(System.in)
  val n = sc.nextInt
  val arr: Array[Map[Int, Boolean]] = Array.fill(n){
    Array.fill(sc.nextInt)(sc.nextInt - 1 -> (sc.nextInt == 1)).toMap
  }

  val valids = (1 until (1 << n)).map{ i =>
    val valid = (0 until n)
      .filter{j => ((1 << j) & i) != 0}
      .forall{j => arr(j).forall{case (k, b) => (((1 << k) & i) != 0) == b}
    }
    if (valid) Integer.bitCount(i) else 0
  }

  println(valids.max)
}
