plugins {
    `java-gradle-plugin`
    `kotlin-dsl-base`
    java
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("maven-publish") 
    id("com.gradle.plugin-publish") version "0.18.0" 
}

group = "io.github.ashishkujoy.embeddedKafka"
version = "0.0.1"
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
        id = "io.github.ashishkujoy.embeddedKafka"
        implementationClass = "com.github.ashishkujoy.EmbeddedkafkaPlugin"
        version = version
        description = "A plugin to start/stop embedded kafka"
        displayName = "Embedded Kafka"
    }
}



pluginBundle {
    website = "https://github.com/ashishkujoy/gradle-embedded-kafka-plugin"   
    vcsUrl = "https://github.com/ashishkujoy/gradle-embedded-kafka-plugin"   
    tags = listOf("kafka", "embedded kafka") 
}

