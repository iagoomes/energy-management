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
    String rua;
    String numero;
    String bairro;
    String cidade;
    String estado;
}
