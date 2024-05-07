package com.example.demo.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.Client.SoapClient;
import com.example.demo.entity.MarksEntity;
import com.example.demo.entity.StudentEntity;

@Component
@Repository
public class MarksRepo {

    @Autowired
    SoapClient client;

    public MarksEntity getStudentMarks(StudentEntity demo) {
		return client.getStudentMarks(demo);
	}
}