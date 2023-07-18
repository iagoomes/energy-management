package br.com.iagoomes.energymanagementapi.domain.usuario;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
    private Long id;
    private String nome;
    private Sexo sexo;
    private String sobrenome;
    private String telefone;
    private List<Parentesco> parentescos;

    public void atualizarDados(UsuarioRequestPut usuarioPut) {
        if (usuarioPut.nome() != null && !usuarioPut.nome().isEmpty()) {
            this.nome = usuarioPut.nome();
        }
        if (usuarioPut.sobrenome() != null && !usuarioPut.sobrenome().isEmpty()) {
            this.sobrenome = usuarioPut.sobrenome();
        }
        if (usuarioPut.telefone() != null && !usuarioPut.telefone().isEmpty()) {
            this.telefone = usuarioPut.telefone();
        }
    }
}
