### Embedded Kafka Plugin
This plugin provides two tasks `startEmbeddedKafka` and `stopEmbeddedKafka` for starting and stoping embedded kafka.

#### Using locally
For using plugin locally we first need to build and publish it locally

```bash
./gradlew clean build publish
```

This command will publish the plugin to your `./build/repo` directory.

Now in consumer project you need to add the following code snippet to your `settings.gradle.kts`

```kotlin
pluginManagement {
    repositories {
        maven {
            url = uri("$AbosolutePathToMyPluginDirectory/build/repo/")
        }
        gradlePluginPortal()
    }
}
```

and then in `build.gradle.kts` apply the plugin
```kotlin
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("io.github.ashishkujoy.embeddedKafka") version "0.0.1"
    application
}

embeddedKafka {
    kafkaPort = 9999 // default value 9092
    zookeeperPort = 9876 // default value 6000
}


tasks.withType<Test> {
    useJUnitPlatform()

    testLogging {
        events(PASSED, FAILED, SKIPPED)
    }
    
    dependsOn("startEmbeddedKafka")
    finalizedBy("stopEmbeddedKafka")
}
```

