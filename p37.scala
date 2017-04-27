class P37Int (val i: Int) {
  def primeFactorMultiplicity:Map[Int,Int] = {
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
    val primes = (2::(3 to i by 2).toList).toSeq diff (for (x <- (3 to i by 2).toList; y <- 2 to i) yield x*y).toSeq
    applyFactors(i, primes.toList)
  }

  def totient:Int = (new P37Int(i)).primeFactorMultiplicity.foldLeft(1) { (acc, op) => acc * (op._1 - 1) * Math.pow(op._1, op._2.toDouble - 1.0).toInt }
}
implicit def intToP37Int(i: Int): P37Int = new P37Int(i)

/*
scala> 315.totient
res0: Int = 144
*/
