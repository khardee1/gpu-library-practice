package sbttest

object NBodyUniverse {
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
        acc(i)._x = (acc(i).x - mag1*dx).toFloat
        acc(i)._y = (acc(i).y - mag1*dy).toFloat
        acc(i)._z = (acc(i).z - mag1*dz).toFloat
        val mag2 = (b2.mass/(dist*dist*dist)).toFloat
        acc(j)._x = (acc(j).x + mag2*dx).toFloat
        acc(j)._y = (acc(j).y + mag2*dy).toFloat
        acc(j)._z = (acc(j).z + mag2*dz).toFloat
      }
    }
    for(k <- 0 until bodies.length) {
      bodies(k)._vX = (bodies(k).vX + acc(k).x*distTime).toFloat
      bodies(k)._vY = (bodies(k).vY + acc(k).y*distTime).toFloat
      bodies(k)._vZ = (bodies(k).vZ + acc(k).z*distTime).toFloat
      bodies(k)._x = (bodies(k).x + bodies(k).vX*distTime).toFloat
      bodies(k)._y = (bodies(k).y + bodies(k).vX*distTime).toFloat
      bodies(k)._z = (bodies(k).z + bodies(k).vX*distTime).toFloat
    }
  }
}