package com.ms.student.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.ms.student.Client.SoapClient;

@Configuration
public class SoapConfig {

    @Autowired
	SoapProperties properties;
    @Bean
    public SoapClient client(SoapProperties properties) throws Exception {
        SoapClient client = new SoapClient(properties);
        System.out.println(properties.getPath());
        client.setDefaultUri(properties.getPath());
        client.setMarshaller(marshaller());//Json To xml
        client.setUnmarshaller(marshaller());
        return client;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.soap.assignment.entity");
        return marshaller;
    }
}
