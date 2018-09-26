package sbttest

import com.thoughtworks.compute.gpu._

object BouncingBallSim extends App {
  val x = Tensor.fill(100f, Array(10))
  val v = Tensor.fill(10f, Array(10))
  val a = Tensor.fill(1f, Array(10))
  BouncingBallWorld.runSim(x, v, a, 20f)
}