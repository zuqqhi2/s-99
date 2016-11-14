def lotto(num: Int, maxVal: Int, hist: Map[Int,Boolean] = Map()): List[Int] = {
  if (num < 0) throw new IllegalArgumentException("num is invalid")
  if (num == 0) {
    List()
  } else {
    val randVal = (new scala.util.Random).nextInt(maxVal) + 1
    if (!hist.getOrElse(randVal, false))
      randVal :: lotto(num-1, maxVal, hist + (randVal -> true))
    else 
      lotto(num, maxVal, hist)
  }
}

/*
scala> def lotto(num: Int, maxVal: Int, hist: Map[Int,Boolean] = Map()): List[Int] = {
     |   if (num < 0) throw new IllegalArgumentException("num is invalid")
     |   if (num == 0) {
     |     List()
     |   } else {
     |     val randVal = (new scala.util.Random).nextInt(maxVal) + 1
     |     if (!hist.getOrElse(randVal, false))
     |       randVal :: lotto(num-1, maxVal, hist + (randVal -> true))
     |     else
     |       lotto(num, maxVal, hist)
     |   }
     | }
lotto: (num: Int, maxVal: Int, hist: Map[Int,Boolean])List[Int]

scala> lotto(6, 49)
res0: List[Int] = List(36, 1, 10, 38, 23, 30)

scala> lotto(-1, 49)
java.lang.IllegalArgumentException: num is invalid
*/
