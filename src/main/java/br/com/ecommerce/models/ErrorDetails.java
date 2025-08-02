package br.com.ecommerce.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}