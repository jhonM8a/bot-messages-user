package com.jochoa.bot.web.controller;

import com.jochoa.bot.domain.Usuario;
import com.jochoa.bot.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/")
public class User {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<Usuario> getUsuario(){
        return usuarioService.getUsuario(1).map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
