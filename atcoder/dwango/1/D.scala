def maxPartialSum(l: Seq[Int]) = {
  var cur = 0
  var result = 0
  l map {i =>
    cur = (cur + i) max 0
    result = result max cur
    result
  }
}

println(maxPartialSum(Seq(-1, 7, -1, 5, -10, 8, -2, 11, -5)).mkString(","))
