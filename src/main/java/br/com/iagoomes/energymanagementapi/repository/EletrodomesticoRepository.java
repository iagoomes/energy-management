package br.com.iagoomes.energymanagementapi.repository;

import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.Eletrodomestico;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
@Repository
public class EletrodomesticoRepository {
    List<Eletrodomestico> eletrodomesticos;

    public EletrodomesticoRepository() {
        this.eletrodomesticos = new Vector<>();
    }

    public void salvar(Eletrodomestico eletrodomestico) {
        eletrodomesticos.add(eletrodomestico);
    }

    public List<Eletrodomestico> listar() {
        return Collections.unmodifiableList(eletrodomesticos);
    }
}
