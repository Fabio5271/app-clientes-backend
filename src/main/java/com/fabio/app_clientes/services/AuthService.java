package com.fabio.app_clientes.services;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fabio.app_clientes.entities.Papel;
import com.fabio.app_clientes.entities.Usuario;
import com.fabio.app_clientes.repositories.UsuarioRepository;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNome(nome)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado:" + nome));

        return new User(usuario.getNome(), usuario.getSenha(), mapRolesToAuthorities(usuario.getPapeis()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Papel> papeis){
        return papeis.stream().map(papel -> new SimpleGrantedAuthority(papel.getNome())).collect(Collectors.toList());
    }
}
