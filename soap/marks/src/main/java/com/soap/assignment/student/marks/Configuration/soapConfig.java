package com.soap.assignment.student.marks.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.soap.assignment.student.marks.client.soapClient;

@Configuration
public class soapConfig {
    
    @Autowired
	soapProperties properties;
	
    @Bean
    public soapClient client(soapProperties properties) throws Exception {
        soapClient client = new soapClient(properties);
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
