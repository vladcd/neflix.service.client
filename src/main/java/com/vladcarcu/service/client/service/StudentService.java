package com.vladcarcu.service.client.service;

import java.util.List;
import java.util.concurrent.Future;

import com.vladcarcu.service.client.entity.Student;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
public interface StudentService {

    Student findStudentById(Long id);

    List<Student> findAll();

    Future<List<Student>> findAllAsync();
}
