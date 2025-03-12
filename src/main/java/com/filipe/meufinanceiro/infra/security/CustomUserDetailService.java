package com.filipe.meufinanceiro.infra.security;

import com.filipe.meufinanceiro.domain.Usuario;
import com.filipe.meufinanceiro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= this.usuarioRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Usuário não encontrado!"));
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(),usuario.getSenha(), new ArrayList<>());
    }
}
