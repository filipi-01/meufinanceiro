package com.filipe.meufinanceiro.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @GetMapping
    public ResponseEntity<String> getUser(){
        return  ResponseEntity.ok("Sucesso!");
    }
}
