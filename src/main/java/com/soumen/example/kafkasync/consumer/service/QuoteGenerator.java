package com.soumen.example.kafkasync.consumer.service;

import com.soumen.example.kafkasync.model.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteGenerator {
    public Quote getRandomQuote() {
        return new Quote("M Gandhi", "An eye for an eye will make the whole world blind");
    }
}
