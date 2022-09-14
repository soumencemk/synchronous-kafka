package com.soumen.example.kafkasync.service;

import com.soumen.example.kafkasync.model.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private static final String RANDOM_QUOTE = "RANDOM_Q";
    private final KafkaService kafkaService;

    public Quote getRandomQuote() {
        Object o = kafkaService.kafkaRequestReply(RANDOM_QUOTE);
        if (o instanceof Quote) {
            return (Quote) o;
        } else {
            return new Quote("Soumen", "No Quote returned !");
        }
    }
}
