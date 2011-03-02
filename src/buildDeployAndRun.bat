javac main/*.java &&
jar cfm ../bin/TwoDates.jar Manifest.txt main/*.class &&
java -jar ../bin/TwoDates.jar
