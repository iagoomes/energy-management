package br.com.iagoomes.energymanagementapi.domain.usuario;

import java.util.List;

public record UsuarioResponse(Long id, String nome, Sexo sexo, String telefone, List<Parentesco> parentescos) {
}
