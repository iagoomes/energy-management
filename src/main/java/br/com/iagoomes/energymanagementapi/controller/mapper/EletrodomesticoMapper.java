package br.com.iagoomes.energymanagementapi.controller.mapper;

import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.Eletrodomestico;
import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.EletrodomesticoRequestPost;
import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.EletrodomesticoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EletrodomesticoMapper {
    Eletrodomestico eletrodomesticoRequestPostToEletrodomestico(EletrodomesticoRequestPost eletrodomesticoRequestPost);
    EletrodomesticoResponse eletrodomesticoToEletrodomesticoResponse(Eletrodomestico eletrodomestico);
}
