package com.example.CourseBookingService.repositories;

import com.example.CourseBookingService.models.Course;
import com.example.CourseBookingService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourse(Course course);
}
