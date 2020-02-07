package com.vladcarcu.service.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.vladcarcu.service.client.client.StudentClient;
import com.vladcarcu.service.client.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Component
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentClient studentClient;

    @HystrixCollapser(batchMethod = "findByIds", collapserProperties = {
        @HystrixProperty(name = "timerDelayInMilliseconds", value = "5000")})
    @Cacheable("students")
    public Student findStudentById(Long id) {
        return null;
    }

    @HystrixCommand
    private List<Student> findByIds(List<Long> ids) {
        return new ArrayList<>(studentClient.findAllByIds(ids.stream().map(String::valueOf).collect(Collectors.joining(","))).getContent());
    }

    @Override
    @HystrixCommand(fallbackMethod = "findAllFallback")
    @Cacheable("students")
    public List<Student> findAll() {
        return new ArrayList<>(studentClient.findAll().getContent());
    }

    @Override
    @HystrixCommand(fallbackMethod = "findAllFallback")
    public Future<List<Student>> findAllAsync() {
        return new AsyncResult<List<Student>>() {
            @Override
            public List<Student> invoke() {
                return new ArrayList<>(studentClient.findAll().getContent());
            }
        };
    }

    private List<Student> findAllFallback() {
        LOGGER.error("Failed to connect to the student-service. Returning empty results.");
        return new ArrayList<>();
    }

}
