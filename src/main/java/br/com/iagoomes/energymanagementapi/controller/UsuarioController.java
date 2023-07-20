package br.com.iagoomes.energymanagementapi.controller;

import br.com.iagoomes.energymanagementapi.controller.mapper.UsuarioMapper;
import br.com.iagoomes.energymanagementapi.domain.usuario.Usuario;
import br.com.iagoomes.energymanagementapi.domain.usuario.UsuarioRequestPost;
import br.com.iagoomes.energymanagementapi.domain.usuario.UsuarioRequestPut;
import br.com.iagoomes.energymanagementapi.domain.usuario.UsuarioResponse;
import br.com.iagoomes.energymanagementapi.repository.UsuarioRepository;
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
@RequestMapping("usuarios")
public class UsuarioController {
    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;
    private final Validator validator;

    public UsuarioController(UsuarioMapper mapper, UsuarioRepository repository, Validator validator) {
        this.mapper = mapper;
        this.repository = repository;
        this.validator = validator;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody UsuarioRequestPost usuarioRequestPost, UriComponentsBuilder uriBuilder) {
        Map<Path, String> validacoesMap = validar(usuarioRequestPost);
        if (!validacoesMap.isEmpty()) return ResponseEntity.badRequest().body(validacoesMap);

        Usuario usuario = mapper.usuarioRequestPostToUsuario(usuarioRequestPost);
        repository.salvar(usuario);
        UsuarioResponse usuarioResponse = mapper.usuarioToUsuarioResponse(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioResponse);
    }

    @GetMapping({"{id}"})
    public ResponseEntity detalhar(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = repository.findByid(id);
        if (usuarioOptional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.usuarioToUsuarioResponse(usuarioOptional.get()));
    }

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok(repository.listar().stream().map(mapper::usuarioToUsuarioResponse).toList());
    }

    @PutMapping("{id}")
    public ResponseEntity atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestPut usuarioRequestPut) {
        Map<Path, String> validacoesMap = validar(usuarioRequestPut);
        if (!validacoesMap.isEmpty()) return ResponseEntity.badRequest().body(validacoesMap);

        Optional<Usuario> usuarioOptional = repository.findByid(id);
        if (usuarioOptional.isEmpty()) return ResponseEntity.notFound().build();
        Usuario usuario = usuarioOptional.get();
        usuario.atualizarDados(usuarioRequestPut);

        return ResponseEntity.ok(mapper.usuarioToUsuarioResponse(usuario));
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
