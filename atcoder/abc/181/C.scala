object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N = in.nextInt
  case class P(x: Int, y: Int)
  val ps = Array.fill(N)(P(in.nextInt, in.nextInt))

  def linear(p1: P, p2: P, p3: P): Boolean = (p1.y - p2.y) * (p2.x - p3.x) == (p1.x - p2.x) * (p2.y - p3.y)

  val exists =
    (0 until N).exists {i =>
      (0 until i).exists {j =>
        (0 until j).exists {k =>
          linear(ps(i), ps(j), ps(k))
        }
      }
    }

  println(if (exists) "Yes" else "No")
}
