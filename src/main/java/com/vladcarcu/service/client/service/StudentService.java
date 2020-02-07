package com.vladcarcu.service.client.service;

import java.util.List;

import com.vladcarcu.service.client.entity.Student;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
public interface StudentService {

    List<Student> findAll();
}
