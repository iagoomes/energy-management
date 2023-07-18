package br.com.iagoomes.energymanagementapi.repository;

import br.com.iagoomes.energymanagementapi.domain.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Repository
public class UsuarioRepository {
    List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new Vector<>();
    }

    public void salvar(Usuario Usuario) {
        usuarios.add(Usuario);
    }

    public List<Usuario> listar() {
        return Collections.unmodifiableList(usuarios);
    }

    public Optional<Usuario> findByid(Long id){
        return usuarios.stream().filter(u -> u.getId() == id).findFirst();
    }
}
