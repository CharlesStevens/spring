package com.stevens.springboot.hystrix.service;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "eureka.client.healthcheck.enabled", matchIfMissing = false)
public class CustomHealthHandler implements HealthCheckHandler {

    @Autowired
    private CustomHealthIndicator customHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        System.out.println("Custom health indicutor invoked");
        Status status = customHealthIndicator.health().getStatus();
        if (status.equals(Status.UP)) {
            return InstanceInfo.InstanceStatus.UP;
        } else {
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
