class P35Int (val i: Int) {
  def primeFactors:List[Int] = {
    def applyFactors(target:Int, factors:List[Int], result:List[Int] = List()):List[Int] = (target, factors) match {
      case (t, _) if t <= 1 => result
      case (t, Nil)         => t :: result
      case (t, x :: xs)     => if (t % x == 0) applyFactors(t/x, x :: xs, x :: result)
                               else applyFactors(t, xs, result)
    }
    val primes = (2::(3 to i by 2).toList).toSeq diff (for (x <- 2::((3 to i by 2).toList); y <- 2 to i) yield x*y).toSeq
    applyFactors(i, primes.toList)
  }
}
implicit def intToP35Int(i: Int): P35Int = new P35Int(i)

/*
scala> class P35Int (val i: Int) {
     |   def primeFactors:List[Int] = {
     |     def applyFactors(target:Int, factors:List[Int], result:List[Int] = List()):List[Int] = (target, factors) match {
     |       case (t, _) if t <= 1 => result
     |       case (t, Nil)         => t :: result
     |       case (t, x :: xs)     => if (t % x == 0) applyFactors(t/x, x :: xs, x :: result)
     |                                else applyFactors(t, xs, result)
     |     }
     |     val primes = (2::(3 to i by 2).toList).toSeq diff (for (x <- 2::((3 to i by 2).toList); y <- 2 to i) yield x*y).toSeq
     |     applyFactors(i, primes.toList)
     |   }
     | }
defined class P35Int

scala> implicit def intToP35Int(i: Int): P35Int = new P35Int(i)
warning: there was one feature warning; re-run with -feature for details
intToP35Int: (i: Int)P35Int

scala> 315.primeFactors
res0: List[Int] = List(7, 5, 3, 3)
*/
