package com.vladcarcu.service.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vladcarcu.service.client.client.StudentClient;
import com.vladcarcu.service.client.entity.Student;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentClient.findAll().getContent());
    }
}
