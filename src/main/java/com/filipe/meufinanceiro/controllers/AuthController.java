package com.filipe.meufinanceiro.controllers;

import com.filipe.meufinanceiro.domain.Usuario;
import com.filipe.meufinanceiro.dto.LoginRequestDto;
import com.filipe.meufinanceiro.dto.RegisterDto;
import com.filipe.meufinanceiro.dto.ResponseTokenDto;
import com.filipe.meufinanceiro.infra.security.TokenService;
import com.filipe.meufinanceiro.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto body){
        Usuario usuario = this.repository.findByEmail(body.email()).orElseThrow(()->new RuntimeException("Usuário não encontrado!"));
        if (passwordEncoder.matches(body.senha(),usuario.getSenha())){
            String token = this.tokenService.genarateToken(usuario);
            return ResponseEntity.ok(new ResponseTokenDto(usuario.getUsuario(),token));
        }
        return ResponseEntity.badRequest().build();

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto body){
        Optional<Usuario> usuario = this.repository.findByEmail(body.email());
        if (usuario.isEmpty()){
            Usuario newUsuario = new Usuario();
            newUsuario.setUsuario(body.usuario());
            newUsuario.setEmail(body.email());
            newUsuario.setSenha(passwordEncoder.encode(body.senha()));
            newUsuario.setAtivo("S");
            newUsuario.setSaldo_total(0);
            repository.save(newUsuario);
            String token = this.tokenService.genarateToken(newUsuario);
            return ResponseEntity.ok(new ResponseTokenDto(newUsuario.getUsuario(),token));
        }
        return ResponseEntity.badRequest().build();
    }
}
