package com.ignacionizetich.eventvantage;

import org.springframework.boot.SpringApplication;

public class TestEventVantageApplication {

    public static void main(String[] args) {
        SpringApplication.from(EventVantageApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
