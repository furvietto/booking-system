package com.sgppa.booking_service.service;

import com.sgppa.booking_service.dto.BookingDTO;
import com.sgppa.booking_service.entity.Booking;
import com.sgppa.booking_service.mapper.BookingMapper;
import com.sgppa.booking_service.repository.BookingRepository;
import com.sgppa.booking_service.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;
    private BookingDTO bookingDTO;

    @BeforeEach
    void setup() {
        booking = new Booking();
        booking.setId(1L);
        booking.setCitizenName("Mario Rossi");
        booking.setServiceType("Carta d'identità");
        booking.setAppointmentDate(LocalDate.now().plusDays(1));
        booking.setOfficeLocation("Roma Centro");
        booking.setStatus("PENDING");

        bookingDTO = BookingMapper.toDto(booking);
    }

    @Test
    void testCreateBooking() {
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        BookingDTO result = bookingService.create(bookingDTO);

        assertNotNull(result);
        assertEquals("Mario Rossi", result.getCitizenName());
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    void testFindById_found() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Optional<BookingDTO> result = bookingService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Mario Rossi", result.get().getCitizenName());
    }

    @Test
    void testFindById_notFound() {
        when(bookingRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<BookingDTO> result = bookingService.findById(99L);

        assertFalse(result.isPresent());
    }

    @Test
    void testDelete_existing() {
        when(bookingRepository.existsById(1L)).thenReturn(true);

        boolean deleted = bookingService.delete(1L);

        assertTrue(deleted);
        verify(bookingRepository).deleteById(1L);
    }

    @Test
    void testDelete_nonExisting() {
        when(bookingRepository.existsById(99L)).thenReturn(false);

        boolean deleted = bookingService.delete(99L);

        assertFalse(deleted);
        verify(bookingRepository, never()).deleteById(any());
    }
}
