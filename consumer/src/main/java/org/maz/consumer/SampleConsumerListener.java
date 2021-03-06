package org.maz.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.maz.schema.FlatSampleData;
import org.maz.schema.SplitSampleData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleConsumerListener {
    @KafkaListener(topics = {"flat-schema-topic"}, groupId = "flat")
    public void receiveFlatSampleMessage(final ConsumerRecord<String, FlatSampleData> consumerRecord) {
        log.info("Flat Data Received. The data is: {}", consumerRecord.value().getFlatEnumSample());
    }

    @KafkaListener(topics = {"split-schema-topic"}, groupId = "split")
    public void receiveSplitMessage(final SplitSampleData splitSampleData) {
        log.info("Split Data Received. The data is: {}", splitSampleData);
    }
}
