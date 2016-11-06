def slice[A](startIdx: Int, endIdx: Int, inputAry: List[A]): List[A] = {
  inputAry.drop(startIdx).take(endIdx - startIdx)
}

/*
scala> def slice[A](startIdx: Int, endIdx: Int, inputAry: List[A]): List[A] = {
     |   inputAry.drop(startIdx).take(endIdx - startIdx)
     | }
slice: [A](startIdx: Int, endIdx: Int, inputAry: List[A])List[A]

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
*/
