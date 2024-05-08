package com.ms.student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.student.Service.StudentService;
import com.ms.student.entity.RequestEntity;
import com.ms.student.entity.ResponseEntity;

@RestController
@RequestMapping("/SampleWebService")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/getStudentGrade")
    public ResponseEntity getGrade(@RequestBody RequestEntity request) {
        ResponseEntity resp = service.getGrade(request);
        return resp;
    }
    
}
