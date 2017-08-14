class P40Int (val i: Int) {
  // Prime array 
  val primes = (2::(3 to i by 2).toList).toSeq diff (for (x <- (3 to i by 2).toList; y <- 2 to i) yield x*y).toSeq

  // If target value is prime, the remainder should not be 0 for all primes less than square root of target.
  def isPrime = ((2 to i).toSeq diff (for (x <- 2 to Math.sqrt(i).toInt; y <- 2 to i) yield x*y).toSeq) contains (i)

  // Find two primes which sum of them is given number
  def goldbach: (Int,Int) = {
    val candidates = primes filter { x => (new P40Int(i - x)).isPrime }
    (candidates(0), i - candidates(0))
  }
}

implicit def intToP40Int(i: Int): P40Int = new P40Int(i)

/*
scala> 28.goldbach
res0: (Int, Int) = (5,23)
*/
