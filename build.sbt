name := "sbt-tutorial"
version := "0.1.0"
scalaVersion := "2.12.17"

libraryDependencies ++= Seq(
  "org.scala-js" %% "scalajs-test-interface" % "0.6.14",
  "org.scalatest" %% "scalatest" % "3.0.1", //version changed as these the only versions supported by 2.12
  "com.novocode" % "junit-interface" % "0.11",
  "org.scala-lang" % "scala-library" % scalaVersion.value
)
Compile / scalaSource := baseDirectory.value / "src/main"
Test / scalaSource := baseDirectory.value / "src/test"

val gitCommitCountTask = taskKey[String]("Prints commit count of the current branch")
gitCommitCountTask := {
  val branch = scala.sys.process.Process("git symbolic-ref -q HEAD").lines.head.replace("refs/heads/","")
  val commitCount = scala.sys.process.Process(s"git rev-list --count $branch").lines.head
  println(s"total number of commits on [$branch]: $commitCount")
  commitCount
}
val sampleStringTask = taskKey[String]("A sample string task.")
val sampleIntTask = taskKey[Int]("A sample int task.")
sampleIntTask := {
  val sum = 1 + 2        // first
  println("sum: " + sum) // second
  sum                    // third
}
sampleStringTask := {
  // startServer.value
  val s = "sampleIntTask.value.toString"
  // val s = sampleIntTask.value.toString
  println("s: " + s)
  s
}
val sampleTask = taskKey[String]("sample")
sampleTask := {
  val q = "sample"
  println(q)
  q
}