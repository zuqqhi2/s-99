def duplicateN[A](numDup: Int, inputList: List[A]): List[A] = inputList flatMap { List.fill(numDup)(_) }
