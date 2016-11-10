def insertAt[A](newItem: A, insertIdx: Int, inputAry: List[A]): List[A] = {
  if (newItem == Nil) throw new IllegalArgumentException("newItem should not be Nil.")
  if (insertIdx < 0 || insertIdx > inputAry.size) throw new IllegalArgumentException("illegal insertIdx.")

  val splittedAry = inputAry splitAt insertIdx  
  splittedAry._1 ::: List(newItem) ::: splittedAry._2
}

/*
scala> def insertAt[A](newItem: A, insertIdx: Int, inputAry: List[A]): List[A] = {
     |   if (newItem == Nil) throw new IllegalArgumentException("newItem should not be Nil.")
     |   if (insertIdx < 0 || insertIdx > inputAry.size) throw new IllegalArgumentException("illegal insertIdx.")
     |
     |   val splittedAry = inputAry splitAt insertIdx
     |   splittedAry._1 ::: List(newItem) ::: splittedAry._2
     | }
insertAt: [A](newItem: A, insertIdx: Int, inputAry: List[A])List[A]

scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

scala> insertAt(Nil, 1, List('a, 'b, 'c, 'd))
java.lang.IllegalArgumentException: newItem should not be Nil.

scala> insertAt('a, -1, List('a, 'b, 'c, 'd))
java.lang.IllegalArgumentException: illegal insertIdx.
*/
