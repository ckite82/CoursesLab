package com.example.CourseBookingService.repositories;

import com.example.CourseBookingService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
