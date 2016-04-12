val numCases = readLine().toInt
for (i <- 1 to numCases) {
  val line = readLine().split(" ").map(_.toInt)
  println("Case #" + i + ": " + solve(line(0), line(1), line(2)))
}

def layerSize(n: Int) = 2*n*n - n

def binom(n: Int, k: Int) = BigDecimal((BigInt(n - k + 1) to n).product / (BigInt(1) to k).product)

def solve(diamonds: Int, x: Int, y: Int): BigDecimal = {

  val layer = (x.abs + y)/2 + 1
  val prevLayerSize = layerSize(layer - 1)

  if (diamonds < prevLayerSize)
    return BigDecimal(0)
  if (layerSize(layer) <= diamonds)
    return BigDecimal(1)
  if (x == 0 && diamonds != layerSize(layer))
    return BigDecimal(0)


  val diamondsLeft = diamonds - prevLayerSize
  if (2*layer - 2 + y < diamondsLeft)
    return BigDecimal(1)

  if (diamondsLeft <= y) return BigDecimal(0)
  1 - (0 to y).map(binom(diamondsLeft, _)).sum / BigDecimal(2).pow(diamondsLeft)
}

