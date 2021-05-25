package com.stevens.springboot.eureka.client.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Profile("caller")
public class SampleServiceCaller implements CommandLineRunner {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${sample.eureka.client.instance}")
    String sampleEurekaClientInstance;

    @Autowired
    RestTemplate restTemplate;

    public void run(String... args) throws Exception {
        System.out.println("Calling the sample eureka Client");

//        List<ServiceInstance> instances = discoveryClient.getInstances(sampleEurekaClientInstance);
//        String URL = instances.get(0).getUri() + "/returnGetResponse";
        String URL = "http://" + sampleEurekaClientInstance + "/returnGetResponse";

        int totalCountCalled = 1;
        while (totalCountCalled < 11) {
            URL = URL + "/" + totalCountCalled;
            System.out.println("Calling the URL : " + URL);
            String response = restTemplate.getForObject(URL, String.class);
            System.out.println("Response received : " + response);
            totalCountCalled++;
            Thread.sleep(800);
        }

    }
}
