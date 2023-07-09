package br.com.iagoomes.energymanagementapi.controller.mapper;

import br.com.iagoomes.energymanagementapi.domain.endereco.Endereco;
import br.com.iagoomes.energymanagementapi.domain.endereco.EnderecoRequestPost;
import br.com.iagoomes.energymanagementapi.domain.endereco.EnderecoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    Endereco enderecoRequestPostToEndereco(EnderecoRequestPost enderecoRequestPost);

    EnderecoResponse enderecoToEnderecoResponse(Endereco endereco);
}
