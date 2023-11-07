plugins {
    id("java")
    id("application")
}

group = "com.code.sjy"
version = "0.0.1"

application {
    mainClass.set("com.code.sjy.adventofcode.Main")
}

dependencies {
    testImplementation("junit:junit:4.13.1")
}
