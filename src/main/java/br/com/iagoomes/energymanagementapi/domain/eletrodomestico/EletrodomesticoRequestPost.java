package br.com.iagoomes.energymanagementapi.domain.eletrodomestico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EletrodomesticoRequestPost(@NotNull Long id, @NotBlank String nome, @NotBlank String modelo, @NotBlank Long potencia) {
}
