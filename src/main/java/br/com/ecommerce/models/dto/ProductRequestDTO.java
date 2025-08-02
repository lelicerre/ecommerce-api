package br.com.ecommerce.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {
    @NotNull(message = "Code não pode ser nulo")
    @NotEmpty(message = "Code não pode ser nulo")
    private String code;
    private String description;
    @NotNull(message = "Department não pode ser nulo")
    @NotEmpty(message = "Department não pode ser nulo")
    private String department;
    @NotNull(message = "Price não pode ser nulo")
    private Double price;
}
