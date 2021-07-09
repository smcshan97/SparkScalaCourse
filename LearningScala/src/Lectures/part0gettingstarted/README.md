## Learning Scala
3 parts:
1. The basics
2. OOP in Scala
3. Functional programming
4. Pattern matching

### Development environmenet
1. Install IntelliJ for Java and Scala
2. Choose the community edition and the setup is straight forward.
3. On the welcome screen of IntelliJ select "Create new project"
4. Select Scala on the left and "idea" on the right. This will create an empty Scala project.
5. Choose the name, JDK and Scala-SDK. Java version 1.8 is good and the Scala SDK is allready instealled by the IDE
6. Click Finish

### Next steps:
Under the source folder create the following packages: (right click on source and select package)
1. exercises
2. lectures
3. playground

Test your setup:
1. Under the playground, create a new Java class caled JavaPlayground
2. Similarly, create a Scala class called ScalaPlayground

In the JavaPlayGround, write the following:
```java
public static void main(String[] args) {
    System.out.println("Hello Java");
}
```
 Right click and run this. You should see an output.

 In the ScalaPlayground, write the following
 Note: change class to object and extend App
 ```scala
object ScalaPlayGround extends App{
  println("Hello, Scala")
}
```
Right-click and run this. Output should say "Hello, Scala"
