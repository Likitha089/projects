package com.ms.student.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ms.student.Client.SoapClient;
import com.ms.student.entity.RequestEntity;
import com.ms.student.entity.ResponseEntity;

@Repository
public class StudentRepo {
 @Autowired
    SoapClient client;
    public ResponseEntity getStudentGrade(RequestEntity demo) {
		return client.getStudentGrade(demo);
	}
}
