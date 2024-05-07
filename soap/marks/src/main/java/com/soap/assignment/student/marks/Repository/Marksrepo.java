package com.soap.assignment.student.marks.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.soap.assignment.student.marks.entity.MarksEntity;
import com.soap.assignment.student.marks.entity.StudentEntity;
import com.soap.assignment.student.marks.client.soapClient;

@Component
@Repository
public class Marksrepo {

    @Autowired
    soapClient client;

    public MarksEntity getStudentMarks(StudentEntity demo) {
		return client.getStudentMarks(demo);
	}
}
