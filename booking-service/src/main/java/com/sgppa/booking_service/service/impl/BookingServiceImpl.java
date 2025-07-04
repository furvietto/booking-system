package com.sgppa.booking_service.service.impl;

import com.sgppa.booking_service.dto.BookingDTO;
import com.sgppa.booking_service.entity.Booking;
import com.sgppa.booking_service.mapper.BookingMapper;
import com.sgppa.booking_service.repository.BookingRepository;
import com.sgppa.booking_service.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<BookingDTO> findAll() {
        return bookingRepository.findAll().stream()
                .map(BookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookingDTO> findById(Long id) {
        return bookingRepository.findById(id)
                .map(BookingMapper::toDto);
    }

    @Override
    public BookingDTO create(BookingDTO bookingDTO) {
        Booking booking = BookingMapper.toEntity(bookingDTO);
        Booking saved = bookingRepository.save(booking);
        return BookingMapper.toDto(saved);
    }

    @Override
    public Optional<BookingDTO> update(Long id, BookingDTO bookingDTO) {
        return bookingRepository.findById(id)
                .map(existing -> {
                    existing.setCitizenName(bookingDTO.getCitizenName());
                    existing.setServiceType(bookingDTO.getServiceType());
                    existing.setAppointmentDate(bookingDTO.getAppointmentDate());
                    existing.setOfficeLocation(bookingDTO.getOfficeLocation());
                    existing.setStatus(bookingDTO.getStatus());
                    return BookingMapper.toDto(bookingRepository.save(existing));
                });
    }

    @Override
    public boolean delete(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}