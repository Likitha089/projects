package com.example.demo.Client;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.demo.Configuration.SoapProperties;
import com.example.demo.entity.MarksEntity;
import com.example.demo.entity.StudentEntity;

@Component
public class SoapClient extends WebServiceGatewaySupport{
	
@Autowired
private SoapProperties properties;

public SoapClient(SoapProperties properties) {
    this.properties=properties;
}

public MarksEntity getStudentMarks(StudentEntity request) {
    MarksEntity studentMarks = (MarksEntity) getWebServiceTemplate().marshalSendAndReceive(properties.getPath(),request);
    return studentMarks;
    
}
}