package br.com.iagoomes.energymanagementapi.domain.usuario;

import lombok.Getter;

@Getter
public class Parentesco {
    private Long id;
    private Usuario usuario;
    private Pessoa pessoa;
    private String descricao_parentesco;
    private GrauParentesco grauParentesco;

    public Parentesco(Usuario usuario, Pessoa pessoa, GrauParentesco grauParentesco) {
        this.usuario = usuario;
        this.pessoa = pessoa;
        this.grauParentesco = grauParentesco;
        gerarDescricao();
    }

    private void gerarDescricao() {
        this.descricao_parentesco = this.usuario.getNome() + " é " + grauParentesco.getDescricao() +
                " " + pessoa.getSexo().getContracao_preposicao() + pessoa.getNome();

    }
}
