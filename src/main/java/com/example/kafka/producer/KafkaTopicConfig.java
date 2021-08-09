package com.example.kafka.producer;

import java.util.Map;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value("${kafka.ssl.truststore.location}")
    private String trustStoreLocation;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        final Map<String, Object> config = Map.of(
            AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress,
            SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, trustStoreLocation,
            CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL"
        );
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("insights", 1, (short) 1);
    }
}
