package org.example;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Producer1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger logger= LoggerFactory.getLogger(Producer1.class);

        Properties properties = new Properties();
        init(properties);

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        sendMessage(kafkaProducer);

        kafkaProducer.close();
        logger.info("exiting: {}", Thread.currentThread().getName());

    }

    public static void init(Properties props) {
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    public static void sendMessage(KafkaProducer<String, String> kafkaProducer) throws ExecutionException, InterruptedException {
        Logger logger= LoggerFactory.getLogger(Producer1.class);

        for (int i = 0; i < 10; i++) {
            String topic = "topica";
            String value = "value: " + i;
            String key = "id_" + i;

            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
            logger.info("key {} thread {}", key, Thread.currentThread().getName());

            Future<RecordMetadata> recordMetadataFeature = kafkaProducer.send(producerRecord);

            RecordMetadata recordMetadata = recordMetadataFeature.get();
            logger.info("Record metadata for the message {}: assigned topic: {}, partition: {}, offset: {}, time: {}"
                    ,value, recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), recordMetadata.timestamp());
        }
    }

}