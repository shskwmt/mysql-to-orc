name := "Spark SQL From File examples"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "org.apache.spark" %% "spark-sql" % "2.1.0",
  "org.apache.spark" % "spark-hive_2.11" % "2.1.0",
  "mysql" % "mysql-connector-java" % "6.0.5"
)
