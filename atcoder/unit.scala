object Main extends App {
  var units: Seq[UUnit] = for (i <- 1 to readInt) yield {
    val u = readLine.split(" ")
    new UUnit(u(0), u(1).toInt, u(2))
  }

  do {
    val merged = merge(units)
    if (merged.size == 0) println(units.maxBy(_.amount))
    units = merged
  } while (units.size != 0)

  def merge(seq: Seq[UUnit]): Seq[UUnit] = {
    for (u1 <- seq; u2 <- seq if u1.smallUnit == u2.largeUnit) yield u1.merge(u2)
  }
}

case class UUnit(largeUnit: String, amount: Int, smallUnit: String) {
  def merge(u: UUnit) = new UUnit(largeUnit, amount * u.amount, u.smallUnit)
  override def toString = 1 + largeUnit + "=" + amount + smallUnit
}
