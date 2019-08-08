package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Course;
import com.codeclan.example.courseBooker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
    List<Course> getCoursesFromCustomerId(Long id);
}
