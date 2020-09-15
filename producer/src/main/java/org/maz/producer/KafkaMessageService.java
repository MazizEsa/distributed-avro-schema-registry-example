package org.maz.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.maz.schema.FlatSampleData;
import org.maz.schema.SplitSampleData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageService {
    public static final String SPLIT_SCHEMA_TOPIC = "split-schema-topic";
    public static final String FLAT_SCHEMA_TOPIC = "flat-schema-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendFlatSampleData(final FlatSampleData flatSampleData) {
        kafkaTemplate.send(FLAT_SCHEMA_TOPIC, flatSampleData).addCallback(
                successful -> log.debug("Sent successful"),
                error -> log.error("Erroneous"));
    }

    public void sendSplitSampleData(final SplitSampleData splitSampleData) {
        kafkaTemplate.send(SPLIT_SCHEMA_TOPIC, splitSampleData).addCallback(
                successful -> log.debug("Sent successful"),
                        error -> log.error("Erroneous"));
    }
}
