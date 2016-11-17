def group3[A](maxMembers: List[Int], items: List[A]): List[List[List[A]]] = {
  def pos3(num: Int, limits: List[Int], result: List[List[Int]] = List(List())): List[List[Int]] = {
    if (num == 0) result
    else {
      val combList = for (x <- result; y <- 0 to 2) yield {
        if ( (y :: x filter (_ == 0)).size > limits(0) )  List()
        else if ( (y :: x filter (_ == 1)).size > limits(1) ) List()
        else if ( (y :: x filter (_ == 2)).size > limits(2) ) List()
        else y :: x
      }
      pos3( num-1, limits, combList filter (_.size >= 1) )
    }
  }

  val poses = pos3(items.size, maxMembers)
  for (x <- poses) yield {
    val x0 = x.zipWithIndex filter (_._1 == 0) map (y => items(y._2) )
    val x1 = x.zipWithIndex filter (_._1 == 1) map (y => items(y._2) )
    val x2 = x.zipWithIndex filter (_._1 == 2) map (y => items(y._2) )
    List(x0, x1, x2)
  }
}

/*
group3: [A](maxMembers: List[Int], items: List[A])List[List[List[A]]]

scala> group3(List(2, 2, 1), List('a, 'b, 'c, 'd, 'e))
res0: List[List[List[Symbol]]] = List(List(List('d, 'e), List('b, 'c), List('a)), List(List('d, 'e), List('a, 'c), List('b)), List(List('d, 'e), List('a, 'b), List('c)), List(List('c, 'e), List('b, 'd), List('a)), List(List('c, 'e), List('a, 'd), List('b)), List(List('b, 'e), List('c, 'd), List('a)), List(List('a, 'e), List('c, 'd), List('b)), List(List('b, 'e), List('a, 'd), List('c)), List(List('a, 'e), List('b, 'd), List('c)), List(List('c, 'e), List('a, 'b), List('d)), List(List('b, 'e), List('a, 'c), List('d)), List(List('a, 'e), List('b, 'c), List('d)), List(List('c, 'd), List('b, 'e), List('a)), List(List('c, 'd), List('a, 'e), List('b)), List(List('b, 'd), List('c, 'e), List('a)), List(List('a, 'd), List('c, 'e), List('b)), List(List('b, 'd), List('a, 'e), List('c)), List(List('...
scala> group3(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res1: List[List[List[String]]] = List(List(List(Hugo, Ida), List(Flip, Gary), List(Aldo, Beat, Carla, David, Evi)), List(List(Hugo, Ida), List(Evi, Gary), List(Aldo, Beat, Carla, David, Flip)), List(List(Hugo, Ida), List(David, Gary), List(Aldo, Beat, Carla, Evi, Flip)), List(List(Hugo, Ida), List(Carla, Gary), List(Aldo, Beat, David, Evi, Flip)), List(List(Hugo, Ida), List(Beat, Gary), List(Aldo, Carla, David, Evi, Flip)), List(List(Hugo, Ida), List(Aldo, Gary), List(Beat, Carla, David, Evi, Flip)), List(List(Hugo, Ida), List(Evi, Flip), List(Aldo, Beat, Carla, David, Gary)), List(List(Hugo, Ida), List(David, Flip), List(Aldo, Beat, Carla, Evi, Gary)), List(List(Hugo, Ida), List(Carla, Flip), List(Aldo, Beat, David, Evi, Gary)), List(List(Hugo, Ida), List(Beat, Flip), List(Aldo, Carla,...
*/
