package Lectures.part2oop

object OOBasics extends App {
  val person = new person (name = "John", age = 21 )
  println(person.age)
  println(person.x)

}
class person(name: String,val age: Int){
  val x= 2
  println(1+2)

  def greet(name: String): Unit = println(s"${this.name} says:hi$name")
  def greet() : Unit = println(s"Hi,I am $name")

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
class Fullname(firstName: String,lastName: String){

  def greet(firstName: String): Unit = println(s"${this.firstName} says:hi$firstName")
  def greet(lastName: String): Unit = println(s"${this.lastName} says:hi$lastName")
  def greet() : Unit = println(s"Hi,I am $firstName+$lastName")

  def this() = this("John Doe")
}
