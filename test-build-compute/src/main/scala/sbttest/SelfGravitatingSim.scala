package sbttest

import com.thoughtworks.compute.gpu._

object SelfGravitatingSim extends App {
  //val p = Tensor.fill(1f,Array(10, 3))
  val pFill = Array.fill(10)(Seq(util.Random.nextFloat(), util.Random.nextFloat(),util.Random.nextFloat()))
  //val p = Tensor(Array(Seq(0.0f, 0.0f, 0.0f), Seq(1.0f, 0.0f, 0.0f)))
  val p = Tensor(pFill)
  //val v = Tensor(Array(Seq(1.0f, 0.0f, 0.0f), Seq(-1.0f, 0.0f, 0.0f)))
  val vFill = Array.fill(10)(Seq(0f, 0f, 0f))
  val v = Tensor(vFill)
  //val m = Tensor(Array(1.0f, 1.0f))
  val mFill = Array.fill(10)(1f)
  val m = Tensor(mFill)
  //val r = Tensor(Array(0.5f, 0.5f))
  val rFill = Array.fill(10)(0.5f)
  val r = Tensor(rFill)
  SelfGravitatingWorld.runSim(p, v, m, r, 2, 628, 0.01f)
}