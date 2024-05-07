package com.soap.assignment.student.marks.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.soap.assignment.student.marks.Configuration.soapProperties;
import com.soap.assignment.student.marks.entity.MarksEntity;
import com.soap.assignment.student.marks.entity.StudentEntity;

@Component
public class soapClient extends WebServiceGatewaySupport{
	
@Autowired
private soapProperties properties;

public soapClient(soapProperties properties) {
    this.properties=properties;
}

public MarksEntity getStudentMarks(StudentEntity request) {
    MarksEntity studentMarks = (MarksEntity) getWebServiceTemplate().marshalSendAndReceive(properties.getPath(),request);
    return studentMarks;
    
}
}
