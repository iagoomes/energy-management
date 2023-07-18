package br.com.iagoomes.energymanagementapi.controller;

import br.com.iagoomes.energymanagementapi.domain.eletrodomestico.EletrodomesticoRequestPost;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EletrodomesticoController {

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody EletrodomesticoRequestPost eletrodomesticoRequestPost) {


        return ResponseEntity.ok().build();
    }
}
