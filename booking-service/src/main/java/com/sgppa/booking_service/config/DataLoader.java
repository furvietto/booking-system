package com.sgppa.booking_service.config;

import com.sgppa.booking_service.entity.Booking;
import com.sgppa.booking_service.repository.BookingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(BookingRepository bookingRepository) {
        return args -> {
            if (bookingRepository.count() == 0) {
                bookingRepository.save(Booking.builder()
                        .citizenName("Mario Rossi")
                        .serviceType("Passaporto")
                        .appointmentDate(LocalDate.now().plusDays(30))
                        .officeLocation("Roma Centro")
                        .status("CONFIRMED")
                        .build());

                bookingRepository.save(Booking.builder()
                        .citizenName("Luigi Verdi")
                        .serviceType("Carta Identità")
                        .appointmentDate(LocalDate.now().plusDays(45))
                        .officeLocation("Milano Centro")
                        .status("PENDING")
                        .build());

                bookingRepository.save(Booking.builder()
                        .citizenName("Anna Bianchi")
                        .serviceType("Patente")
                        .appointmentDate(LocalDate.now().plusDays(15))
                        .officeLocation("Napoli Centro")
                        .status("CANCELLED")
                        .build());
            }
        };
    }
}
