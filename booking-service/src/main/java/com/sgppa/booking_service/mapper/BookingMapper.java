package com.sgppa.booking_service.mapper;

import com.sgppa.booking_service.dto.BookingDTO;
import com.sgppa.booking_service.entity.Booking;


public class BookingMapper {

    public static BookingDTO toDto(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setCitizenName(booking.getCitizenName());
        dto.setServiceType(booking.getServiceType());
        dto.setAppointmentDate(booking.getAppointmentDate());
        dto.setOfficeLocation(booking.getOfficeLocation());
        dto.setStatus(booking.getStatus());
        return dto;
    }

    public static Booking toEntity(BookingDTO dto) {
        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setCitizenName(dto.getCitizenName());
        booking.setServiceType(dto.getServiceType());
        booking.setAppointmentDate(dto.getAppointmentDate());
        booking.setOfficeLocation(dto.getOfficeLocation());
        booking.setStatus(dto.getStatus());
        return booking;
    }
}
