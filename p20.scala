def removeAt[A](removeIdx: Int, inputAry: List[A]): (List[A], A) = {
  if (removeIdx < 0 || inputAry.size == 0)
    throw new NoSuchElementException
  else
    ( (inputAry.zipWithIndex filter (_._2 != removeIdx)) map (_._1), inputAry(removeIdx) )
}

/*
scala> def removeAt[A](removeIdx: Int, inputAry: List[A]): (List[A], A) = {
     |   if (removeIdx < 0 || inputAry.size == 0)
     |     throw new NoSuchElementException
     |   else
     |     ( (inputAry.zipWithIndex filter (_._2 != removeIdx)) map (_._1), inputAry(removeIdx) )
     | }
removeAt: [A](removeIdx: Int, inputAry: List[A])(List[A], A)

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

scala> removeAt(1, List('a, 'b, 'b, 'c, 'd))
res1: (List[Symbol], Symbol) = (List('a, 'b, 'c, 'd),'b)

scala> removeAt(-1, List('a, 'b, 'b, 'c, 'd))
java.util.NoSuchElementException
  at .removeAt(<console>:13)
  ... 32 elided

scala> removeAt(10, List())
java.util.NoSuchElementException
  at .removeAt(<console>:13)
  ... 32 elided
*/
