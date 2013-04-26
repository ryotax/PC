import scala.io.Source
import scala.annotation.tailrec

val input = Source.fromFile("A-small.in").getLines
                                         .toList
                                         .tail

exec(1, input)

@tailrec
def exec(i: Int, list: List[String]) {
    val (cur, next) = list.splitAt(4)
    println("Case #" + i + ": " + 
      (if (judgeBoard(cur, "O")) {
        "O won"
      } else if (judgeBoard(cur, "X")) {
        "X won"
      } else if (even(cur)) {
        "Draw"
      } else {
        "Game has not completed"
      }))

    if (next.size >= 5) {
      exec(i + 1, next.tail)
    }
}


def judgeBoard(board: List[String], s: String) = {
  board.exists(judge(_, s)) ||
  board(0).zip(board(1)).zip(board(2).zip(board(3))).map{case((a, b), (c, d)) => new String(Array(a,b,c,d))}.exists(judge(_, s)) ||
  judge("" + board(0)(0) + board(1)(1) + board(2)(2) + board(3)(3), s) ||
  judge("" + board(0)(3) + board(1)(2) + board(2)(1) + board(3)(0), s)
}

def judge(line: String, s: String) = line.matches("^[" + s + "T]+$")

def even(board: List[String]) = !board.exists(_.matches(".*[.].*"))
