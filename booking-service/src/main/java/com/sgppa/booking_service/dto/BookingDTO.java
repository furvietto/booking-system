package com.sgppa.booking_service.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    @NotBlank(message = "Il nome del cittadino è obbligatorio")
    private String citizenName;

    @NotBlank(message = "Il tipo di servizio è obbligatorio")
    private String serviceType;

    @NotNull(message = "La data dell'appuntamento è obbligatoria")
    @Future(message = "La data dell'appuntamento deve essere nel futuro")
    private LocalDate appointmentDate;

    @NotBlank(message = "La sede è obbligatoria")
    private String officeLocation;

    @NotBlank(message = "Lo stato è obbligatorio")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$", message = "Lo stato deve essere: PENDING, CONFIRMED o CANCELLED")
    private String status;

}