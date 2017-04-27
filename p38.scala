class P38Int (val i: Int) {
  def gcd(op1: Int, op2: Int): Int = if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)
  def totient:Int = (for (m <- (1 to i).toList if gcd(i,m) == 1) yield m).toList.size

  def primeFactorMultiplicity: Map[Int,Int] = {
    def countFactor(target:Int, factor:Int):Int = {
      if (target % factor == 0) {
        return countFactor(target / factor, factor) + 1
      } else {
        return 0
      }
    }

    def applyFactors(target:Int, factors:List[Int], result:Map[Int,Int] = Map.empty):Map[Int,Int] = (target, factors) match {
      case (t, _) if t <= 1             => result
      case (t, Nil)                     => if (result.contains(t)) result updated (t, result(t) + 1) else result + (t -> 1)
      case (t, x :: xs) if (t % x == 0) => applyFactors(t/(x * countFactor(t, x)), xs, result + (x -> countFactor(t, x)))
      case (t, x :: xs)                 => applyFactors(t, xs, result)
    }
    val primes = 2 :: (3 to Math.sqrt(i).toInt by 2).toList
    applyFactors(i, primes.toList.filter(i % _ == 0))
  }

  def totient2:Int = (new P38Int(i)).primeFactorMultiplicity.foldLeft(1) { (acc, op) => acc * (op._1 - 1) * Math.pow(op._1, op._2.toDouble - 1.0).toInt }

  def measureTime[A](block: => A): Long = {
    val nowMs = System.currentTimeMillis()
    block
    val elapsedTimeMs = System.currentTimeMillis() - nowMs
    return elapsedTimeMs
  }

  def measureTimeOfTotients() = {
    val elapsedTimeP34Ms = measureTime { (new P38Int(i)).totient }
    println("P34 :" + elapsedTimeP34Ms + " ms")

    val elapsedTimeP37Ms = measureTime { (new P38Int(i)).totient2 }
    println("P37 :" + elapsedTimeP37Ms + " ms")
  }
}
implicit def intToP38Int(i: Int): P38Int = new P38Int(i)

/*
scala> 10090.measureTimeOfTotients()
P34 :16 ms
P37 :3 ms
*/
