def range(start: Int, end: Int): List[Int] = {
  if (start > end) List()
  else List(start) ::: range(start + 1, end)
}

/*
scala> def range(start: Int, end: Int): List[Int] = {
     |   if (start > end) List()
     |   else List(start) ::: range(start + 1, end)
     | }
range: (start: Int, end: Int)List[Int]

scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)

scala> range(-1, -2)
res1: List[Int] = List()

scala> range(-3, -1)
res2: List[Int] = List(-3, -2, -1)
*/
