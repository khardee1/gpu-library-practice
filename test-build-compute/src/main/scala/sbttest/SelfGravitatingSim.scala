package sbttest

import com.thoughtworks.compute.gpu._

object SelfGravitatingSim extends App {
  //val p = Tensor.fill(1f,Array(10, 3))
  val p = Tensor(Array(Seq(1.0f, 2.0f, 3.0f), Seq(4.0f, 5.0f, 6.0f)))
  val v = Tensor(Array(Seq(1.0f, 2.0f, 3.0f), Seq(4.0f, 5.0f, 6.0f)))
  val a = Tensor(Array(Seq(2.0f, 3.0f, 4.0f), Seq(5.0f, 6.0f, 1.0f)))
  val m = Tensor.fill(1f,Array(2))
  SelfGravitatingWorld.runSim(p, v, a, m, 10, 10, 1f)
}