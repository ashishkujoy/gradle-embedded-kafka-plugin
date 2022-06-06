package com.github.ashishkujoy

import io.github.embeddedkafka.EmbeddedK
import io.github.embeddedkafka.EmbeddedKafka
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.get

open class StopKafkaTask : DefaultTask(){

    @TaskAction
    fun task() {
        val server = project.extensions["kafka"] as EmbeddedK
        EmbeddedKafka.stop(server)
    }
}