package com.github.ashishkujoy

import io.github.embeddedkafka.EmbeddedK
import io.github.embeddedkafka.EmbeddedKafka
import io.github.embeddedkafka.EmbeddedKafkaConfig
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.withConvention
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import scala.Predef

class MyPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<KafkaPluginExtension>("embeddedKafka")

        project.tasks.register("startEmbeddedKafka", StartKafkaTask::class.java) {
            group = "embeddedKafkaTasks"
        }

        project.tasks.register("stopEmbeddedKafka", StopKafkaTask::class.java) {
            group = "embeddedKafkaTasks"
        }

//        project.task("stopEmbeddedKafka") {
//            doFirst {
//                val server = project.extensions["kafka"] as EmbeddedK
//                EmbeddedKafka.stop(server)
//            }
//        }

//        val integrationTestTask = project
//            .getTasksByName("integrationTest", true)
//            .first()
//
//        integrationTestTask?.dependsOn("startEmbeddedKafka")
//        integrationTestTask?.finalizedBy("stopEmbeddedKafka")
    }



}

fun org.gradle.api.Project.`embeddedKafka`(configure: Action<KafkaPluginExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("embeddedKafka", configure)
