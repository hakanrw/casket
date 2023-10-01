// Run from project root as scala-cli utils/GetDependencies.sc

import scala.sys.process._

val isTest = args.length > 0 && args(0) == "-test"

val result = 
    if isTest then
        """ sbt "show Test / dependencyClasspath" """.!!
    else
        """ sbt "show dependencyClasspath" """.!!


println(result.split("\n").filter(_.startsWith("[info] * Attributed")).map(_.replace("[info] * Attributed(", "")).map(_.replace(")", "")).mkString(":"))