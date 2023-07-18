package br.com.iagoomes.energymanagementapi.repository;

import br.com.iagoomes.energymanagementapi.domain.endereco.Endereco;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

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
}
