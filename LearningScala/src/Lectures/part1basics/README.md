## Values, variables and Types
We'll discuss the basic blocks of Scala.

Before proceeding, let's create a new file as descirbed below:
1. Right-click on lectures and create a new package.
2. Name it part1basics
3. Create a new Scala class "ValuesVariablesTypes" and create it as an `object`.


Add the following to the object definition:
```scala
object ValuesVariablesTypes extends App{}
```

We need this change in order to run the file in IntelliJ or IDE.

Let's create a value:
```scala
val x: Int = 42
```
Print this to the console using:
```scala
println(x)
```

Try giving a new value to x:
```scala
x = 2 // this will upset the compiler
```

__Vals cannot be reassigned. THEY ARE IMMUTABLE.__
They act like constants or final in Java.

Now, delete the type of x:
```scala
val x = 42

```
It will still run with no errors. Compiler decides the type of x by looking at the value on the right.
So compiler knows `x` is an int.

COMPILER CAN INFER TYPES.

If you do mention the type, make sure the right hand side conforms to the type. Otherwise, compiler will complain.

Let's use some other types:
```scala
var aString: String = "Hello, This is a string"
var aBoolean: Boolean = false // or true
val aCharacter: Char = 'c'
var anInt: Int = 45 // or another int val like x
var aShort: Short = 4613 //try assigning a huge number.
var aLong: Long = 1232341234134L

// decimal values
val aFloat: Float = 2.0f // f is needed otherwise it will be treated as a double
val aDouble: Double = 3.14
```

NOTE: SEMI-COLONS ARE NOT NECESSARY IN SCALA. THEY'RE ONLY NEEDED IF THERE ARE MULTUPLE EXPRESSIONS ON THE SAME LINE.


Let's check out the concept of Variables. They are defined using the keyword `var`
```scala
var aVariable: Int = 4
```

Variables can be re-assigned.

```scala
aVariable = 5 // side-effects
```

## Expressions
Now that you know what values and variables are, let's take a look at expressions.

Before proceeding:
1. Create a new object like above "Expressions"/
2. Make it extend "App".

Consider this code:
```scala
val x = 1 + 2
```

Right side `1+2` is called an EXPRESSION.

They have a type, so for example here it is Int.

```scala
println(2 + 3 * 4) // math expression
```
Math expressions preserve the operator ordering. Refer to BODMOS rule.

Other operators are:
```scala
+ - * / & | ^ << >> >>> right shift with zero extension)
```

Relational operations are:
```scala
== ~= > >= < <=
```

Boolean operators are:
```scala
! && ||
```

Consider this code:
```scala
var aVariable = 2
aVariable += 2 // also works with -= *= /=
println(aVariable)
```

The above operators only work with variables, hence they introduce side-effects.

Instructions vs expressions:
Instruction is something that we tell a computer to do. Imperative languages like Java use instructions.
By contrast, expression is something that has a value and/or a type.

In Scala, we always think in terms of expression.

Consider the IF expression:
```scala
val aCondition = true
val aConditionedValue = if(aCondition) 5 else 3
println(aConditionedValue)
```

The `aConditionedValue` is either 5 or 3 based on the value of `aCondition`.
Here, unlike other languages where we define a block of instructions that are executed based on the condition, if staements in Scala return a value.

To prove, use the if expression as is:
```scala
println(if(aCondition) 5 else 3)
```

IF IN SCALA IN EXPRESSIONS


Now that we know about `if`, let's consider loops.

Scala discourages the use of loops as they introduce side-effects. Consider the following:

```scala
var i = 0
while (i < 10) {
  println(i)
  i += 1
}
```
NEVER WRITE THIS CODE AGAIN. But how do we iterate? Use recursions.

Consider the following:
```scala
var aWeirdValue = (aVariable = 3)
```

Type of the `aWeirdValue` is `Unit`. Unit is a special type in Scala which means, don't return anything.

Use this code to print the value of the variable `aWeirdValue`
```scala
println(aWeirdValue)
```


Consider the following modified while loop:
```scala
val aWhile = while (i < 10) {
  println(i)
  i += 1
}
```

side-effects include println(), whiles, reassigning etc.

Code blocks:
Consider the following code:
```scala
val aCodeBlock =  {
  val y = 2
  val z = y + 1
  if (z > 2) "hello" else "bye"
}
```
Important:
1. Code block is an expression
2. Type of the code block is the same as that of the last line in the code block
3. Everything declared inside the code-block stays inside. Try running `println(z)` outside the code block.

## Functions
What does the compiler figure-put if we don't specify any type in the expression?

If we don't specify any type, the compiler will look at the right hand side and determine the type.

Consider the following:
```scala
val message = "hello"
```

The compiler will change the above code to:
```scala
val message: String = "hello"
```

Same applies for the following codes:
```scala
val x = 2 // an Int, so x is an Int
val y = x + "items" // Int + String = String, so y is a String
```

Compiler can also determine the return type of a function:
```scala
def succ(x: Int) = x + 1
```

This is equivalent to the following:

