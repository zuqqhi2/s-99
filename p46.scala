package logic {
  object S99Logic {
    def _not(op1: Boolean) = op1 match {
      case true  => false
      case false => true
    }

    def _and(op1: Boolean, op2: Boolean) = (op1, op2) match {
      case (true, true) => true
      case _            => false
    }
    
    def _or(op1: Boolean, op2: Boolean) = (op1, op2) match {
      case (false, false) => false
      case _              => true
    }

    def _nand(op1: Boolean, op2: Boolean) = _not(_and(op1, op2))
    def _nor(op1: Boolean, op2: Boolean)  = _not(_or(op1, op2))
    def _equ(op1: Boolean, op2: Boolean)  = op1 == op2
    def _xor(op1: Boolean, op2: Boolean)  = _not(_equ(op1, op2))
    def _impl(op1: Boolean, op2: Boolean) = _or(_not(op1), op2)

    def table2(func: (Boolean, Boolean) => Boolean) {
      println("A\tB\tresult")
      for (a <- List(true, false)) {
        for (b <- List(true, false)) {
          println(a + "\t" + b + "\t" + func(a, b))
        }
      }
    }

    def main(args: Array[String]) {
      println("### not ###")
      println("true  => " + _not(true))
      println("false => " + _not(false))
      
      println("\n### and ###")
      table2( (op1: Boolean, op2: Boolean) => _and(op1, op2) )
      
      println("\n### or ###")
      table2( (op1: Boolean, op2: Boolean) => _or(op1, op2) )
      
      println("\n### nand ###")
      table2( (op1: Boolean, op2: Boolean) => _nand(op1, op2) )
      
      println("\n### nor ###")
      table2( (op1: Boolean, op2: Boolean) => _nor(op1, op2) )

      println("\n### equ ###")
      table2( (op1: Boolean, op2: Boolean) => _equ(op1, op2) )

      println("\n### xor ###")
      table2( (op1: Boolean, op2: Boolean) => _xor(op1, op2) )

      println("\n### impl ###")
      table2( (op1: Boolean, op2: Boolean) => _impl(op1, op2) )
    }
  }
}


/*
### not ###
true  => false
false => true

### and ###
A       B       result
true    true    true
true    false   false
false   true    false
false   false   false

### or ###
A       B       result
true    true    true
true    false   true
false   true    true
false   false   false

### nand ###
A       B       result
true    true    false
true    false   true
false   true    true
false   false   true

### nor ###
A       B       result
true    true    false
true    false   false
false   true    false
false   false   true

### equ ###
A       B       result
true    true    true
true    false   false
false   true    false
false   false   true

### xor ###
A       B       result
true    true    false
true    false   true
false   true    true
false   false   false

### impl ###
A       B       result
true    true    true
true    false   false
false   true    true
false   false   true
*/
