package org.maz.producer;

import lombok.RequiredArgsConstructor;
import org.maz.schema.FlatEnumerationSample;
import org.maz.schema.FlatSampleData;
import org.maz.schema.SplitEnumerationSample;
import org.maz.schema.SplitSampleData;
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

    @PostMapping("/trigger-split")
    public ResponseEntity<String> triggerSendSplitMessage() {
        final SplitSampleData splitSampleData = SplitSampleData.newBuilder()
                .setSplitSampleData("This is a split data, schema reference")
                .setSplitEnumerationSample(SplitEnumerationSample.SAMPLE2)
                .build();
        kafkaMessageService.sendSplitSampleData(splitSampleData);

        return ResponseEntity.ok("Ok");
    }
}
