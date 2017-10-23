package logic {
  object S99Logic {
    def cross(xs: List[String], ys: List[String]):List[String] = for { x <- xs; y <- ys } yield x ++ y

    def gray(codeLength: Integer): List[String] = {
      val binaryStr = List("0", "1")

      var grayCode = binaryStr
      for (numRepeat <- 2 to codeLength) {
        grayCode = cross(List("0"), grayCode) ++ cross(List("1"), grayCode).reverse
      }

      grayCode
    }
    
    def main(args: Array[String]) {
      println("### Length 1 ###")
      println(gray(1))

      println("\n### Length 2 ###")
      println(gray(2))

      println("\n### Length 3 ###")
      println(gray(3))

      println("\n### Length 4 ###")
      println(gray(4))
      
      println("\n### Length 5 ###")
      println(gray(5))
    }
  
  }
}
