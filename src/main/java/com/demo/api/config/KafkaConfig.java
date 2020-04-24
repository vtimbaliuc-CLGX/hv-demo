package com.demo.api.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties("testing.kafka")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KafkaConfig {

    @NotEmpty
    public String topic;
}
