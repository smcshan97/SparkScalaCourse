package lectures.part2oop

object Objects extends App {
  object Person {
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

    val N_EYES = 2

    def canFly: Boolean = false

  }

  class Person(val name: String) {
    // def from(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  // companions

  println(Person.N_EYES)

//  val mary = Person
//  val john = Person
//
//  println(mary == john)

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bobbie = Person(mary, john)

//  def main(args: Array[String]): Unit = {
//
//  }
}