```scala
def succ(x: Int): Int
```
THe return type above is an int, so the compiler will determine the return type of the function as an Int.

Try running the following:
```scala
val x: Int = "hello" //compiler error for type-mismatch
```

Sometimes the compiler is not able to determine the type. Consider the following code:

```scala
def factorial(n: Int) =
    if (n <= 0) 1
    else n * factorial(n - 1)
```

The above code is an example of recursion. Now the compiler has two branches to determine the return type.

One branch is returning an "int" and other is returning a "function". Compiler doesn't know the type of the function now.

Hence we have to specify the type.


## Recursion (stack and tail)
Create a new object with name "Recusrion" and extend "App".

Consider the following code:

```scala

def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)
```
Technical detail:
1. When Java sees recursion it uses a stack to store the intermediate results.
2. This is called call-stack.

Change the above code to:

```scala

def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorian of " + n  + "  - I first need factorial of " + n - 1)
      var result = n * factorial(n - 1)
      println("Computer factorial of " + n)
      result
    }
```

Let's use the above code to calculate the factorial of 10
```scala

println(factorial(10))
```

We should get a lot of print statements that shows the call stack.

The trouble with this approach is that Java keeps a limited memory for call-stack.

Calculate the following:
```scala
println(factorial(5000))
```

We get a sStackOverFlow error.

This is bad. But earlier, we discussed that loops are bad and we should use recursions and here recursion is also bad.
Then how do we perform iterations?

We have to write code in a smart-way.

Consider the following code:
```scala
def anotherFactorial(n: Int): Int = {
  def factHelper(x: Int, accumulator: Int): Int =
    if (x <= 1) accumulator
    else factHelper(x - 1, x * accumulator)
  factHelper(n, 1)
}
```

How does this work?
```scala
anotherFactorial(10) = factHelper(10, 1)
= factHelper(9, 10 * 1)
= factHelper(8, 9 * 10 * 1)
= factHelper(7, 8 * 9 * 10 * 1)
= factHelper(6, 7 * 8 * 9 * 10 * 1)
.
.
.
= factHelper(2, 3 * 4 * ...* 10 * 1)
= factHelper(1, 2 * 3 * 4 .... * 10 * 1)
```

Now try calculating the factorial of 5000
```scala
println(anotherFactorial(5000))
```
 We will run out of integer so we have to use `BigInt`
 Modify the code to :
 ```scala
def anotherFactorial(n: Int): BigInt = {
  def factHelper(x: Int, accumulator: BigInt): Int =
    if (x <= 1) accumulator
    else factHelper(x - 1, x * accumulator)
  factHelper(n, 1)
```

Why does this code run and not the previous one?
The trick in in the else part. We are using the computation as the last expression of the recursion.
This allows Scala to use the same the call-stack unlike the previous code which creates a new stack everytime.

THIS IS CALLED TAIL RECURSION
KEY HERE IS TO USE THE RECURSIVE CALL AS THE LAST EXPRESSION

If you want to make sure that the compiler treats the method as `tailrec` use the `@tailrec` annotation

 ```scala
def anotherFactorial(n: Int): BigInt = {
   @tailrec
  def factHelper(x: Int, accumulator: BigInt): Int =
    if (x <= 1) accumulator
    else factHelper(x - 1, x * accumulator)
  factHelper(n, 1)
```
WHEN YOU NEED LOOPS, USE TAIL RECURSION.

Exercises:
1. Concatenate a string n-times.
2. isPrime function which is tail recursive
3. Fibonacci function which is tail recursive.

Solutions:
```scala
  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)
  println(concatenateTailrec("hello", 3, ""))
```

```scala
def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))
```

```scala
 def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
```


## Call-by-name and Call-by-value
Create a new object called "CBNvsCBV" which extends App.

