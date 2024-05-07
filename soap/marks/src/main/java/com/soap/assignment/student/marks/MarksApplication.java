package com.soap.assignment.student.marks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.soap.assignment.student.marks.Configuration.soapProperties;
@SpringBootApplication
public class MarksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarksApplication.class, args);
	}
	@Bean
    public soapProperties soapProperties() {
        // Define and configure your SoapProperties bean here
        return new soapProperties();
    }

}
