package br.com.iagoomes.energymanagementapi.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequestPost(@NotNull Long id, @NotBlank String rua, @NotBlank String numero, @NotBlank String bairro,
                                  @NotBlank String cidade, @NotBlank String estado) {
}
