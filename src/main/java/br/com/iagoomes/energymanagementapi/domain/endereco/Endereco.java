package br.com.iagoomes.energymanagementapi.domain.endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    String rua;
    String numero;
    String bairro;
    String cidade;
    String estado;
}
