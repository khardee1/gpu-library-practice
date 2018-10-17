package sbttest

import com.thoughtworks.compute.gpu._

object SelfGravitatingSim extends App {
  //val p = Tensor.fill(1f,Array(10, 3))
  val p = Tensor(Array(Seq(0.0f, 0.0f, 0.0f), Seq(1.0f, 0.0f, 0.0f)))
  val v = Tensor(Array(Seq(0.0f, 0.0f, 0.0f), Seq(0.0f, 1.0f, 0.0f)))
  val m = Tensor(Array(1.0f, 1e-5f))
  val r = Tensor(Array(1.0f, 1e-5f))
  SelfGravitatingWorld.runSim(p, v, m, r, 2, 628, 0.01f)
}