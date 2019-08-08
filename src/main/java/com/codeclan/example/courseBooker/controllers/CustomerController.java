package com.codeclan.example.courseBooker.controllers;

import com.codeclan.example.courseBooker.models.Course;
import com.codeclan.example.courseBooker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/customers")

public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/{id}/courses")

    public List<Course> getCourseByCustomer(@PathVariable Long id){
        return customerRepository.getCoursesFromCustomerId(id);
    }

}
