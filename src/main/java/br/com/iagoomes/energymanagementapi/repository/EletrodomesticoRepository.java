package br.com.iagoomes.energymanagementapi.repository;

import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.Eletrodomestico;
import br.com.iagoomes.energymanagementapi.domain.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public Optional<Eletrodomestico> findByid(Long id) {
        return eletrodomesticos.stream().filter(u -> u.getId() == id).findFirst();
    }

    public void delete(Long id) {
        try {
            Eletrodomestico eletrodomestico = eletrodomesticos.stream().filter(e -> e.getId() == id).findFirst().get();
            eletrodomesticos.remove(eletrodomestico);
        } catch (NoSuchElementException e) {
        }

    }
}
