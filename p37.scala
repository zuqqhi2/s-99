class P37Int (val i: Int) {
  def primeFactorMultiplicity:Map[Int,Int] = {
    def applyFactors(target:Int, factors:List[Int], result:Map[Int,Int] = Map.empty):Map[Int,Int] = (target, factors) match {
      case (t, _) if t <= 1             => result
      case (t, Nil)                     => if (result.contains(t)) result updated (t, result(t) + 1) else result + (t -> 1)
      case (t, x :: xs) if (t % x == 0) => if (result.contains(x)) applyFactors(t/x, x :: xs, result updated (x, result(x) + 1))
                                           else applyFactors(t/x, x :: xs, result + (x -> 1))
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
