package sbttest

import com.thoughtworks.compute.gpu._

object TensorPractice extends App {
  def recurseFib(cutoff: Int):Int = {
    def helper(last:Int, beforeLast:Int):Int = {
      if(last + beforeLast > cutoff) last else helper(last+beforeLast, last)
    }
    helper(1, 1)
  }
  def recurseFactorial(number: Int):BigInt = {
    def helper(number: Int, runningTotal:BigInt):BigInt = {
      if(number < 2) runningTotal else helper(number - 1, runningTotal * number) 
    }
    helper(number, 1)
  }
  def bubbleSort(arr:Array[Int]): Unit = {
    for(x <- 0 until arr.length) {
      for(y <- 0 until arr.length-1) {
        if(arr(y) > arr(y+1)) {
          val temp = arr(y)
          arr(y) = arr(y+1)
          arr(y+1) = temp
        }
      }
    }
  }
  var arr = Array.fill(100000)(util.Random.nextInt(1000000000))
  bubbleSort(arr)
  arr.take(5) foreach println
  def arr1: Array[Array[Int]] = Array(arr)
  val seq:Seq[Body] = Seq(new Body(1,1,1,1,1,1,1))
  val my2DArray: Tensor = Tensor(Seq(Seq((1,1,1,1,1,1,1), (1,1,1,1,1,1,1), (1,1,1,1,1,1,1)), Seq((1,1,1,1,1,1,1), (1,1,1,1,1,1,1), (1,1,1,1,1,1,1)))
  
}