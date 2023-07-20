package br.com.iagoomes.energymanagementapi.controller;

import br.com.iagoomes.energymanagementapi.controller.mapper.EnderecoMapper;
import br.com.iagoomes.energymanagementapi.domain.endereco.EnderecoRequestPut;
import br.com.iagoomes.energymanagementapi.domain.endereco.EnderecoResponse;
import br.com.iagoomes.energymanagementapi.domain.endereco.Endereco;
import br.com.iagoomes.energymanagementapi.domain.endereco.EnderecoRequestPost;
import br.com.iagoomes.energymanagementapi.repository.EnderecoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    private final Validator validator;
    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public EnderecoController(Validator validator, EnderecoRepository repository, EnderecoMapper mapper) {
        this.validator = validator;
        this.repository = repository;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody EnderecoRequestPost enderecoRequestPost, UriComponentsBuilder uriComponentsBuilder) {
        Map<Path, String> validacoesMap = validar(enderecoRequestPost);
        if (!validacoesMap.isEmpty()) return ResponseEntity.badRequest().body(validacoesMap);

        Endereco endereco = mapper.enderecoRequestPostToEndereco(enderecoRequestPost);
        repository.salvar(endereco);
        EnderecoResponse enderecoResponse = mapper.enderecoToEnderecoResponse(endereco);
        URI uri = uriComponentsBuilder.path("enderecos/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).body(enderecoResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Optional<Endereco> enderecoOptional = repository.findById(id);
        if (enderecoOptional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.enderecoToEnderecoResponse(enderecoOptional.get()));
    }
    
    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok(repository.listar().stream().map(mapper::enderecoToEnderecoResponse).toList());
    }
    
    @PutMapping({"{id}"})
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody EnderecoRequestPut enderecoRequestPut) {
        Optional<Endereco> enderecoOptional = repository.findById(id);
        if (enderecoOptional.isEmpty()) return ResponseEntity.notFound().build();
        Endereco endereco = enderecoOptional.get();
        endereco.atualizarDados(enderecoRequestPut);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        repository.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private <T> Map<Path, String> validar(T dto) {
        Set<ConstraintViolation<T>> violacoes = validator.validate(dto);

        return violacoes.stream().collect(
                Collectors.toMap(
                        ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
    }
}
