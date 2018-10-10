package sbttest

import com.thoughtworks.compute.gpu._

object BouncingBallWorld {
  
  def runSim(x:Tensor, y:Tensor, z:Tensor, v:Tensor, a:Tensor, iter:Float, dt:Float):(Tensor, Tensor, Tensor, Tensor, Tensor, Float) = {
    println(z.toString)
    println(v.toString)
    println(a.toString)
    println
    val newAcc = Tensor.fill(-1f, Array(10))
    val aPrime = a + newAcc
    val vPrime = v + a
    val zPrime = z + v * Tensor(dt)
    
    val boolZNegative = (Tensor.min(zPrime, Tensor(0f)) / zPrime) * Tensor(-1f)
    val boolZPositive = (Tensor.max(zPrime, Tensor(0f)) / zPrime)
    val boolZ = boolZNegative + boolZPositive
    
    val vFinal = vPrime * boolZ
    
    if(iter >= 0) runSim(x, y, zPrime, vFinal, aPrime, iter-1, dt) else (x, y, zPrime, vFinal, aPrime, iter, dt)
  }
}