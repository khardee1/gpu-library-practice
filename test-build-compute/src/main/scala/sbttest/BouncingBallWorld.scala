package sbttest

import com.thoughtworks.compute.gpu._

object BouncingBallWorld {
  
  def runSim(x:Tensor, v:Tensor, a:Tensor, iter:Float):(Tensor, Tensor, Tensor, Float) = {
    println(x.toString)
    println(v.toString)
    println(a.toString)
    println
    val newAcc = Tensor.fill(-1f, Array(10))
    val aPrime = a + newAcc
    val vPrime = v + a
    val xPrime = x + v //*dt
    
    if(iter >= 0) runSim(xPrime,vPrime,aPrime,iter-1) else (xPrime,vPrime,aPrime,iter)
  }
}