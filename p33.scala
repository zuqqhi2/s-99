class P33Int (val i: Int) {
  def gcd(op1: Int, op2: Int): Int = if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)
  def isCoprimeTo(n: Int):Boolean = gcd(i, n) == 1
}
implicit def intToP33Int(i: Int): P33Int = new P33Int(i)

/*
scala> class P33Int (val i: Int) {
     |   def gcd(op1: Int, op2: Int): Int = if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)
     |   def isCoprimeTo(n: Int):Boolean = gcd(i, n) == 1
     | }
defined class P33Int

scala> implicit def intToP33Int(i: Int): P33Int = new P33Int(i)
warning: there was one feature warning; re-run with -feature for details
intToP33Int: (i: Int)P33Int

scala> 35.isCoprimeTo(64)
res0: Boolean = true

scala> 34.isCoprimeTo(64)
res1: Boolean = false
*/
