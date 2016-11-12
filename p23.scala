def randomSelect[A](num: Int, inputAry: List[A]): List[A] = {
  if (num == 0 || inputAry.size == 0) {
    List()
  } else {
    val idx = (new scala.util.Random).nextInt(inputAry.size)
    inputAry(idx) :: randomSelect(num - 1, inputAry)
  }
}

/*
scala> def randomSelect[A](num: Int, inputAry: List[A]): List[A] = {
     |   if (num == 0 || inputAry.size == 0) {
     |     List()
     |   } else {
     |     val idx = (new scala.util.Random).nextInt(inputAry.size)
     |     inputAry(idx) :: randomSelect(num - 1, inputAry)
     |   }
     | }
randomSelect: [A](num: Int, inputAry: List[A])List[A]

scala> randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
res0: List[Symbol] = List('d, 'h, 'd)

scala> randomSelect(3, List())
res1: List[Nothing] = List()
*/
