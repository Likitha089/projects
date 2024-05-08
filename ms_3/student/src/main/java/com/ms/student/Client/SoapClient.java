package com.ms.student.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.ms.student.Configuration.SoapProperties;
import com.ms.student.entity.RequestEntity;
import com.ms.student.entity.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class SoapClient extends WebServiceGatewaySupport{
	
    @Autowired
    private SoapProperties properties;
    
    public SoapClient(SoapProperties properties) {
        this.properties = properties;
    }
    
    public ResponseEntity getStudentGrade(RequestEntity request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Send request and receive response
        ResponseEntity studentGrade = (ResponseEntity) getWebServiceTemplate().marshalSendAndReceive(properties.getPath(), request);
        return studentGrade;
    }
}