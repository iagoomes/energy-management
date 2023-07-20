package br.com.iagoomes.energymanagementapi.domain.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public void atualizarDados(EnderecoRequestPut enderecoRequestPut) {
        if (enderecoRequestPut.rua() != null && !enderecoRequestPut.rua().isEmpty()) {
            setRua(enderecoRequestPut.rua());
        }
        if (enderecoRequestPut.numero() != null && !enderecoRequestPut.numero().isEmpty()) {
            setNumero(enderecoRequestPut.numero());
        }
        if (enderecoRequestPut.bairro() != null && !enderecoRequestPut.bairro().isEmpty()) {
            setBairro(enderecoRequestPut.bairro());
        }
        if (enderecoRequestPut.cidade() != null && !enderecoRequestPut.cidade().isEmpty()) {
            setCidade(enderecoRequestPut.cidade());
        }
        if (enderecoRequestPut.estado() != null && !enderecoRequestPut.estado().isEmpty()) {
            setEstado(enderecoRequestPut.estado());
        }
    }
}
