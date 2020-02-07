package com.vladcarcu.service.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladcarcu.service.client.entity.Student;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@FeignClient("student-service")
public interface StudentClient {

    @RequestMapping("/api/students")
    PagedModel<Student> findAll();
}
