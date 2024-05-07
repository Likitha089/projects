package com.soap.assignment.student.marks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.assignment.student.marks.entity.MarksEntity;
import com.soap.assignment.student.marks.entity.StudentEntity;
import com.soap.assignment.student.marks.Repository.Marksrepo;

@Service
public class MarksService {

    @Autowired
    Marksrepo marksrepo;

    public int getMarks(StudentEntity service) {
		MarksEntity res= marksrepo.getStudentMarks(service);
		int englishValue = res.getEnglish();
		int scienceValue = res.getScience();
		int mathsValue = res.getMaths();
		int total= englishValue + scienceValue + mathsValue;
		return total;
		}
}
