package br.com.iagoomes.energymanagementapi.domain.usuario;

import lombok.Getter;

@Getter
public class Parentesco {
    private Long id;
    private final Pessoa pessoa;
    private final GrauParentesco grauParentesco;

    public Parentesco(Pessoa pessoa, GrauParentesco grauParentesco) {
        this.pessoa = pessoa;
        this.grauParentesco = grauParentesco;
    }

}
