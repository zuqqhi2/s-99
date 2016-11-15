def randomPermute[A](inputAry: List[A], num: Int = 0): List[A] = {
  if (num == inputAry.size || inputAry.size == 0) List()
  else inputAry((new scala.util.Random).nextInt(inputAry.size)) :: randomPermute(inputAry, num + 1)
}

/*
scala> def randomPermute[A](inputAry: List[A], num: Int = 0): List[A] = {
     |   if (num == inputAry.size || inputAry.size == 0) List()
     |   else inputAry((new scala.util.Random).nextInt(inputAry.size)) :: randomPermute(inputAry, num + 1)
     | }
randomPermute: [A](inputAry: List[A], num: Int)List[A]

scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('c, 'e, 'd, 'b, 'd, 'b)

scala> randomPermute(List())
res1: List[Nothing] = List()
*/
