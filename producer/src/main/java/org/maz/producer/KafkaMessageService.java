package org.maz.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.maz.schema.FlatSampleData;
import org.maz.schema.SplittedSampleData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageService {
    public static final String SPLITTED_SCHEMA_TOPIC = "splitted-schema-topic";
    public static final String FLAT_SCHEMA_TOPIC = "flat-schema-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendFlatSampleData(final FlatSampleData flatSampleData) {
        kafkaTemplate.send(FLAT_SCHEMA_TOPIC, flatSampleData).addCallback(
                successful -> log.debug("Sent successful"),
                error -> log.error("Erroneous"));
    }

    public void sendSplittedSampleData(final SplittedSampleData splittedSampleData) {
        kafkaTemplate.send(SPLITTED_SCHEMA_TOPIC, splittedSampleData).addCallback(
                successful -> log.debug("Sent successful"),
                        error -> log.error("Erroneous"));
    }
}
