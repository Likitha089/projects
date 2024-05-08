package com.ms.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.student.Repository.StudentRepo;
import com.ms.student.entity.RequestEntity;
import com.ms.student.entity.ResponseEntity;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;
    public ResponseEntity getGrade(RequestEntity request) {
		ResponseEntity res= repo.getStudentGrade(request);
        String englishGrade = calculateGrade(request.getEnglish());
        String scienceGrade = calculateGrade(request.getScience());
        String mathsGrade = calculateGrade(request.getMaths());

        // Set grades in the response object
        res.setEnglishGrade(englishGrade);
        res.setScienceGrade(scienceGrade);
        res.setMathsGrade(mathsGrade);

        // Return the response object with grades
        return res;
		}
        private String calculateGrade(int marks) {
            // Define grading criteria based on marks
            if (marks >= 90) {
                return "A+";
            } else if (marks >= 80) {
                return "A";
            } else if (marks >= 70) {
                return "B";
            } else if (marks >= 60) {
                return "C";
            } else if (marks >= 50) {
                return "D";
            } else {
                return "F";
            }
        }

}
