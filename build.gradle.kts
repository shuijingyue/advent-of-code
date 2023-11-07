buildscript {
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.10")
    }
}

group = "now.in.jvm"
version = "0.0.1"

allprojects {
    repositories {
        maven { url = uri("https://maven.aliyun.com/repository/public/") }
        mavenCentral()
    }
}
