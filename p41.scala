class P41Int (val i: Int) {
  // Prime array 
  val primes = (2::(3 to i by 2).toList).toSeq diff (for (x <- (3 to i by 2).toList; y <- 2 to i) yield x*y).toSeq

  // If target value is prime, the remainder should not be 0 for all primes less than square root of target.
  def isPrime = ((2 to i).toSeq diff (for (x <- 2 to Math.sqrt(i).toInt; y <- 2 to i) yield x*y).toSeq) contains (i)

  // Find two primes which sum of them is given number
  def goldbach: (Int,Int) = {
    val candidates = primes filter { x => (new P41Int(i - x)).isPrime }
    (candidates(0), i - candidates(0))
  }

}

implicit def intToP41Int(i: Int): P41Int = new P41Int(i)

def printGoldbachList(r:Range): Unit = {
  (for (x <- r) yield new P41Int(x)).toList map (_.goldbach) map { (x, y) => println( (x+y).toString + " = " + x.toString + " + " + y.toString )
}


/*
scala> printGoldbachList(9 to 20)
10 = 3 + 7
12 = 5 + 7
14 = 3 + 11
16 = 3 + 13
18 = 5 + 13
20 = 3 + 17
res10: List[Unit] = List((), (), (), (), (), ())
*/
