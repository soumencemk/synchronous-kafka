package com.soumen.example.kafkasync.consumer;

import com.soumen.example.kafkasync.consumer.service.QuoteGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private static final String RANDOM_QUOTE = "RANDOM_Q";
    private final QuoteGenerator quoteGenerator;

    @KafkaListener(groupId = "${app.consumer-group}", topics = "${app.send-topic}")
    @SendTo
    public Message<?> listen(ConsumerRecord<String, Object> consumerRecord) {
        Object value = consumerRecord.value();
        log.info("Message : {}", value);
        return MessageBuilder.withPayload(quoteGenerator.getRandomQuote()).build();
    }


}