Consider the following code (we don't care about the return type)

```scala
def calledByValue(x: Long) : Unit =  {
  println("by value: " + x)
  println("by value: " + x)
}

def calledByName(x: => Long): Unit = {
  println("by name: " + x)
    println("by name: " + x)
}
```
Now, invoke the above functions using the following:

```scala
calledByValue(System.nanoTime())
calledByName(System.nanoTime())
```

The above code should print the value of `System.nanoTime()` 4-times. Let's examine the output.

The third and fourth values are different.

The reason we chose `Long` is because the System.nanoTime() returns a long time.

The `=>` makes a lot of difference above.

In the byValue call, the exact value of the exprssion is computed before calling the function.

SO here, the `System.nanoTime()` is first called and is then passed to the `calledByValue` function.

By contrast, in case of by name, the expression is passed as is. Hence it is executed twice in the above code.

The `=>` delays the evaluation of the expression.

Consider the following code:
```scala
def infinite(): Int = 1 + infinite()
def printFirst(x: Int, y: => Int) = println(x)

printFirst(infinite(), 34) // we expect infinite, but the program crashes.
//Now swap the parameters
printFirst(34, infinite())
```

The second code works, because the expression in ONLY evaluated when it is used. Otherwise, it won't matter.

## Default and named arguments
Let's start by creating a new application. Name: `DefaultArgs` which extends App.

Consider the following tail recursive factorial method:
```scala
  def trFact(x: Int, accumulator: BigInt): Int =
    if (x <= 1) accumulator
    else trFact(x - 1, x * accumulator)
```
The above function can be used to calculate factorials as below:
```scala
val fact10 = trFact(10, 1)
val fact20 = trFact(20, 1)
```

Here, accumulator parameter is always called with the value 1.

We can say that the accumulator spoils our method signature or we need to wrap this in a bigger function, as we have implemented earlier.

Scala allows us to assign default values to the parameters,

```scala
  def trFact(x: Int, accumulator: BigInt = 1): Int =
    if (x <= 1) accumulator
    else trFact(x - 1, x * accumulator)
```

So now, the factorial can be called as below:
```scala
val fact10 = trFact(10)
```

This does not mean we cannot pass any other value to the default parameter. The following code is also valid:
```scala
val fact20 = trFact(10, 2)
```

Default parameters has got some issues.

Let's consider that we're working on a photo editing app and a function is defined as below:

```scala
def savePicture(format: String, width: Int, height: Int) : Unit = println("saving picture")
```

If the above function is called with the format as "jpeg" most of the times as below:

```scala
savePicture("jpg", 800, 600) // not a real resolution
```
So we can update the method to use "jpg" as the default value for format.

Let's modify the method as below:
```scala
def savePicture(format: String =  "jpg", width: Int, height: Int) : Unit = println("saving picture")
```

And now we can remove the first parameter value when invoking the function.

```scala
savePicture(800, 600)
```

This will not work. The compiler complains that the first parameter is supposed to be `String` but we're passing an `Int`. It is confused as this time.

The leading parameters, even if they are default, they cannot be omitted.

Let's assign default values to all of the parameters:
```scala
def savePicture(format: String =  "jpg", width: Int = 1920, height: Int = 1080) : Unit = println("saving picture")
```

And invoking the above function as:
```scala
svaePicture(800) // i intend to assing this to the width
```

BUt the compiler is not happy with this because it doesn't know what 800 is.

To fix this we have two options,

One, we have to invoke the function with all of the leading parameters.

But the following works:

```scala
savePicture("bmp")
```

Or, we can invoke the function by naming the parameters:

```scala
savePicture(format="bmp", width=800, height=1000)
```

We can also pass the parameters in a different order as well.

## Operations on Strings
Strings are in every programming language.

Here, we'll discuss some String functons available in Scala.

Let's start by creating a new object called "StringOps" which extends "App".

Start by declaring a string:
```scala
var str: String = "Hello, I'm learning Scala"
```

Let's explore some standard string operations.

```scala
println(str.charAt(2)) // Strings are 0-indexed. This will output "l".
println(str.substring(7, 11)) //takes one or two indices. This will return "I am".
println(str.split(" ").toList) // splits a string into multiple strings, based on the de-limiter. This will print an array. So use "toList"
println(str.startsWith("Hello")) // returns true or false, based on whether the string starts with the given string
println(str.replace(' ', '-')) // this replaces the character space with dashes.
print(str.toLowerCase()) // turns the string to lower case
println(str.toUpperCase()) // turns the string to upper case
println(str.length) // returns length of the string, this can be called with or without the parentheses

```
These functions are part of Java. Scala adds its own methods:
```scala
val aNumberString = "45"
val aNumber = aNumberString.toInt // converts the string to a number (Int)
```

Next methods are for prepending and appending:

```scala
val aNumberString = "45"
printkn('a' +: aNumberString :+ 'z') // prepending operator is +: and appending is :+
```

There is also a reverse method
```scala
println(str.reverse)
```

Also, we have list like functions:

```scala
println(str.take(2)) // returns "He"
```

Let's discuss Scala-specific : String interpolators:
s-interpolated string.
```scala
val name = "David"
val age = 12
val greeting = s"Hello, my name is $name and I'm $age years old" // s indicates s-interpolated string. If s is missing, the string is taken literally.
val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old" // inside the curly brackets, we can add an expression

```

We also have other interpolated strings available:
f-interpolated. They act as s-interpolated string i.e expand the variables inside the string but in addition, they can be used similart to printf statements.
Consider the following code:

```scala
val speed = 1.2f
val myth = f"$name%s can eat $speed%2.2f burgers per minute" // 2.2f indicates that we have 2 characters minimum and 2 decimal precision
```

Although, we defined the speed as `1.2` the f-interpolated string adds the additional 0 to comply with precision.

The f-interpolated string also checks for type correctness
```scala
val x = 1.1f
val str = f"$x%3d" // the %3d requires an Int type. This will result in a compilation failure.
```

Final interpolater that we'll discuss is the raw interpolator.

This works similar to s-interpolator but this will print characters literally.

```scala
println(raw"This is a \n newline") // the escape sequence \n is printed literally and is not escaped
```

Consider the following code:
```scala
val escaped = "This is a \n newline"
println(raw"$escaped")
```

Raw interpolated strings escape the characters in an injected string.



