package com.codeclan.example.courseBooker.controllers;

import com.codeclan.example.courseBooker.models.Booking;
import com.codeclan.example.courseBooker.models.Course;
import com.codeclan.example.courseBooker.models.Customer;
import com.codeclan.example.courseBooker.repositories.BookingRepository;
import com.codeclan.example.courseBooker.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;


    @GetMapping(value= "/rating/{rating}")
    public List<Course> getCourseByRating(@PathVariable int rating){
        return courseRepository.findCoursesByRating(rating);
    }

    @GetMapping(value="/{id}/customers")
    public List<Customer> findCoursesByCustomerName(@PathVariable Long id){
        return courseRepository.findCustomersByCourseId(id);


    }





}
