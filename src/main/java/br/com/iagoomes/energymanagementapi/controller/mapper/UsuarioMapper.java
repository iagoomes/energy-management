package br.com.iagoomes.energymanagementapi.controller.mapper;

import br.com.iagoomes.energymanagementapi.domain.usuario.Usuario;
import br.com.iagoomes.energymanagementapi.domain.usuario.UsuarioRequestPost;
import br.com.iagoomes.energymanagementapi.domain.usuario.UsuarioResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario usuarioRequestPostToUsuario(UsuarioRequestPost usuarioRequestPost);

    UsuarioResponse usuarioToUsuarioResponse(Usuario usuario);

}
