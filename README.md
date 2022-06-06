### Embedded Kafka Plugin
This plugin creates a Kotlin source set with name `integrationTest` and two tasks
`integrationTest` and `cleanIntegrationTestEnvironment`.

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
    id("com.github.ashishkujoy.greeting") version "0.0.1"
    application
}
```

