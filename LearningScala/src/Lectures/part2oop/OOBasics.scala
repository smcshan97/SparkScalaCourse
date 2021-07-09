package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 21)
  println(person.age)
  println(person.x)
  person.greet("Stevan")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)

  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print

  counter.inc(10).print

}

class Person(name: String, val age: Int = 0) {
  val x = 2
  println(1 + 2)

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")
  def greet() : Unit = println(s"Hi, I am $name")

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

  /*
    Exercises:
    1. Method fullname -> return full name of person i.e. first name + sur name
    2. Novel: name, year of release, author (instance of Write)
      - authorAge - returns the age of the author (year - author.year)
      - isWrittenBy(author) - true or false
      - copy(with a new year of release) - returns a new instance of Novel with the new year of release
      Writer: firstname, surname, year
      - Method fullname -> return full name of person i.e. first name + sur name
    3. Create a new class Counter
      - receives an Int value
      - has a method to return the current value
      - method to incremen/decrement the counter by 1 => return a new Counter
      - overload inc/dec to take a parameter (int) - inc/dec by that parameter => return a new Counter
   */
}

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName: String = firstName + " " + surName
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer)  = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  }

  def dec: Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0 ) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)

}
