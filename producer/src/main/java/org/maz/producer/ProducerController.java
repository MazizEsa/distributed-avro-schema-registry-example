package org.maz.producer;

import lombok.RequiredArgsConstructor;
import org.maz.schema.FlatEnumerationSample;
import org.maz.schema.FlatSampleData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller to trigger the message
 */
@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final KafkaMessageService kafkaMessageService;

    @PostMapping("/trigger-flat")
    public ResponseEntity<String> triggerSendFlatFile() {
        final FlatSampleData flatSampleData = FlatSampleData.newBuilder()
                .setFlatSampleData("This is an example")
                .setFlatEnumSample(FlatEnumerationSample.SAMPLE_1)
                .build();
        kafkaMessageService.sendFlatSampleData(flatSampleData);

        return ResponseEntity.ok("Ok");
    }
}
