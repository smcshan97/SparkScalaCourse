package Lectures.part1basics

class ShyExpressions {
  Val x = 1+2

  Println(2+3+4)

  var aVariable = 2
  aVariable += 2

  println(aVariable)

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3

  println(aConditionedValue)

  println(if (aCondition)5 else 3)

  var i = 0
  while(i <10) {
    println(i)
    i += 1
  }

  var aWeirdValue = (aVariable = 3)

  println(aWeirdValue)

  val aWhile = while (i <10) {
    println(i)
    i += 1
  }
  val aCodeBlock = {
    val y = 2
    val z = y +1
    if (z>2) "hello" else "bye"
  }

  Val message: String = "hello"
  val x=3
  val y=x + "items"

  def succ( x: Int): Int = x + 1

  def factorial(x: Int): Int =
    if (x<= 0) 1
    else {
      print("computing factorial of"+ x + "I first ned the factorial of "+ (x-1) )
      x * factorial(x - 1)
      println("Computing factorial of"+ x)
      result

    }
def anotherfactorial (n : Bigint ) = {
  @tailrec
  def facthelper(x:int,accumulator:BigInt):BigInt = {
    if (x <= 1) accumulator
    else facthelper(x - 1, x * accumulator)
  }
  facthelper(n, accumulator=1)
}
Println(anotherfactorial(5000))

  def fib(n: Int): Int = {
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail(n - 1, b, a + b)
    }
    return fib_tail(n, 0 , 1)
  }
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 2) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n/2)
  }
  def main(args: Array[String])
  {
    var str1 = "Yurrr ";
    var str2 =  "Wassup";
    println("After concatenate two string: " + str1 + str2);
}
