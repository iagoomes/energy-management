package br.com.iagoomes.energymanagementapi.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private Long id;
    private String nome;
    private Sexo sexo;
}
