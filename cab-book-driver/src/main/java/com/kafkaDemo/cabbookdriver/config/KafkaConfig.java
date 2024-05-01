package com.kafkaDemo.cabbookdriver.config;

import com.kafkaDemo.cabbookdriver.contant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

//    This topic will be created  automatically by spring boot and once created, you can check it by this command:
//    bin/kafka-topics.sh --describe --topic topic_name --bootstrap-server localhost:9092
//    bin/kafka-topics.sh --describe --topic cab_location --bootstrap-server localhost:9092
    @Bean
    public NewTopic topic(){

        return TopicBuilder
                .name(AppConstant.CAB_LOCATION)
                .build();
    }
}
