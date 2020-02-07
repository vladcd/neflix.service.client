package com.vladcarcu.service.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladcarcu.service.client.entity.Student;
import com.vladcarcu.service.client.service.StudentService;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

}
