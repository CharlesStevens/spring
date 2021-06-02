package com.stevens.springboot.configuration.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    @Value("${datasource.host}")
    private String datasourceHost;

    @Value("${datasource.port}")
    private String datasourcePort;

    @Value("${datasource.user}")
    private String datasourceUser;

    @Value("${datasource.pass}")
    private String datasourcePass;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running SpringConfigServer-Client");
        System.out.println("Datasource Host : " + datasourceHost);
        System.out.println("Datasource Port : " + datasourcePort);
        System.out.println("Datasource User : " + datasourceUser);
        System.out.println("Datasource Pass : " + datasourcePass);
        System.out.println("Done");

    }
}
