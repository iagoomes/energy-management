package br.com.iagoomes.energymanagementapi.domain.usuario;

import jakarta.validation.constraints.Pattern;

public record UsuarioRequestPut(String nome, String sobrenome,
                                @Pattern(regexp="^\\(\\d{2}\\)\\d{5}-\\d{4}$") String telefone) {
}
