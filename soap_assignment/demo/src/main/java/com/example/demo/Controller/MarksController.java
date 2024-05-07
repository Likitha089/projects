package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MarksService;
import com.example.demo.entity.StudentEntity;

@RestController
@RequestMapping("/getStudentMarks")
public class MarksController {
    @Autowired
	private MarksService marksService;
	
	@PostMapping("/total-marks")
	public int getMarks(@RequestBody StudentEntity request) {
				
		int resp = marksService.getMarks(request);
		return resp;

	}
}



