package com.codeclan.example.courseBooker.components;

import com.codeclan.example.courseBooker.models.Booking;
import com.codeclan.example.courseBooker.models.Course;
import com.codeclan.example.courseBooker.models.Customer;
import com.codeclan.example.courseBooker.repositories.BookingRepository;
import com.codeclan.example.courseBooker.repositories.CourseRepository;
import com.codeclan.example.courseBooker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){
//    default constuctor
    }


    public void run(ApplicationArguments args)  {
        Course course = new Course("Street dance for self defence", "Springfeild", 4);
        courseRepository.save(course);

        Customer customer = new Customer("ElDave", "Math mexcio City", 12 );
        customerRepository.save(customer);

        Booking booking = new Booking("01-08-2019", course, customer);
        bookingRepository.save(booking);


    }


}
