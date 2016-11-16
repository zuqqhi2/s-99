def combinations[A](num: Int, items: List[A], result: List[List[A]] = List(List())): List[List[A]] = {
  if (num == 0) result
  else {
    val check = collection.mutable.Map[collection.immutable.Set[A],Boolean]()
    val combList = for (x <- result; y <- items) yield {
      val newItem = y :: x
      val result = (if ((x filter (_ == y)).size >= 1 || check.contains(newItem.toSet)) List() else newItem).toList
      check += newItem.toSet -> true
      result
    }
    combinations( num-1, items, combList filter (_.size >= 1) )
  }
}

/*
scala> def combinations[A](num: Int, items: List[A], result: List[List[A]] = List(List())): List[List[A]] = {
     |   if (num == 0) result
     |   else {
     |     val check = collection.mutable.Map[collection.immutable.Set[A],Boolean]()
     |     val combList = for (x <- result; y <- items) yield {
     |       val newItem = y :: x
     |       val result = (if ((x filter (_ == y)).size >= 1 || check.contains(newItem.toSet)) List() else newItem).toList
     |       check += newItem.toSet -> true
     |       result
     |     }
     |     combinations( num-1, items, combList filter (_.size >= 1) )
     |   }
     | }
combinations: [A](num: Int, items: List[A], result: List[List[A]])List[List[A]]

scala> combinations(3, List('a,'b,'c,'d,'e))
res0: List[List[Symbol]] = List(List('c, 'b, 'a), List('d, 'b, 'a), List('e, 'b, 'a), List('d, 'c, 'a), List('e, 'c, 'a), List('e, 'd, 'a), List('d, 'c, 'b), List('e, 'c, 'b), List('e, 'd, 'b), List('e, 'd, 'c))

scala> combinations(3, List('a,'b,'c,'d,'e,'f,'g,'h,'i,'j,'k,'l)).size
res1: Int = 220
*/
