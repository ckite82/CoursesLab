package com.example.CourseBookingService.components;

import com.example.CourseBookingService.models.Booking;
import com.example.CourseBookingService.models.Course;
import com.example.CourseBookingService.models.Customer;
import com.example.CourseBookingService.repositories.BookingRepository;
import com.example.CourseBookingService.repositories.CourseRepository;
import com.example.CourseBookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public void run(ApplicationArguments args){

        Course python = new Course("Learn Python", "Livingston", 4);
        courseRepository.save(python);

        Course java = new Course("Learn Java", "Aberdeen", 5);
        courseRepository.save(java);

        Course javaScript = new Course("Learn JavaScript", "Glasgow", 3);
        courseRepository.save(javaScript);

        Course react = new Course("Learn React", "Edinburgh", 4);
        courseRepository.save(react);

        Customer stuart = new Customer("Stuart", "Livingston", 25);
        customerRepository.save(stuart);

        Customer chris = new Customer("Chris", "Aberdeen", 21);
        customerRepository.save(chris);

        Customer scottBrown = new Customer("Scott Brown", "Glasgow", 45);
        customerRepository.save(scottBrown);

        Customer john = new Customer("John Harper", "Edinburgh", 36);
        customerRepository.save(john);

        Customer mark = new Customer("Mark", "Livingston", 28);
        customerRepository.save(mark);

        Customer max = new Customer("Max", "Aberdeen", 30);
        customerRepository.save(max);

        Customer michael = new Customer("Michael", "Glasgow", 35);
        customerRepository.save(michael);

        Customer roosa = new Customer("Roosa", "Edinburgh", 25);
        customerRepository.save(roosa);

        Booking booking1 = new Booking("March", python, stuart);
        bookingRepository.save(booking1);
        Booking booking5 = new Booking("March", python, chris);
        bookingRepository.save(booking5);

        Booking booking11 = new Booking("April", java, john);
        bookingRepository.save(booking11);
        Booking booking2 = new Booking("April", java, chris);
        bookingRepository.save(booking2);
        Booking booking6 = new Booking("April", java, mark);
        bookingRepository.save(booking6);

        Booking booking3 = new Booking("May", javaScript, scottBrown);
        bookingRepository.save(booking3);
        Booking booking7 = new Booking("May", javaScript, max);
        bookingRepository.save(booking7);

        Booking booking4 = new Booking("June", react, john);
        bookingRepository.save(booking4);




        Booking booking8 = new Booking("June", react, michael);
        bookingRepository.save(booking8);

        Booking booking9 = new Booking("June", react, stuart);
        bookingRepository.save(booking9);

        Booking booking10 = new Booking("April", react, roosa);
        bookingRepository.save(booking10);

    }
}
