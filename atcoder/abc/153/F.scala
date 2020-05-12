object Main extends App {
  val in = new java.util.Scanner(System.in)
  val N, D, A = in.nextInt
  case class Monster(x: Long, hp: Long)
  val Monsters = Array.fill(N)(Monster(in.nextLong, in.nextLong)).sortBy(_.x)

  case class Attack(x: Long, damage: Long)
  val q = new scala.collection.mutable.Queue[Attack]

  def calcDamage(pos: Long, cur: Long): Long = {
    q.headOption match {
      case None => cur
      case Some(attack) => 
        if (attack.x < pos) {
          q.dequeue
          calcDamage(pos, cur - attack.damage)
        } else cur
    }
  }

  def attack(i: Int, sum: Long, preDamage: Long): Long = {
    if (i == N) sum
    else {
      val m = Monsters(i)
      val newDamage = calcDamage(m.x, preDamage)
      if (m.hp <= newDamage) attack(i + 1, sum, newDamage)
      else {
        val attacks = (m.hp - newDamage + A - 1) / A
        q += Attack(m.x + 2 * D, A * attacks)
        attack(i + 1, sum + attacks, newDamage + A * attacks)
      }
    }
  }

  println(attack(0, 0L, 0L))
}
