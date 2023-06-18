package br.com.iagoomes.energymanagementapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @GetMapping
    public String listar() {
        return "Hello";
    }
}
