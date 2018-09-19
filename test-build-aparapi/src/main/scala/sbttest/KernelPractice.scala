package sbttest

import com.aparapi.Kernel
import com.aparapi.Range

case class Acceleration(var x:Double, var y:Double, var z:Double)

object KernelPractice extends App {  
  val inA:Array[Float] = Array(0f, 1f, 2f, 3f)
  val inB:Array[Float] = Array(4f, 3f, 2f, 1f)
  assert (inA.length == inB.length)
  val result:Array[Float] = Array.fill(inA.length)(0f)
  
  val kernel = new Kernel() {
      @Override
      def run() = {
          val i:Int = getGlobalId();
          result(i) = inA(i) + inB(i)
      }
  };

  val range = Range.create(result.length)
  kernel.execute(range)
  println(range)
}