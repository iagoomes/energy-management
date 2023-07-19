package br.com.iagoomes.energymanagementapi.domain.eletrodomestico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Eletrodomestico {
    private Long id;
    private String nome;
    private String modelo;
    private Long potencia;
}
