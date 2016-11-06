def split[A](splitIdx: Int, inputAry: List[A]): (List[A], List[A]) = {
  val splittedAryWithIdx = inputAry.zipWithIndex.span(_._2 < splitIdx)
  
  ( splittedAryWithIdx._1.map(_._1), splittedAryWithIdx._2.map(_._1) )
}

/*
scala> def split[A](splitIdx: Int, inputAry: List[A]): (List[A], List[A]) = {
     |   val splittedAryWithIdx = inputAry.zipWithIndex.span(_._2 < splitIdx)
     |
     |   ( splittedAryWithIdx._1.map(_._1), splittedAryWithIdx._2.map(_._1) )
     | }
split: [A](splitIdx: Int, inputAry: List[A])(List[A], List[A])

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
*/
