package com.relx.microservice.customer.stream;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.relx.microservice.customer.event.CustomerEvent;

import org.apache.kafka.common.serialization.StringDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	@Value(value = "${spring.kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${spring.kafka.consumerGroup}")
	private String consumerGroup;
	
	@Bean
	public ConsumerFactory<String, CustomerEvent> consumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
				new JsonDeserializer<>(CustomerEvent.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CustomerEvent> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, CustomerEvent> factory = new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
