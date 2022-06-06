package com.github.ashishkujoy

import io.github.embeddedkafka.EmbeddedKafkaConfig

open class KafkaPluginExtension {
    var kafkaPort: Int = 9092
    var zookeeperPort: Int = EmbeddedKafkaConfig.defaultZookeeperPort()
}