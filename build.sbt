import AssemblyKeys._

assemblySettings

name := "ArnoldC"

version := "0.1"

scalaVersion := "2.11.4"

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

libraryDependencies += "asm" % "asm-commons" % "3.3.1"

libraryDependencies +