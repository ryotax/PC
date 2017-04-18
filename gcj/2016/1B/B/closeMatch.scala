def compare(l: Char, r: Char) = if (l < r) RLarge else if (l > r) LLarge else UNKNOWN

def max(c: Char) = if (c == '?') '9' else c
def min(c: Char) = if (c == '?') '0' else c

def opt(l: Char, r: Char, c: Comparison) =
  if ('0' <= l && l <= '9' && '0' <= r && r <= '9') Option(l, r, c) else None
def unknownL(r: Char) = 
  List(opt((r - 1).toChar, r, RLarge), opt(r, r, UNKNOWN), opt((r + 1).toChar, r, LLarge)).flatten
def unknownR(l: Char) = 
  List(opt(l, (l - 1).toChar, LLarge), opt(l, l, UNKNOWN), opt(l, (l + 1).toChar, RLarge)).flatten

def next(lhs: String, rhs: String, c: Comparison) = {
  val l = lhs.head
  val r = rhs.head
  c match {
    case LLarge => List((min(l), max(r), c))
    case RLarge => List((max(l), min(r), c))
    case UNKNOWN =>
      if (l == '?' && r == '?') List(('0', '0', UNKNOWN), ('1', '0', LLarge), ('0', '1', RLarge))
      else if (l == '?') unknownL(r)
      else if (r == '?') unknownR(l)
      else List((l, r, compare(l, r)))
  }
}

def exec(lhs: String, rhs: String) = {
  val candidates = next(

}



(1 to readInt) foreach {i => println(s"Case #${i}: ${toNum(Digits, readLine)}")}
