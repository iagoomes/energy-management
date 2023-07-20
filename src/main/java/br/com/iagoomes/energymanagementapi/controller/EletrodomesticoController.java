package br.com.iagoomes.energymanagementapi.controller;

import br.com.iagoomes.energymanagementapi.controller.mapper.EletrodomesticoMapper;
import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.*;
import br.com.iagoomes.energymanagementapi.repository.EletrodomesticoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("eletrodomesticos")
public class EletrodomesticoController {
    private final EletrodomesticoMapper mapper;
    private final EletrodomesticoRepository repository;
    private final Validator validator;

    public EletrodomesticoController(EletrodomesticoMapper mapper, EletrodomesticoRepository repository, Validator validator) {
        this.mapper = mapper;
        this.repository = repository;
        this.validator = validator;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody EletrodomesticoRequestPost eletrodomesticoRequestPost, UriComponentsBuilder uriComponentsBuilder) {
        Map<Path, String> validacoesMap = validar(eletrodomesticoRequestPost);
        if (!validacoesMap.isEmpty()) {
            return ResponseEntity.badRequest().body(validacoesMap);
        }

        Eletrodomestico eletrodomestico =
                mapper.eletrodomesticoRequestPostToEletrodomestico(eletrodomesticoRequestPost);

        repository.salvar(eletrodomestico);

        EletrodomesticoResponse eletrodomesticoResponse =
                mapper.eletrodomesticoToEletrodomesticoResponse(eletrodomestico);

        URI uri = uriComponentsBuilder.path("eletrodomesticos/{id}").buildAndExpand(eletrodomestico.getId()).toUri();

        return ResponseEntity.created(uri).body(eletrodomesticoResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Optional<Eletrodomestico> eletrodomesticoOptional = repository.findByid(id);
        if (eletrodomesticoOptional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(
                mapper.eletrodomesticoToEletrodomesticoDetalhamentoResponse(eletrodomesticoOptional.get()));
    }

    @GetMapping
    public ResponseEntity listar() {
        List<Eletrodomestico> eletrodomesticos = repository.listar();
        List<EletrodomesticoResponse> eletrodomesticosResponse =
                eletrodomesticos.stream().map(
                        mapper::eletrodomesticoToEletrodomesticoResponse).toList();
        return ResponseEntity.ok(eletrodomesticosResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody EletrodomesticoRequestPut eletrodomesticoRequestPut) {
        Optional<Eletrodomestico> eletrodomesticoOptional = repository.findByid(id);
        if (eletrodomesticoOptional.isEmpty()) return ResponseEntity.notFound().build();

        Eletrodomestico eletrodomestico = eletrodomesticoOptional.get();
        eletrodomestico.atualizar(eletrodomesticoRequestPut);

        return ResponseEntity.ok(mapper.eletrodomesticoToEletrodomesticoDetalhamentoResponse(eletrodomestico));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        repository.delete(id);
        return ResponseEntity.noContent().build();
    }

    private <T> Map<Path, String> validar(T dto) {
        Set<ConstraintViolation<T>> violacoes = validator.validate(dto);
        return violacoes.stream().collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
    }

}
