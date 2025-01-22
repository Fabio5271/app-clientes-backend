package com.fabio.app_clientes.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.app_clientes.entities.Papel;
import com.fabio.app_clientes.entities.Usuario;
import com.fabio.app_clientes.repositories.PapelRepository;
import com.fabio.app_clientes.repositories.UsuarioRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PapelRepository papelRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUsuario(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByNome(usuario.getNome()).isPresent()) {
            return new ResponseEntity<>("Usuário já existe", HttpStatus.BAD_REQUEST);
        }
        // usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Papel papelUsuario = papelRepository.findByNome("USUARIO").orElseThrow(() -> new RuntimeException("Papel \"USUARIO\" não encontrado."));
        usuario.setPapeis(Set.of(papelUsuario));

        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Usuário registrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getNome(), usuario.getSenha()));
            
            return new ResponseEntity<>("Usuário logado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Usuário ou senha inválidos", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/userinfo")
    public ResponseEntity<String> userInfo(@RequestBody Usuario usuario) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getNome(), usuario.getSenha()));
        } catch (Exception e) {
            return new ResponseEntity<String>("Usuário ou senha inválidos", HttpStatus.UNAUTHORIZED);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getAuthorities().toString();
        String response = "User auths: " + username;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
