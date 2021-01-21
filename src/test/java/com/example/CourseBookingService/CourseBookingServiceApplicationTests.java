package com.example.CourseBookingService;

import com.example.CourseBookingService.models.Booking;
import com.example.CourseBookingService.models.Course;
import com.example.CourseBookingService.models.Customer;
import com.example.CourseBookingService.repositories.BookingRepository;
import com.example.CourseBookingService.repositories.CourseRepository;
import com.example.CourseBookingService.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingServiceApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesByRating() {
		List<Course> foundCourses = courseRepository.findByRating(4);
		assertEquals(2, foundCourses.size());
		assertEquals("Learn Python", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomerForGivenCourse() {
		Course python = courseRepository.getOne(1L);
		List<Customer> foundCustomers = customerRepository.findByBookingsCourse(python);
		assertEquals(2, foundCustomers.size());
		assertEquals("Stuart", foundCustomers.get(0).getName());
	}

	@Test
	public void canFindCoursesForCustomer() {
		List<Course> foundCourses = courseRepository.findAllByBookingsCustomerId(2L);
		assertEquals(2, foundCourses.size());
		assertEquals("Learn Java", foundCourses.stream().sorted().collect(Collectors.toList()).get(0).getName());
		// Why has first saved course been moved to position 2 in list after second course saved??

		List<Course> stuartsCourses = courseRepository.findAllByBookingsCustomerId(1L);
		assertEquals(2, stuartsCourses.size());
		assertEquals("Learn Python", stuartsCourses.get(0).getName());

		List<Course> johnsCourses = courseRepository.findAllByBookingsCustomerId(4L);
		assertEquals(2, johnsCourses.size());
		assertEquals("Learn Java", johnsCourses.get(1).getName());
	}
}
