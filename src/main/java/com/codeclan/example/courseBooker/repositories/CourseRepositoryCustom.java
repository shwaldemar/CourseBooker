package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Customer;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Customer> findCustomersByCourseId(Long id);
}
