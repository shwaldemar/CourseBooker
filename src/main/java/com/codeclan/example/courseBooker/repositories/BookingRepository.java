package com.codeclan.example.courseBooker.repositories;

import com.codeclan.example.courseBooker.models.Booking;
import com.codeclan.example.courseBooker.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    List<Booking> findBookingByDate(String date);

}
