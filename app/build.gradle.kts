plugins {
    id("java")
    id("application")
}

group = "now.in.jvm"
version = "0.0.1"

application {
    mainClass.set("now.in.jvm.Main")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "./lib", "include" to arrayOf("*.jar"))))
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")

    testImplementation("junit:junit:4.13.1")
}
