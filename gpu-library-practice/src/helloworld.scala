import com.thoughtworks.compute.gpu._

object helloworld extends App {
  def recurseFib(cutoff: Int):Int = {
    def helper(last:Int, beforeLast:Int):Int ={
      if(last + beforeLast > cutoff) last else helper(last+beforeLast, last)
    }
    helper(1, 1)
  }
  
  val arr:Array[Int] = Array.fill(5)(util.Random.nextInt(300))
  val arrFib:Array[Int] = arr.map(recurseFib(_))
  arr foreach println
  println
  arrFib foreach println
  
}