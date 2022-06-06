package com.github.ashishkujoy

import io.github.embeddedkafka.EmbeddedK
import io.github.embeddedkafka.EmbeddedKafka
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.get
import kotlin.system.*

open class StopKafkaTask : DefaultTask(){

    @TaskAction
    fun task() {
        val server = project.extensions["kafka"] as EmbeddedK
        println("Stoping Kafka.....")
        val timeElapsed = measureTimeMillis {
            EmbeddedKafka.stop(server)
        }
        println("Kafka stopped in $timeElapsed milliseconds ...")
    }
}