package com.stevens.springboot.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("caller")
public class CallerServiceImpl implements CallerService {

    @Value("${sample.eureka.client.instance}")
    String sampleEurekaClientInstance;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callerFallbackMethod",commandKey = "",
            commandProperties =
                    {@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "90"),
//                            @HystrixProperty(name = "execution.timeout.enabled", value = "false"),
                            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "100"),
                            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "15")})
    public ResponseEntity<String> makeCallToServer() {
        System.out.println("Calling the sample eureka Client");
        String URL = "http://" + sampleEurekaClientInstance + "/returnGetResponse";
        System.out.println("Calling the URL : " + URL);
        return restTemplate.getForEntity(URL, String.class);
//        String response = responseEntity.getBody();
//
//        System.out.println("Status Code : " + responseEntity.getStatusCode() + "Response received : " + response);
//        return responseEntity.getStatusCode() == HttpStatus.OK ? response : "Failure returned from the caller";
    }

    public ResponseEntity<String> callerFallbackMethod() {
//        t.printStackTrace();
        System.out.println("############## Fallback executed #############");
        return new ResponseEntity<String>("Response from fallback", HttpStatus.OK);
    }
}
