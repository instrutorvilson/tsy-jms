package com.consumer.ConsumerQ;

import com.consumer.ConsumerQ.entitdades.Ticket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJms
public class ConsumerQApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerQApplication.class, args);
	}
	@Bean
	public JmsListenerContainerFactory<?> defaultFactory(
			ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {

		DefaultJmsListenerContainerFactory factory =
				new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter =
				new MappingJackson2MessageConverter();

		Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
		typeIdMappings.put("_type", Ticket.class);
		converter.setTypeIdMappings(typeIdMappings);

		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

}
