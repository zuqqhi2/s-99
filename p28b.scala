def lsortFreq[A](items: List[List[A]]): List[List[A]] = {
  (items groupBy (_.size)).toList sortBy (_._2.size) flatMap (_._2)
}

/*
lsortFreq: [A](items: List[List[A]])List[List[A]]

scala> lsortFreq(List())
res0: List[List[Nothing]] = List()

scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
*/
