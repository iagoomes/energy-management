package br.com.iagoomes.energymanagementapi.repository;

import br.com.iagoomes.energymanagementapi.domain.endereco.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EnderecoRepository {
    List<Endereco> enderecos;

    public EnderecoRepository() {
        this.enderecos = new ArrayList<>();
    }

    public void salvar(Endereco endereco) {
        enderecos.add(endereco);
    }

    public List<Endereco> listar() {
        return Collections.unmodifiableList(enderecos);
    }
}
