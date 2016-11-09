def removeAt[A](removeIdx: Int, inputAry: List[A]): (List[A], A) = {
  ( inputAry filter (_ != inputAry(removeIdx)), inputAry(removeIdx) )
}

/*
scala> def removeAt[A](removeIdx: Int, inputAry: List[A]): (List[A], A) = {
     |   ( inputAry filter (_ != inputAry(removeIdx)), inputAry(removeIdx) )
     | }
removeAt: [A](removeIdx: Int, inputAry: List[A])(List[A], A)

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
*/
