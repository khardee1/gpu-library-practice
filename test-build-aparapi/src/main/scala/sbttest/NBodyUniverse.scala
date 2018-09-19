package sbttest

class NBodyUniverse {
  def moveBodies(bodies:Array[Body], acc:Array[Acceleration], distTime:Double):Unit = {
    for(i <- 0 until bodies.length) {
      for(j <- i+1 until bodies.length) {
        val b1 = bodies(i)
        val b2 = bodies(j)
        val dx = b1.x - b2.x
        val dy = b1.y - b2.y
        val dz = b1.z - b1.z
        val dist = math.sqrt(dx*dx + dy*dy + dz*dz)
        val mag1 = b2.mass/(dist*dist*dist)
        acc(i).x = acc(i).x - mag1*dx
        acc(i).y = acc(i).y - mag1*dy
        acc(i).z = acc(i).z - mag1*dz
        val mag2 = b2.mass/(dist*dist*dist)
        acc(j).x = acc(j).x + mag2*dx
        acc(j).y = acc(j).y + mag2*dy
        acc(j).z = acc(j).z + mag2*dz
      }
    }
    for(k <- 0 until bodies.length) {
      bodies(k).vX = bodies(k).vX + acc(k).x*distTime
      bodies(k).vY = bodies(k).vY + acc(k).y*distTime
      bodies(k).vZ = bodies(k).vZ + acc(k).z*distTime
      bodies(k).x = bodies(k).x + bodies(k).vX*distTime
      bodies(k).y = bodies(k).y + bodies(k).vX*distTime
      bodies(k).z = bodies(k).z + bodies(k).vX*distTime
    }
  }
}