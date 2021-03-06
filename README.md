##Java 8 vs. Scala Workshop

This workshop contains exercises to get familiar with new features in Java 8, including default methods in interfaces, functional interfaces, lambdas, and streams.
The workshop contains similar exercises for Scala, where some of the problems can be solved using type classes and traits.

Slides for the workshop are located in the _slides_ folder of the project.

###Setup
1. Install Maven (http://maven.apache.org/download.cgi)
2. Install Java 8 JDK (http://www.oracle.com/technetwork/java/javase/downloads/)
3. Install git (http://git-scm.com/downloads)
4. Install Scala plugin for your IDE
5. Clone the project: `git clone git@github.com:matiasvinjevoll/java8-scala-workshop.git`
6. Execute `mvn compile` from the project root folder
8. Run `mvn test` to execute the tests (they should all fail)
7. Import the project to your IDE

###Setup with IntelliJ
1.  Install git (http://git-scm.com/downloads)
2.  Clone the project: `git clone git@github.com:matiasvinjevoll/java8-scala-workshop.git`
3.  Download and extract Java 8 JDK (http://www.oracle.com/technetwork/java/javase/downloads/)
4.  Install IntelliJ (http://www.jetbrains.com/idea/download/)
5.  Install Scala plugin
6.  Import the project (pom.xml) in IntelliJ
7.  Add the extracted Java 8 JDK folder as a JDK home path, either when importing the project, or from [right click on project root] -> Open Module Settings -> Platform Settings -> SDKs -> + (to add)
8.  Make sure Java 8 SDK is used for the project: [right click on project root] -> Open Module Settings -> Project Settings -> Project -> Project SDK
9.  Make project: Build -> Make Project
10. Run tests (they should all fail): [right click on project root] -> Run 'All Tests'