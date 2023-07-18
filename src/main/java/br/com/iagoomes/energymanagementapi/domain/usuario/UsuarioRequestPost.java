package br.com.iagoomes.energymanagementapi.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record UsuarioRequestPost(@NotNull Long id, @NotBlank String nome, @NotBlank String sobrenome,
                                 @NotBlank @Pattern(regexp="^\\(\\d{2}\\)\\d{5}-\\d{4}$") String telefone,
                                 @NotNull Sexo sexo, @NotNull List<Parentesco> parentescos) {
}
