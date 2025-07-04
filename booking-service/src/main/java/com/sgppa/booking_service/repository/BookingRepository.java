package com.sgppa.booking_service.repository;

import com.sgppa.booking_service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCitizenName(String citizenName);
    List<Booking> findByServiceType(String serviceType);
}
