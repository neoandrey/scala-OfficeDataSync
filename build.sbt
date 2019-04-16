import Dependencies._
val sparkVersion           = "2.2.0"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "officedatasync",
      scalaVersion := "2.11.8",
      mainClass in (Compile) := Some("OfficeDataSync")
    )),
    name := "OfficeDataSync",
    libraryDependencies += scalaTest % Test
  )
libraryDependencies ++= Seq(
  "org.apache.spark" %%  "spark-sql"  % sparkVersion,
  "org.apache.spark" %%  "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.mongodb" % "mongo-java-driver" % "3.5.0",
  "org.mongodb.spark" %% "mongo-spark-connector" % "2.2.0"
)

