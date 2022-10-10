package org.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer1 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Consumer1.class.getName());
        String topic = "topica";

        Properties properties = new Properties();
        init(properties);

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topic));

        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> consumerRecord: consumerRecords) {
                logger.info("key: |{}| value: |{}| offset: |{}| partition: |{}|",
                        consumerRecord.key(), consumerRecord.value(), consumerRecord.offset(), consumerRecord.partition());
            }
            kafkaConsumer.commitAsync();
        }

    }

    public static void init(Properties props) {
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "myGroup");
        props.put("enable.auto.commit", false);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }
}
