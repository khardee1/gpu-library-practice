package sbttest

import com.thoughtworks.compute.gpu._
import scala.annotation.tailrec

object SelfGravitatingWorld {
  @tailrec
  def runSim(p:Tensor, v:Tensor, m:Tensor, r:Tensor, numParticles:Int, iter:Int, dt:Float):(Tensor, Tensor, Tensor, Tensor, Tensor, Int, Float, Float) = {
    println(p.toString + v.toString)
    
    var mutableP = p
    var mutableA = p*Tensor(0.0f)
    var mutableV = v
    
    val newAcc = Tensor(-1f) // scalars, when operated with tensors, work member-wise with the scalar being applied to all members
    /*val pPrime = p.split(0) //if any value bounds besides 1,1 entered causes an ArrayIndexOutOfBounds. Library has no docs in the scaladocs on what permute does.
    */
    
    for(x <- 0 until numParticles-1) {
      val pSplit = p.split(0)
      val pPrime = Tensor.join(pSplit.tail :+ pSplit.head, 0)
      val mSplit = m.split(0)
      val mPrime = Tensor.join(mSplit.tail :+ mSplit.head, 0)
      val rSplit = r.split(0)
      val rPrime = Tensor.join(rSplit.tail :+ rSplit.head, 0)
      val centerToCenter = rPrime + r
      val d = p - pPrime
      val dSquared = d * d
      val dSquaredSplit = dSquared.split(1)
      val dist = Tensor.sqrt(dSquaredSplit(0) + dSquaredSplit(1) + dSquaredSplit(2))
      val overlap = Tensor.min(dist - centerToCenter, Tensor(0f))
      val restoringForce = (p*Tensor(0.0f)+Tensor(-100f)) * overlap
      val mag = -mPrime / (dist * dist * dist)
      val dNorm = d / dist
      val da = mag * d + restoringForce * dNorm
      mutableA = mutableA + da
    }
    
    mutableV = v + (mutableA * Tensor(dt))
    mutableP = p + (mutableV * Tensor(dt))
    //just split last row and join to front
    
    //for(x <- 
    
    //val d = p1 - p2;
    //val newAcc = Tensor.fill(-1f, Array(10))
    //val aPrime = a + newAcc
    //val vPrime = v + a
    //val xPrime = x + v //*dt
    
    if(iter < 1) (mutableP,mutableV,mutableA,m,r,numParticles,0,dt) else runSim(mutableP,mutableV,m,r,numParticles,iter - 1,dt)
  }
}