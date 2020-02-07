package com.vladcarcu.service.client.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vladcarcu.service.client.entity.Student;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/api/students")
    PagedModel<Student> findAll();

    @RequestMapping("/api/students/search/byid")
    PagedModel<Student> findAllByIds(@RequestParam("ids") String ids);

}