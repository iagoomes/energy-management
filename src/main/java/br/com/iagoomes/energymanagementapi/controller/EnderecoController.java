package br.com.iagoomes.energymanagementapi.controller;

import br.com.iagoomes.energymanagementapi.controller.mapper.EnderecoMapper;
import br.com.iagoomes.energymanagementapi.controller.mapper.EnderecoResponse;
import br.com.iagoomes.energymanagementapi.domain.endereco.Endereco;
import br.com.iagoomes.energymanagementapi.domain.endereco.EnderecoRequestPost;
import br.com.iagoomes.energymanagementapi.repository.EnderecoRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("endereco")
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
    public ResponseEntity cadastrar(@RequestBody EnderecoRequestPost enderecoRequestPost) {
        Map<Path, String> validacoesMap = validar(enderecoRequestPost);

        if (!validacoesMap.isEmpty()) {
            return ResponseEntity.badRequest().body(validacoesMap);
        }
        Endereco endereco = mapper.enderecoRequestPostToEndereco(enderecoRequestPost);
        repository.salvar(endereco);
        EnderecoResponse enderecoResponse = mapper.enderecoToEnderecoResponse(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoResponse);
    }

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok(repository.listar().stream().map(mapper::enderecoToEnderecoResponse).toList());
    }

    private <T> Map<Path, String> validar(T dto) {
        Set<ConstraintViolation<T>> violacoes = validator.validate(dto);

        return violacoes.stream().collect(
                Collectors.toMap(
                        ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
    }
}
