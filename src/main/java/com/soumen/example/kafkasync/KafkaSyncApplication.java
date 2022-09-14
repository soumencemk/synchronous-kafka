package com.soumen.example.kafkasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSyncApplication.class, args);
	}

}
