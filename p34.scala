class P34Int (val i: Int) {
  def gcd(op1: Int, op2: Int): Int = if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)
  def totient:Int = (for (m <- (1 to i).toList if gcd(i,m) == 1) yield m).toList.size
}
implicit def intToP34Int(i: Int): P34Int = new P34Int(i)

/*
scala> class P34Int (val i: Int) {
     |   def gcd(op1: Int, op2: Int): Int = if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)
     |   def totient:Int = (for (m <- (1 to i).toList if gcd(i,m) == 1) yield m).toList.size
     | }
defined class P34Int

scala> implicit def intToP34Int(i: Int): P34Int = new P34Int(i)
warning: there was one feature warning; re-run with -feature for details
intToP34Int: (i: Int)P34Int

scala> 10.totient
res0: Int = 4

scala> 7.totient
res1: Int = 6
*/
