package com.stevens.springboot.eureka.service;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("custom")
@Profile("callee")
public class CustomHealthIndicator implements HealthIndicator {
    int i = 2;

//    public Health getHealth(boolean includeDetails) {
//        System.out.println("Get health includeDetails called ");
//        return null;
//    }


//    protected void doHealthCheck(Health.Builder builder) throws Exception {
//        if (health) {
//            System.out.println("Health Function called passng UP");
//            health = false;
//            builder.up();
//        } else {
//            System.out.println("Health Function called passng Down");
//            health = true;
//            builder.down();
//        }
//    }

    @Override
    public Health health() {
        i++;
        if (i % 3 == 0 || (i + 1) % 3 == 0) {
            System.out.println("Health Function called passng UP");
            return Health.up().build();
        } else {
            System.out.println("Health Function called passng Down");
            return Health.down().build();
        }

    }
}
