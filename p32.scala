def gcd(op1: Int, op2: Int): Int = if (op1 == 0 || op2 == 0) throw new IllegalArgumentException else if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)

/*
scala> def gcd(op1: Int, op2: Int): Int = if (op1 == 0 || op2 == 0) throw new IllegalArgumentException else if (op1 % op2 == 0) op2 else gcd(op2, op1 % op2)
gcd: (op1: Int, op2: Int)Int

scala> gcd(36, 63)
res0: Int = 9

scala> gcd(63, 36)
res1: Int = 9

scala> gcd(63, 0)
java.lang.IllegalArgumentException
  at .gcd(<console>:11)
  ... 32 elided
*/
