name := "java8-scala-workshop"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq (
  "org.scala-lang" % "scala-library" % "2.11.0",
	"org.scalatest" % "scalatest_2.11" % "2.1.5" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test->default"
)
