plugins {
    `java-gradle-plugin`
    `kotlin-dsl-base`
    java
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("maven-publish")
}

group = "com.github.ashishkujoy.greeting"
version = "0.0.5"
java.sourceCompatibility = JavaVersion.VERSION_11


repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            url = uri("$buildDir/repo")
        }
    }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    implementation("io.github.embeddedkafka:embedded-kafka_2.13:3.2.0")
}

gradlePlugin {
    val greeting by plugins.creating {
        id = "com.github.ashishkujoy.greeting"
        implementationClass = "com.github.ashishkujoy.MyPlugin"
        version = version
    }
}
