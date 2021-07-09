package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = this.favoriteMovie == movie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickName : String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def unary_! : String = s"$name, how are you"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply() : String = s"Hi, my name is $name, and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(thing: String): String = s"$name is learning $thing"
    def learnsScala = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // in-fix notation : single parameter
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)

  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2)) // ALL OPERATORS IN SCALA ARE METHODS

  val x = -1
  val y = 1.unary_- // unary_ works with - + ~ !

  // pre-fix notation
  println(!mary)
  println(mary.unary_!)

  // post-fix notation
  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply())
  println(mary())

  println(((mary + "the rockstar")).apply())

  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))
}

/*
  1. overload the "+" operator which receives a string and return the person's name with a nick
  name => mary + "the rockstar" => new Person
  2. add an age to the person class (default 0), and add the unary + operator
    return new person with age incremented by 1 => +mary => mary with age + 1
  3. add a method called learns => mary learns scala
      learnScala -> learns method with "Scala"
  4. add an apply method reo receive a number and return a string
    mary.apply(2) => Mary watched inception 2 times

 */
