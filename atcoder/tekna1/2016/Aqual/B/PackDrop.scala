import scala.io.StdIn._

class Device(val id: Int, var packetDrops: Int) {
  val children: MList[Device] = MList[Device]()
  def addChild(d: Device) {
    children.put(d)
  }
}



def constructNetwork(): MMap[id, Device] {
  val devices : MMap[id, Device] = MMap[Int, Device]()
  val Array(n, m) = readLine.split(" ") map {_.toInt}

  devices.put(new Device(0, 0))

  for (i <- 1 until n) {
    val d = new Device(i, 0)
    devices.put(d)
    devices(readInt).addChild(d)
  }

  for (i <- 0 to m) {
    val Array(b, c) = readLine.split(" ") map {_.toInt}
    devices(b).packetDrops = c
  }
}
