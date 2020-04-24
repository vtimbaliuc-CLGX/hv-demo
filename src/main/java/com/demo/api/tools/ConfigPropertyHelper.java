package com.demo.api.tools;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigPropertyHelper implements EnvironmentAware {
    private static Environment environment;

    public static String getProperty(String name){
        return ConfigPropertyHelper.environment.getProperty(name);
    }

    @Override
    public void setEnvironment(final Environment environment) {
        ConfigPropertyHelper.environment = environment;
    }
}
