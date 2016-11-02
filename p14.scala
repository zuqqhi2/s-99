def duplicate[A](inputList: List[A]): List[A] = inputList flatMap { List.fill(2)(_) }
