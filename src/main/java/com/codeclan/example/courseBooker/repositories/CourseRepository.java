package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Booking;
import com.codeclan.example.courseBooker.models.Course;
import com.codeclan.example.courseBooker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository  extends JpaRepository<Course, Long>,CourseRepositoryCustom{


    List<Course> findCoursesByRating(int rating);
    List<Customer> findCustomersByCourseId(Long id);


}
