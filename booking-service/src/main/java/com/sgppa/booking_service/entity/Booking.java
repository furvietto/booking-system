package com.sgppa.booking_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome del cittadino è obbligatorio")
    @Column(nullable = false)
    private String citizenName;

    @NotBlank(message = "Il tipo di servizio è obbligatorio")
    @Column(nullable = false)
    private String serviceType;

    @NotNull(message = "La data dell'appuntamento è obbligatoria")
    @Future(message = "La data dell'appuntamento deve essere nel futuro")
    @Column(nullable = false)
    private LocalDate appointmentDate;

    @NotBlank(message = "La sede è obbligatoria")
    @Column(nullable = false)
    private String officeLocation;

    @NotBlank(message = "Lo stato è obbligatorio")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$",
            message = "Lo stato deve essere: PENDING, CONFIRMED o CANCELLED")
    @Column(nullable = false)
    private String status;

}
