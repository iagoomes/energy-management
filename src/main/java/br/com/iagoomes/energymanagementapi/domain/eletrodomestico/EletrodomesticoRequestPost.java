package br.com.iagoomes.energymanagementapi.domain.eletrodomestico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EletrodomesticoRequestPost(@NotNull(message = "ID não pode ser nulo") Long id, @NotBlank String nome, @NotBlank String modelo, @NotNull Long potencia) {
}
