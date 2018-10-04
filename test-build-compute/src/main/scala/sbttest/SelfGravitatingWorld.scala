package sbttest

import com.thoughtworks.compute.gpu._

object SelfGravitatingWorld {
  def runSim(p:Tensor, v:Tensor, a:Tensor, m:Tensor , numParticles:Int, iter:Float, dt:Float):(Tensor, Tensor, Tensor, Tensor, Int, Float, Float) = {
    println(p.toString + v.toString + a.toString)
    
    var mutableP = p
    var mutableA = a
    var mutableV = v
    
    val newAcc = Tensor(-1f) // scalars, when operated with tensors, work member-wise with the scalar being applied to all members
    /*val pPrime = p.split(0) //if any value bounds besides 1,1 entered causes an ArrayIndexOutOfBounds. Library has no docs in the scaladocs on what permute does.
    println(pPrime.toString)
    val pPrimePrime = pPrime.tail :+ pPrime.head
    println(pPrimePrime.toString)
    val pPrimeJoined = Tensor.join(pPrimePrime,0)
    println(pPrimeJoined.toString) 
    
    println(Tensor.max(v,a)) */
    
    for(x <- 0 until numParticles) {
      val pSplit = p.split(0)
      val pPrime = Tensor.join(pSplit.tail :+ pSplit.head, 0)
      val mSplit = m.split(0)
      val mPrime = Tensor.join(mSplit.tail :+ mSplit.head, 0)
      val d = p - pPrime
      val dSquared = d * d
      val dSquaredSplit = dSquared.split(1)
      val dist = Tensor.sqrt(dSquaredSplit(0) + dSquaredSplit(1) + dSquaredSplit(2))
      val mag = mPrime / (dist * dist * dist)
      val da = mag * d
      mutableA = mutableA + (da * Tensor(dt))
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
    
    //if(iter >= 0) runSim(xPrime,vPrime,aPrime,iter-1) else (xPrime,vPrime,aPrime,iter)
    if(iter < 1) (mutableP,mutableV,mutableA,m,numParticles,0,dt) else runSim(mutableP,mutableV,mutableA,m,numParticles,iter - 1,dt)
  }
}