def drop[A](dropIdx: Int, inputList: List[A], curIdx: Int = 1): List[A] = inputList match {
  case Nil                              => List()
  case x :: xs if curIdx % dropIdx > 0  => x :: drop(dropIdx, xs, curIdx + 1)
  case x :: xs                          => drop(dropIdx, xs, curIdx + 1)
}
