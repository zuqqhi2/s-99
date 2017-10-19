package logic {
  class S99Logic(op1: Boolean) {
    import S99Logic._

    def _and(op2: Boolean) = (op1, op2) match {
      case (true, true) => true
      case _            => false
    }
    
    def _or(op2: Boolean) = (op1, op2) match {
      case (false, false) => false
      case _              => true
    }

    def _nand(op2: Boolean) = _not(op1 _and op2)
    def _nor(op2: Boolean)  = _not(op1 _or op2)
    def _equ(op2: Boolean)  = op1 == op2
    def _xor(op2: Boolean)  = _not(op1 _equ op2)
    def _impl(op2: Boolean) = _not(op1) _or op2
  }

  object S99Logic {
    implicit def boolean2S99Logic(op1: Boolean): S99Logic = new S99Logic(op1)
    
    def _not(op1: Boolean) = op1 match {
      case true  => false
      case false => true
    }
    
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
      table2( (op1: Boolean, op2: Boolean) => op1 _and op2 )
        
      println("\n### or ###")
      table2( (op1: Boolean, op2: Boolean) => op1 _or op2 )
        
      println("\n### nand ###")
      table2( (op1: Boolean, op2: Boolean) => op1 _nand op2 )
        
      println("\n### nor ###")
      table2( (op1: Boolean, op2: Boolean) => op1 _nor op2 )
  
      println("\n### equ ###")
      table2( (op1: Boolean, op2: Boolean) => op1 _equ op2 )
  
      println("\n### xor ###")
      table2( (op1: Boolean, op2: Boolean) => op1 _xor op2 )
  
      println("\n### impl ###")
      table2( (op1: Boolean, op2: Boolean) => op1 _impl op2 )
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
