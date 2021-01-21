package com.example.CourseBookingService.repositories;

import com.example.CourseBookingService.models.Course;
import com.example.CourseBookingService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // get all courses with a given rating
    List<Course> findByRating(int rating);

    //get all courses for a given customer
    List<Course> findAllByBookingsCustomerId(Long id);
}
