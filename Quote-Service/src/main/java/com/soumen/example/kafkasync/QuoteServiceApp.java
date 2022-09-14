package com.soumen.example.kafkasync;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class QuoteServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(QuoteServiceApp.class, args);
    }

}


@Component
@RequiredArgsConstructor
@Slf4j
class KafkaConsumer {

    @KafkaListener(groupId = "${app.consumer-group}", topics = "${app.send-topic}")
    @SendTo
    @SneakyThrows
    public Message<?> listen(ConsumerRecord<String, Object> consumerRecord) {
        var value = consumerRecord.value();
        log.info("Message : {}", value);
        return MessageBuilder.withPayload(getRandomQuote()).build();
    }

    private Object getRandomQuote() {
        return "M Gandhi,An eye for an eye will make the whole world blind";
    }
}
