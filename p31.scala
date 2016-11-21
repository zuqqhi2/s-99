class P31Int (val i: Int) {
  def isPrime = ((2 to i).toSeq diff (for (x <- 2 to Math.sqrt(i).toInt; y <- 2 to i) yield x*y).toSeq) contains (i)
}
implicit def intToP31Int(i: Int): P31Int = new P31Int(i)

/*
scala> class P31Int (val i: Int) {
     |   def isPrime = ((2 to i).toSeq diff (for (x <- 2 to Math.sqrt(i).toInt; y <- 2 to i) yield x*y).toSeq) contains (i)
     | }
defined class P31Int

scala> implicit def intToP31Int(i: Int): P31Int = new P31Int(i)
warning: there were 1 feature warning(s); re-run with -feature for details
intToP31Int: (i: Int)P31Int

scala> 7.isPrime
res0: Boolean = true

scala> 10.isPrime
res1: Boolean = false
*/
