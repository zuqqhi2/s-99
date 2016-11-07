def rotate[A](startIdx: Int, inputAry: List[A]): List[A] = {
  val rotatedElems  = if (startIdx < 0) inputAry.take(inputAry.size + startIdx) else inputAry.take(startIdx) 
  val nochangeElems = if (startIdx < 0) inputAry.drop(inputAry.size + startIdx) else inputAry.drop(startIdx) 

  nochangeElems ::: rotatedElems
}

/*
scala> def rotate[A](startIdx: Int, inputAry: List[A]): List[A] = {
     |   val rotatedElems  = if (startIdx < 0) inputAry.take(inputAry.size + startIdx) else inputAry.take(startIdx)
     |   val nochangeElems = if (startIdx < 0) inputAry.drop(inputAry.size + startIdx) else inputAry.drop(startIdx)
     |
     |   nochangeElems ::: rotatedElems
     | }
rotate: [A](startIdx: Int, inputAry: List[A])List[A]

scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
*/
