/**
 * Check given value is prime or not.
 * @param target check target value.
 * @return true when a given number is prime.
 *         false otherwise.
 */
def isPrime (target:Int): Boolean = {
  // If target value is prime, the remainder should not be 0 for all primes less than square root of target.
  2 :: (3 to scala.Math.sqrt(target).toInt by 2).toList forall { target % _ != 0 }
}

/**
 * Pick up primes from given list.
 * @param targetRange integer range
 * @return prime value list
 */
def listPrimesinRange (targetRange:Range): List[Int] = targetRange.toList.filter(isPrime(_))

/*
scala> listPrimesinRange(7 to 31)
res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
*/
