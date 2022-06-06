package com.github.ashishkujoy

import io.github.embeddedkafka.EmbeddedKafka
import io.github.embeddedkafka.EmbeddedKafkaConfig
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import scala.Predef

open class StartKafkaTask : DefaultTask() {

    @TaskAction
    fun task() {
        val extension = project.extensions.getByName("embeddedKafka") as KafkaPluginExtension
        println("Kafka will be started on ${extension.kafkaPort}")

        val server = EmbeddedKafka.start(
            EmbeddedKafkaConfig.apply(
            extension.kafkaPort,
            EmbeddedKafkaConfig.defaultZookeeperPort(),
            Predef.Map().empty(),
            Predef.Map().empty(),
            Predef.Map().empty()
        ))
        project.extensions.add("kafka", server)
        while (!EmbeddedKafka.isRunning()) {
            Thread.sleep(100)
        }
        println("kafka is started")
    }
}