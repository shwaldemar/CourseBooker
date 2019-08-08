package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Course;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Course> getCoursesFromCustomerId(Long id);
}
