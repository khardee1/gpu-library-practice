mainClass in (Compile, packageBin) := Some("gpu-library-practice.helloworld")

mainClass in (Compile, run) := Some("gpu-library-practice.helloworld")

libraryDependencies += "com.thoughtworks.compute" %% "cpu" % "latest.release"
libraryDependencies += "com.thoughtworks.compute" %% "gpu" % "latest.release"

// Platform dependent runtime of LWJGL core library
libraryDependencies += ("org.lwjgl" % "lwjgl" % "latest.release").jar().classifier {
  import scala.util.Properties._
  if (isMac) {
    "natives-macos"
  } else if (isLinux) {
    "natives-linux"
  } else if (isWin) {
    "natives-windows"
  } else {
    throw new MessageOnlyException(s"lwjgl does not support $osName")
  }
}
