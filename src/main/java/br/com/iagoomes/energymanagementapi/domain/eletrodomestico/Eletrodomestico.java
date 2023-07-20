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

    public void atualizar(EletrodomesticoRequestPut eletrodomesticoRequestPut) {
        if (eletrodomesticoRequestPut.nome() != null && !eletrodomesticoRequestPut.nome().isEmpty()){
            this.setNome(eletrodomesticoRequestPut.nome());
        }
        if (eletrodomesticoRequestPut.modelo() != null && !eletrodomesticoRequestPut.modelo().isEmpty()){
            this.setModelo(eletrodomesticoRequestPut.modelo());
        }
        if (eletrodomesticoRequestPut.potencia() != null && eletrodomesticoRequestPut.potencia() > 0L){
            this.setPotencia(eletrodomesticoRequestPut.potencia());
        }
    }
}
