package org.maz.producer;

import lombok.RequiredArgsConstructor;
import org.maz.schema.FlatEnumerationSample;
import org.maz.schema.FlatSampleData;
import org.maz.schema.SplittedEnumerationSample;
import org.maz.schema.SplittedSampleData;
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
    public ResponseEntity<String> triggerSendFlatMessage() {
        final FlatSampleData flatSampleData = FlatSampleData.newBuilder()
                .setFlatSampleData("This is an example")
                .setFlatEnumSample(FlatEnumerationSample.SAMPLE1)
                .build();
        kafkaMessageService.sendFlatSampleData(flatSampleData);

        return ResponseEntity.ok("Ok");
    }

    @PostMapping("/trigger-splitted")
    public ResponseEntity<String> triggerSendSplittedMessage() {
        final SplittedSampleData splittedSampleData = SplittedSampleData.newBuilder()
                .setSplittedSampleData("This is a splitted data, schema reference")
                .setSplittedEnumerationSample(SplittedEnumerationSample.SAMPLE2)
                .build();
        kafkaMessageService.sendSplittedSampleData(splittedSampleData);

        return ResponseEntity.ok("Ok");
    }
}
