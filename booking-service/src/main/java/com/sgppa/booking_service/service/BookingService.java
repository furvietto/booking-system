package com.sgppa.booking_service.service;

import com.sgppa.booking_service.dto.BookingDTO;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<BookingDTO> findAll();
    Optional<BookingDTO> findById(Long id);
    BookingDTO create(BookingDTO bookingDTO);
    Optional<BookingDTO> update(Long id, BookingDTO bookingDTO);
    boolean delete(Long id);
}
