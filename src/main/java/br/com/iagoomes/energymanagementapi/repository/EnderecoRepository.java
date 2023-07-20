package br.com.iagoomes.energymanagementapi.repository;

import br.com.iagoomes.energymanagementapi.domain.endereco.Endereco;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EnderecoRepository {
    List<Endereco> enderecos;

    public EnderecoRepository() {
        this.enderecos = new Vector<>();
    }

    public void salvar(Endereco endereco) {
        enderecos.add(endereco);
    }

    public List<Endereco> listar() {
        return Collections.unmodifiableList(enderecos);
    }

    public Optional<Endereco> findById(Long id) {
        return enderecos.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void deletar(Long id) {
        try {
            Endereco endereco = enderecos.stream().filter(e -> e.getId() == id).findFirst().get();
            enderecos.remove(endereco);
        } catch (NoSuchElementException e) {
        }
    }
}
