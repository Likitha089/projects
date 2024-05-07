package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MarksRepo;
import com.example.demo.entity.MarksEntity;
import com.example.demo.entity.StudentEntity;

@Service
public class MarksService {

    @Autowired
    MarksRepo marksrepo;

    public int getMarks(StudentEntity service) {
		MarksEntity res= marksrepo.getStudentMarks(service);
		int englishValue = res.getEnglish();
		int scienceValue = res.getScience();
		int mathsValue = res.getMaths();
		int total= englishValue+scienceValue+mathsValue;
		return total;

		}
}
