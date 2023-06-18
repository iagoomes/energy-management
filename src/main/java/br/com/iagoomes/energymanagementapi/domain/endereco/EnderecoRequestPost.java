package br.com.iagoomes.energymanagementapi.domain.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoRequestPost(@NotBlank String rua, @NotBlank String numero, @NotBlank String bairro,
                                  @NotBlank String cidade, @NotBlank String estado) {
}
