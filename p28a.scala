def lsort[A](items: List[List[A]]): List[List[A]] = {
  (items groupBy (_.size)).toList sortBy (_._1) flatMap (_._2)
}

/*
lsort: [A](items: List[List[A]])List[List[A]]

scala> lsort(List())
res0: List[List[Nothing]] = List()

scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res1: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
*/
